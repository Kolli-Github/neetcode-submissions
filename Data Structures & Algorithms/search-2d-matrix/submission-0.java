class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int idx = -1;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==target){
                return true;
            }
            else if(matrix[i][n-1]==target){
                return true;
            }
            else if(matrix[i][0]<target && target<matrix[i][n-1]){
                idx =i;
            }
        }

        if(idx == -1){
            return false;
        }

        int arr[] = matrix[idx];
        int left =0;
        int right = arr.length-1;
        int mid = 0;

        while(left<=right){
            mid = left + (right-left)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return false;
    }
}
