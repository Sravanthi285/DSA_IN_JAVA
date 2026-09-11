class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        
        for (int d : digits) {
            freq[d]++;
        }
        
        int count = 0;
        
        
        for (int num = 100; num <= 999; num++) {
            if (num % 2 != 0) continue; 
            
            int h = num / 100;
            int t = (num / 10) % 10;
            int o = num % 10;
            
            int[] temp = freq.clone();
            
            
            if (temp[h]-- > 0 && temp[t]-- > 0 && temp[o]-- > 0) {
                count++;
            }
        }
        
        return count;
    }
}


        
    