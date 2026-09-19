class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxAr = 0;
        int n = heights.length;

        for(int i=0;i<=n;i++){
            int curr=0;
            if(i==n){
                curr=0;
            }
            else{
                curr=heights[i];
            }

            while(!stack.isEmpty() && curr<heights[stack.peek()]){
                int top = stack.pop();
                int height = heights[top];
                int width;
                if(stack.isEmpty()){
                    width = i;
                }
                else{
                    width = i-stack.peek()-1;
                }
                maxAr = Math.max(maxAr,height*width);

            }
            stack.push(i);
        }
        return maxAr;
    }
}
