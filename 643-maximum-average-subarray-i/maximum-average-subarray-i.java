class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int previousSum = 0;
        for(int i = 0;i<k;i++){
            previousSum +=  nums[i]; }
           int   max = previousSum;
        for( int  i = k ;i< nums.length;i++){
            previousSum = previousSum - nums[i-k] +nums[i];
            if(previousSum > max){
                max= previousSum;
            }
        }
        
        return (double) max / k;
    }
}