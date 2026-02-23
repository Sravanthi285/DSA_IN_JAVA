class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> stk = new Stack();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') stk.push(ch);
            else {
                if(stk.isEmpty()) return false;
                char c = stk.peek();
                if(ch == ')' && c == '(' ||
                 ch == '}' && c == '{' ||
                 ch == ']' && c == '[')
                  stk.pop();
                  else return false;
            }
        }
        if(stk.isEmpty()) return true;
        else return false;
    }
}