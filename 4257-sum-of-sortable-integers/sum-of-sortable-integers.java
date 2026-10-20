class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Optimization 1: If already completely sorted, all divisors work
        boolean isAlreadySorted = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {
                isAlreadySorted = false;
                break;
            }
        }

        if (isAlreadySorted) {
            int divSum = 0;
            for (int k = 1; k * k <= n; k++) {
                if (n % k == 0) {
                    divSum += k;
                    if (k * k != n) {
                        divSum += (n / k);
                    }
                }
            }
            return divSum;
        }

        int totalSum = 0;

        // Iterate through all divisors k of n
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            if (canSortWithK(nums, sorted, n, k)) {
                totalSum += k;
            }
        }

        return totalSum;
    }

    private boolean canSortWithK(int[] nums, int[] sorted, int n, int k) {
        int numBlocks = n / k;

        for (int b = 0; b < numBlocks; b++) {
            int start = b * k;

            // In a rotated sorted array, there is at most 1 point where nums[i] > nums[i + 1]
            int dropCount = 0;
            int pivot = -1; // Index in [0, k - 1] where the sorted array starts

            for (int j = 0; j < k; j++) {
                int curr = nums[start + j];
                int next = nums[start + (j + 1) % k];

                if (curr > next) {
                    dropCount++;
                    pivot = (j + 1) % k;
                }
            }

            // More than 1 drop means it is impossible to be a cyclic shift of a sorted block
            if (dropCount > 1) {
                return false;
            }

            // If dropCount == 0, the block is already non-decreasing cyclically
            if (dropCount == 0) {
                pivot = 0;
            }

            // Verify element-by-element with the sorted block in O(k)
            for (int j = 0; j < k; j++) {
                if (nums[start + (pivot + j) % k] != sorted[start + j]) {
                    return false;
                }
            }
        }

        return true;
        
    }
}