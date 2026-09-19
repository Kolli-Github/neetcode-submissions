class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            if(s.equals("+")){
                int res = stack.pop() + stack.pop();
                stack.push(res);
            }
            else if(s.equals("-")){
                int four = stack.pop();
                int nine = stack.pop();
                stack.push(nine-four);
            }
            else if(s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(s.equals("/")){
                int four = stack.pop();
                int nine = stack.pop();
                stack.push(nine/four);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
