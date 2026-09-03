class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int val : nums1) {
            if (val < minVal) {
                minVal = val;
            }
            if (val % 2 != 0) {
                hasOdd = true;
            }
        }

        
        return !hasOdd || (minVal % 2 != 0);
        
    }
}