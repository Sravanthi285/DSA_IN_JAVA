class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        
        int maxEl = 0;
        for (int num : nums) {
            maxEl = Math.max(maxEl, num);
        }
        
        
        int T = 1;
        while (T <= maxEl) {
            T <<= 1;
        }
        
       
        boolean[] pairXor = new boolean[T];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }
        
        
        boolean[] tripletXor = new boolean[T];
        for (int x = 0; x < T; x++) {
            if (pairXor[x]) {
                for (int num : nums) {
                    tripletXor[x ^ num] = true;
                }
            }
        }
        
      
        int uniqueCount = 0;
        for (int i = 0; i < T; i++) {
            if (tripletXor[i]) {
                uniqueCount++;
            }
        }
        
        return uniqueCount;
        
    }
}