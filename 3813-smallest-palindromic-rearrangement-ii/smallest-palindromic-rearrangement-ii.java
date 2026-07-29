class Solution {
    private static final long LIMIT = 1000001L;
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] halfFreq = new int[26];
        int halfLen = 0;
        char midChar = 0;

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
            halfLen += halfFreq[i];
            if (freq[i] % 2 == 1) {
                midChar = (char) ('a' + i);
            }
        }

        
        if (countWays(halfFreq, halfLen) < k) {
            return "";
        }

        StringBuilder leftHalf = new StringBuilder();

        
        for (int pos = 0; pos < halfLen; pos++) {
            for (int ch = 0; ch < 26; ch++) {
                if (halfFreq[ch] == 0) continue;

               
                halfFreq[ch]--;
                long ways = countWays(halfFreq, halfLen - pos - 1);

                if (ways >= k) {
                    leftHalf.append((char) ('a' + ch));
                    break;
                } else {
                    k -= ways;
                    halfFreq[ch]++; 
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(leftHalf);
        if (midChar != 0) {
            result.append(midChar);
        }
        result.append(new StringBuilder(leftHalf).reverse());

        return result.toString();
    }

    
    private long countWays(int[] counts, int total) {
        long res = 1;
        int remaining = total;

        for (int i = 0; i < 26; i++) {
            int c = counts[i];
            for (int j = 1; j <= c; j++) {
                res = res * (remaining - c + j) / j;
                if (res > LIMIT) {
                    return LIMIT;
                }
            }
            remaining -= c;
        }

        return Math.min(res, LIMIT);
        
    }
}