class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int minPos = 0;
        int maxPos = 0;

        // Step 1: Locate the indices of min and max elements
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minPos]) {
                minPos = i;
            }
            if (nums[i] > nums[maxPos]) {
                maxPos = i;
            }
        }

        // Order indices such that left <= right
        int left = Math.min(minPos, maxPos);
        int right = Math.max(minPos, maxPos);

        // Step 2: Compute cost for each of the 3 strategies
        int removeBothFromFront = right + 1;
        int removeBothFromBack = n - left;
        int removeFromBothSides = (left + 1) + (n - right);

        // Step 3: Return the minimum deletions
        return Math.min(removeBothFromFront, Math.min(removeBothFromBack, removeFromBothSides));
        
    }
}