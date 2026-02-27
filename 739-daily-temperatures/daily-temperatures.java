class Solution {
    public int[] dailyTemperatures(int[] temperature) {
        int n =temperature.length;
      Stack<Integer> s = new Stack<>();
      int [] result = new int[n];

      for(int i = n-1;i>=0;i--){

        while(!s.isEmpty() && temperature[s.peek()]<= temperature[i]){
            s.pop();
        }

        if(!s.isEmpty()) result[i] =s.peek()-i;
        else result[i] = 0;

        s.push(i);
      }
          return result;
    }
}