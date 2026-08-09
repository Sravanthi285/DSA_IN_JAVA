class Solution {
    private int[][] memo;
    private int[] suffixSum;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo = new int[n][n + 1];
        suffixSum = new int[n];

        // Precompute suffix sums so we can get the total stones from index i to end in O(1)
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return getOptimalStones(0, 1, piles);
    }

    private int getOptimalStones(int i, int M, int[] piles) {
        int n = piles.length;

        // Base case: If current player can take all remaining piles, take them all
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        // Return memoized result if already computed
        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        int maxStones = 0;

        // Try taking X piles where 1 <= X <= 2 * M
        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            
            // Stones taken by current player = Total remaining stones - Stones opponent can get
            int currentStones = suffixSum[i] - getOptimalStones(i + X, nextM, piles);
            maxStones = Math.max(maxStones, currentStones);
        }

        memo[i][M] = maxStones;
        return maxStones;
        
    }
}