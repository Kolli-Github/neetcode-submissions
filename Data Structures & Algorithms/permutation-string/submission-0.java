class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i=0;i<s1.length();i++){
            int idx = s1.charAt(i)-'a';
            freq1[idx]++;
        }

        int l=0;
        int r=s1.length()-1;

        for(int i=l;i<=r;i++){
                int idx = s2.charAt(i)-'a';
                freq2[idx]++;
            }

        if(Arrays.equals(freq1,freq2)){
                return true;
            }

        while(r<s2.length()-1){
            int idx = s2.charAt(l)-'a';
            freq2[idx]--;
            l++;
            idx = s2.charAt(r+1)-'a';
            freq2[idx]++;
            r++;
            
            if(Arrays.equals(freq1,freq2)){
                return true;
            }

        }

        return false;
    }
}
