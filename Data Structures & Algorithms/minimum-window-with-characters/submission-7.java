class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;

        int have = 0;
        int need = tmap.size();

        int length = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {

            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (tmap.containsKey(c) &&
                window.get(c).equals(tmap.get(c))) {
                have++;
            }

            while (have == need) {

                if (r - l + 1 < length) {
                    length = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if (tmap.containsKey(leftChar) &&
                    window.get(leftChar) < tmap.get(leftChar)) {
                    have--;
                }

                l++;
            }

            r++;
        }

        return length == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + length);
    }
}