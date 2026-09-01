class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        // Parse starting position and assign unique IDs to each litter cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        // If there is no litter to collect, 0 moves needed
        if (litterCount == 0) return 0;

        int targetMask = (1 << litterCount) - 1;

        // BFS Queue stores packed state: int[] {r, c, energy, mask, moves}
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];

        queue.offer(new int[]{startR, startC, energy, 0, 0});
        visited[startR][startC][energy][0] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            // If we have collected all litter items
            if (mask == targetMask) {
                return moves;
            }

            // If energy is 0, we can only continue if currently on a reset tile 'R'
            if (e == 0) {
                if (classroom[r].charAt(c) == 'R') {
                    e = energy;
                } else {
                    continue; // Cannot move further
                }
            }

            // Explore 4 adjacent cells
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char cell = classroom[nr].charAt(nc);
                if (cell == 'X') continue;

                int nextE = e - 1;
                // If arriving at a reset tile 'R', energy gets restored to maximum
                if (cell == 'R') {
                    nextE = energy;
                }

                int nextMask = mask;
                if (cell == 'L') {
                    nextMask |= (1 << litterId[nr][nc]);
                }

                if (!visited[nr][nc][nextE][nextMask]) {
                    visited[nr][nc][nextE][nextMask] = true;
                    queue.offer(new int[]{nr, nc, nextE, nextMask, moves + 1});
                }
            }
        }

        return -1;
        
    }
}