class TimeMap {

    HashMap<String, List<String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<String> list = new ArrayList<>();
            String fin = value + ":" + Integer.toString(timestamp);
            list.add(fin);
            map.put(key, list);
        }
        else {
            List<String> list = map.get(key);
            String fin = value + ":" + Integer.toString(timestamp);
            list.add(fin);
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<String> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;
        String ans = "";

        while (l <= r) {

            int m = l + (r - l) / 2;

            String arr[] = list.get(m).split(":");
            int currentTimestamp = Integer.parseInt(arr[1]);

            if (currentTimestamp == timestamp) {
                return arr[0];
            }

            if (currentTimestamp < timestamp) {
                ans = arr[0];
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        return ans;
    }
}