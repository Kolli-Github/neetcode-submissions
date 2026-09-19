class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            int [] freq = new int[26];
            for(char c:s.toCharArray()){
                freq[c-'a']= freq[c-'a']+1;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<freq.length;i++){
               sb.append('#');
               sb.append(freq[i]);
            }
            String key = sb.toString();
            if(map.containsKey(key)==false){
                map.put(key,new ArrayList<>(List.of(s)));
            }
            else{
                map.get(key).add(s);
            }
        }

        return new ArrayList<>(map.values());
        

    }
}
