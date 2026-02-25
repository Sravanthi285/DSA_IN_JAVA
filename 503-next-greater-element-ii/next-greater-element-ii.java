class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[nums.length];

        for(int i = nums.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[i]){
                s.pop();
            }
            if(!s.isEmpty()) result[i] = s.peek();
            else result[i] = -1;

            s.push(nums[i]);
        }
        for(int i = nums.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[i]){
                s.pop();
            }
            if(!s.isEmpty()) result[i] = s.peek();
            else result[i] = -1;

            s.push(nums[i]);
        }
        return result;
    }
}