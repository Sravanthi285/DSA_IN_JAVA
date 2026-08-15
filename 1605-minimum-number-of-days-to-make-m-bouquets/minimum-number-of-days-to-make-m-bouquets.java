class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int ans =-1;
         long dist =(long)m*k;
         if(dist > bloomDay.length ){
            return -1;
         }

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

    for(int i= 0;i< bloomDay.length;i++){
      low = Math.min(low,bloomDay[i]);
      high = Math.max(high,bloomDay[i]);

    } while(low <= high ){
    
      int mid =low +(high -low )/2;
      if(solve (mid,m,k,bloomDay)){
      ans  = mid ;
      high = mid-1;
      }else{
        low = mid+1;
      }
      
    }return ans;



    }
    public boolean solve(int mid,int m,int k,int[] bloomDay){
    int   bt =  0;
    int j = 0;
    for(int i =0;i<bloomDay.length;i++){
        if(bloomDay[i] <=mid){
            j++;
            if(j==k ){
                bt++;
                j=0;
            }
            if(bt == m)
            return true;
        }else 
        j = 0;
    }
    return false;
    }
}