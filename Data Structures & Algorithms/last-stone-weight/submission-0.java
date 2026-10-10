class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer>stonesList = new ArrayList<Integer>();
        for(int i=0;i<stones.length;i++){
            stonesList.add(stones[i]);
        }

    while(stonesList.size()>1){
        Collections.sort(stonesList);
        int max1 = stonesList.get(stonesList.size()-1);
        stonesList.remove(stonesList.size()-1);
        int max2 = stonesList.get(stonesList.size()-1);
        stonesList.remove(stonesList.size()-1);

        int rem = Math.abs(max1-max2);
        if(rem!=0){
            stonesList.add(rem);
        }
    }
    if(stonesList.size()==0){
        return 0;
    }

    return stonesList.get(0);
    }
}
