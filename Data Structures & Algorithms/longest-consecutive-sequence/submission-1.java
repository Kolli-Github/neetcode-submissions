class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int res = -1;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)==false){
                int count=1;
                int current = nums[i];

                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                res = Math.max(res,count);

            }
        }
        return res;
    }
}
