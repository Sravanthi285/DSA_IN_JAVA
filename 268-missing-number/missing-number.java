class Solution {
    public int missingNumber(int[] nums) {
         int xor = 0;
        int n = nums.length;

        // XOR all indices and elements
        for (int i = 0; i < n; i++) {
            xor ^= i;        // XOR index
            xor ^= nums[i];  // XOR value
        }

        // XOR with n (last number)
        xor ^= n;

        return xor;
        
    }
}