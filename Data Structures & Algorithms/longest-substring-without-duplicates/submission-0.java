class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0;
        int r =0;
        HashSet<Character> set = new HashSet<>();
        int max=0;

        while(r<s.length()){
            if(set.contains(s.charAt(r))){
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            else{
                set.add(s.charAt(r));
                max = Math.max(max,set.size());
                r++;
            }
        }

        return max;
    }
}
