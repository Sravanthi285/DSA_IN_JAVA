class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        // max element as upper bound
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canDivide(nums, threshold, mid)) {
                high = mid;       
            } else {
                low = mid + 1;     
            }
        }

        return low;
    }

    private boolean canDivide(int[] nums, int threshold, int d) {

        int sum = 0;

        for (int num : nums) {
            sum += (num + d - 1) / d;   
        }
         return sum <= threshold;
    }
}