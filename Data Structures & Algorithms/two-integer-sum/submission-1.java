class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int first = nums[i];
            
                for(int j=i+1;j<nums.length;j++){
                    if(first + nums[j] == target){
                        res[0]=i;
                        res[1]=j;
                    }
                }
            
        }
        Arrays.sort(res);
        return res;
    }
}
