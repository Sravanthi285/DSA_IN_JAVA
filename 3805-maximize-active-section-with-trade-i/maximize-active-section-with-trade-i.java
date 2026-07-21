class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
  List<Integer> zeroGroupLengths = new ArrayList<>();
        int originalOnes = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                originalOnes++;
            } else {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    int lastIdx = zeroGroupLengths.size() - 1;
                    zeroGroupLengths.set(lastIdx, zeroGroupLengths.get(lastIdx) + 1);
                } else {
                    zeroGroupLengths.add(1);
                }
            }
        }

        int maxZeroMerge = 0;
        for (int i = 1; i < zeroGroupLengths.size(); i++) {
            maxZeroMerge = Math.max(maxZeroMerge, zeroGroupLengths.get(i - 1) + zeroGroupLengths.get(i));
        }

        return originalOnes + maxZeroMerge;
        
    }
}