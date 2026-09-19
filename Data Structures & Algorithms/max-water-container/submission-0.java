class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int area = Integer.MIN_VALUE;
        while(left<right){
            int width = right-left;
            int height = Math.min(heights[left],heights[right]);
            area = Math.max(area,height*width);
            if(heights[left]<=heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
}
