class Solution {
    public int countCommas(int n) {
        int commas = 0;

     
        if (n >= 1_000) {
            commas += (n - 1_000 + 1);
        }

       
        if (n >= 1_000_000) {
            commas += (n - 1_000_000 + 1);
        }

        
        if (n >= 1_000_000_000) {
            commas += (n - 1_000_000_000 + 1);
        }

        return commas;
        
    }
}