class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        List<Integer> ds = new ArrayList<>();
        function(ds,freq,ans,nums);
        return ans;
    }

    public void function(List<Integer> ds, boolean[]freq, List<List<Integer>> ans, int[]nums){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<freq.length;i++){
            if(freq[i]==false){
                freq[i]=true;
                ds.add(nums[i]);
                function(ds,freq,ans,nums);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}
