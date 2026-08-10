class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         HashMap<Integer, Integer> map = new HashMap<>();
        long maxSum = 0;
        long currentSum = 0;
        
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            currentSum += nums[right];
            
            while (map.get(nums[right]) > 1 || (right - left + 1) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                currentSum -= nums[left];
                
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                
                left++;
            }
            
            if ((right - left + 1) == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
        
    }
}