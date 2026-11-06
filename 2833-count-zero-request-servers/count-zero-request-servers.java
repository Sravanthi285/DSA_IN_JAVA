class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
         Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int m = queries.length;
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }

        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        int[] freq = new int[n + 1];
        int[] answer = new int[m];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] q : sortedQueries) {
            int time = q[0];
            int index = q[1];

            int start = time - x;

            // Add logs within the right boundary
            while (right < logs.length && logs[right][1] <= time) {
                int id = logs[right][0];

                if (freq[id] == 0) {
                    activeServers++;
                }

                freq[id]++;
                right++;
            }

            // Remove logs before the left boundary
            while (left < right && logs[left][1] < start) {
                int id = logs[left][0];

                freq[id]--;

                if (freq[id] == 0) {
                    activeServers--;
                }

                left++;
            }

            answer[index] = n - activeServers;
        }

        return answer;
        
    }
}