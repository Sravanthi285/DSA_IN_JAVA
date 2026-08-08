class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x; // 0 -> 0, 1 -> 1

        int left = 1;
        int right = x / 2; // Square root of x (for x >= 4) is always <= x / 2
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Equivalent to mid * mid <= x, but prevents integer overflow
            if (mid <= x / mid) {
                ans = mid;     // Store mid as a potential answer
                left = mid + 1; // Try to find a larger square root
            } else {
                right = mid - 1; // mid * mid > x, search left half
            }
        }

        return ans;
        
    }
}