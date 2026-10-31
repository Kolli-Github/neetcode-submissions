class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }

    public void backtrack(int index,int[] nums, List<Integer>curr, List<List<Integer>>res){
        if(index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(index+1,nums,curr,res);
        curr.remove(curr.size()-1);
        int next = index+1;
        while(next<nums.length && nums[index]==nums[next]){
            next++;
        }
        backtrack(next,nums,curr,res);
    }
}
