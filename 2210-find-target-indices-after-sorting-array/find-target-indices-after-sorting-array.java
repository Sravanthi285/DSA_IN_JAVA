class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThan = 0;
        int countTarget = 0;

        for (int num : nums) {
            if (num < target) {
                lessThan++;
            } else if (num == target) {
                countTarget++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < countTarget; i++) {
            result.add(lessThan + i);
        }

        return result;
        
    }
}