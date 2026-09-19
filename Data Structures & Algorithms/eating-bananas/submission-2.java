class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        int mid=-1;
        int left = 1;
        int right=max;

        while(left<=right){
             mid = left + (right-left)/2;
            int hrs = 0;
            for(int i=0;i<piles.length;i++){
                hrs = hrs + (int)Math.ceil((double)piles[i]/mid);
            }
            if(hrs > h){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return left;
    }
}
