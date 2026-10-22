class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        // Find the index of 0
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx = i;
                break;
            }
        }

        // Check Case 1: Increasing cyclic shift
        boolean isIncreasing = true;
        for (int j = 0; j < n; j++) {
            if (nums[(idx + j) % n] != j) {
                isIncreasing = false;
                break;
            }
        }

        if (isIncreasing) {
            // Option 1: Rotate left 'idx' times
            int opt1 = idx;
            // Option 2: Reverse, rotate left (n - idx) times, reverse
            int opt2 = (idx == 0) ? 0 : (n - idx) + 2;
            return Math.min(opt1, opt2);
        }

        // Check Case 2: Decreasing cyclic shift
        boolean isDecreasing = true;
        for (int j = 0; j < n; j++) {
            if (nums[(idx - j + n) % n] != j) {
                isDecreasing = false;
                break;
            }
        }

        if (isDecreasing) {
            // Option 1: Rotate left until 0 is at index n - 1, then reverse
            int opt1 = 1 + ((idx + 1) % n);
            // Option 2: Reverse first, then rotate left until 0 is at index 0
            int opt2 = 1 + (n - 1 - idx);
            return Math.min(opt1, opt2);
        }

        return -1;
    }
}