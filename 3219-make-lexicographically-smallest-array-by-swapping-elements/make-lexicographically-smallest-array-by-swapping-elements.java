class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Store (value, originalIndex) pairs
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort pairs by value
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int i = 0;

        while (i < n) {
            int j = i + 1;
            // Expand group while adjacent sorted values differ by at most limit
            while (j < n && pairs[j][0] - pairs[j - 1][0] <= limit) {
                j++;
            }

            // Extract all original indices belonging to this group
            int groupSize = j - i;
            int[] indices = new int[groupSize];
            for (int k = 0; k < groupSize; k++) {
                indices[k] = pairs[i + k][1];
            }

            // Sort the indices to place values greedily from left to right
            Arrays.sort(indices);

            // Assign sorted values to sorted indices
            for (int k = 0; k < groupSize; k++) {
                result[indices[k]] = pairs[i + k][0];
            }

            // Move to the next group
            i = j;
        }

        return result;
        
    }
}