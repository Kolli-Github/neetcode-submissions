class Solution {
    public boolean isValid(String s) {
        if(s.length()<1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='[' || c=='{' || c=='('){
                stack.push(c);
            }
            else if(c==']'){
                if( stack.peek()!=null && stack.peek()=='['){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if(c=='}'){
                if( stack.peek()!=null && stack.peek()=='{'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if(c==')'){
                if( stack.peek()!=null && stack.peek()=='('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
