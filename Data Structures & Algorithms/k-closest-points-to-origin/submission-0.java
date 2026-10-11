class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Arrays.sort(points,(a,b)->{
            int da = (a[0]*a[0]) + (a[1]*a[1]);
            int db = (b[0]*b[0]) + (b[1]*b[1]);
            return Integer.compare(da,db);
        });

        return Arrays.copyOfRange(points,0,k);
    }
}
