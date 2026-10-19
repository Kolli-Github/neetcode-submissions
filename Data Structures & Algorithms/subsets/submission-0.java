class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0,nums,new ArrayList<>());
        return result;
    }

    public void backtrack(int index, int[] nums, List<Integer> curr){
        if(index == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        backtrack(index+1,nums,curr);

        curr.remove(curr.size()-1);
        backtrack(index+1,nums,curr);
    }
}
