class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if a palindromic permutation is possible
        int oddCount = 0;
        int oddChar = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddChar = i;
            }
        }
        if (oddCount > 1) {
            return "";
        }

        // Half frequencies for the left side
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLen = n / 2;
        char[] bestCandidate = null;

        // Try exact match on left half (if possible) and check full palindrome
        int[] curFreq = halfFreq.clone();
        char[] prefix = new char[halfLen];
        boolean canMatchPrefix = true;

        for (int i = 0; i < halfLen; i++) {
            int ch = target.charAt(i) - 'a';
            if (curFreq[ch] > 0) {
                prefix[i] = target.charAt(i);
                curFreq[ch]--;
            } else {
                canMatchPrefix = false;
                break;
            }
        }

        if (canMatchPrefix) {
            char[] cand = buildPalindrome(prefix, curFreq, oddChar, n);
            if (cand != null && new String(cand).compareTo(target) > 0) {
                bestCandidate = cand;
            }
        }

        // Try deviating at index i (from rightmost to leftmost in left half)
        for (int i = halfLen - 1; i >= 0; i--) {
            // Restore prefix up to index i - 1
            curFreq = halfFreq.clone();
            boolean validPrefix = true;
            for (int j = 0; j < i; j++) {
                int ch = target.charAt(j) - 'a';
                if (curFreq[ch] > 0) {
                    curFreq[ch]--;
                } else {
                    validPrefix = false;
                    break;
                }
            }
            if (!validPrefix) continue;

            // Find smallest character c > target[i]
            int startChar = target.charAt(i) - 'a' + 1;
            for (int c = startChar; c < 26; c++) {
                if (curFreq[c] > 0) {
                    curFreq[c]--;
                    char[] candHalf = new char[halfLen];
                    for (int j = 0; j < i; j++) {
                        candHalf[j] = target.charAt(j);
                    }
                    candHalf[i] = (char) ('a' + c);

                    // Fill remainder with smallest available characters
                    int idx = i + 1;
                    for (int k = 0; k < 26; k++) {
                        while (curFreq[k] > 0) {
                            candHalf[idx++] = (char) ('a' + k);
                            curFreq[k]--;
                        }
                    }

                    char[] fullCand = buildPalindromeFromHalf(candHalf, oddChar, n);
                    String candStr = new String(fullCand);
                    if (candStr.compareTo(target) > 0) {
                        if (bestCandidate == null || candStr.compareTo(new String(bestCandidate)) < 0) {
                            bestCandidate = fullCand;
                        }
                    }
                    break; // Picked the smallest valid character at index i
                }
            }
        }

        return bestCandidate == null ? "" : new String(bestCandidate);
    }

    private char[] buildPalindrome(char[] prefix, int[] remaining, int oddChar, int n) {
        int halfLen = n / 2;
        char[] full = new char[n];
        for (int i = 0; i < halfLen; i++) {
            full[i] = prefix[i];
            full[n - 1 - i] = prefix[i];
        }
        if (n % 2 != 0) {
            full[halfLen] = (char) ('a' + oddChar);
        }
        return full;
    }

    private char[] buildPalindromeFromHalf(char[] half, int oddChar, int n) {
        int halfLen = n / 2;
        char[] full = new char[n];
        for (int i = 0; i < halfLen; i++) {
            full[i] = half[i];
            full[n - 1 - i] = half[i];
        }
        if (n % 2 != 0) {
            full[halfLen] = (char) ('a' + oddChar);
        }
        return full;
        
    }
}