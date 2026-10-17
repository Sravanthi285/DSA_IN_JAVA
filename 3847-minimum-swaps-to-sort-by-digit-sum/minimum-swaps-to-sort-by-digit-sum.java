class Solution {
    static class Element {
        int val;
        int digitSum;
        int originalIndex;

        Element(int val, int originalIndex) {
            this.val = val;
            this.originalIndex = originalIndex;
            this.digitSum = getDigitSum(val);
        }

        private static int getDigitSum(int n) {
            int sum = 0;
            n = Math.abs(n);
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Element[] elements = new Element[n];

        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i);
        }

        // Sort by digitSum first, then by actual value
        Arrays.sort(elements, (a, b) -> {
            if (a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.val, b.val);
        });

        // Track cycles
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // Already visited or already in the correct position
            if (visited[i] || elements[i].originalIndex == i) {
                continue;
            }

            // Find the size of the cycle
            int cycleSize = 0;
            int curr = i;

            while (!visited[curr]) {
                visited[curr] = true;
                curr = elements[curr].originalIndex;
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
        
    }
}