class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;
        boolean isSorted = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                isSorted = false;
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }

        return isSorted ? 0 : k;
        
    }
}