class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)==false){
                map.put(i,1);
            }
            else{
                map.put(i,map.get(i)+1);
            }
        }

        List<Integer> vals = new ArrayList<>(map.values());
        Collections.sort(vals,Collections.reverseOrder());
        List<Integer>fin = new ArrayList<>();
        for(int i=0;i<k;i++){
            fin.add(vals.get(i));
        }
        List<Integer>res = new ArrayList<>();
        for(int z:map.keySet()){
            if(fin.contains(map.get(z))){
                res.add(z);
            }
        }
        int[] arr = new int[k];
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }

        return arr;

    }
}
