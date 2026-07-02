class NumArray {
        int[] prefix;
    public NumArray(int[] nums) {
        prefix = nums;
        for(int i=1;i<nums.length;i++){
          nums[i] = nums[i-1] +nums[i];
        }
        
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        if(left==0){
         sum = prefix[right];

        }else{
            sum = prefix[right] - prefix[left - 1];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */