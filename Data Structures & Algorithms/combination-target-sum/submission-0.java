class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(0,nums,target, res, new ArrayList<>());
        return res;
    }

    public void findCombinations(int index,int[]nums, int target, List<List<Integer>> ans, List<Integer> ds ){
        if(index==nums.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(nums[index]<=target){
            ds.add(nums[index]);
            findCombinations(index,nums,target-nums[index],ans,ds);
            ds.remove(ds.size()-1);
            
        }
        findCombinations(index+1,nums,target,ans,ds);
    }
}
