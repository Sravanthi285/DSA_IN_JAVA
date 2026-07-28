class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;

        // Step 1: Extract the first half of the palindromic string
        char[] half = s.substring(0, halfLen).toCharArray();

        // Step 2: Sort the first half to make it lexicographically smallest
        Arrays.sort(half);

        String sortedHalf = new String(half);

        
        String middle = (n % 2 == 1) ? String.valueOf(s.charAt(halfLen)) : "";

       
        String reversedHalf = new StringBuilder(sortedHalf).reverse().toString();

        return sortedHalf + middle + reversedHalf;
        
    }
}