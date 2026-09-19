class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;

        while (r < s.length()) {

            // Add s[r] to the window
            if (map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            } else {
                map.put(s.charAt(r), 1);
            }

            int max = Collections.max(map.values());

            // Shrink while window is invalid
            while ((r - l + 1) - max > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;

                // Recalculate max for the new window
                max = Collections.max(map.values());
            }

            // Window is valid
            res = Math.max(res, r - l + 1);

            // Move right pointer
            r++;
        }

        return res;
    }
}