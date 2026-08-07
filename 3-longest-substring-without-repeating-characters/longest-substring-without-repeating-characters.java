class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);

          
            if (lastSeen[currChar] >= start) {
                start = lastSeen[currChar] + 1;
            }

          
            lastSeen[currChar] = end;

            
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
        
    }
}