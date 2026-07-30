class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;

        if (n <= 8) {
            ans = n * 1;
        } else if (n <= 16) {
            ans = 8 * 1 + (n - 8) * 2;
        } else if (n <= 24) {
            ans = 8 * 1 + 8 * 2 + (n - 16) * 3;
        } else {
            ans = 8 * 1 + 8 * 2 + 8 * 3 + (n - 24) * 4;
        }

        return ans;
        
    }
}