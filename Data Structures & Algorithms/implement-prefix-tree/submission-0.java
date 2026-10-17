class PrefixTree {

    HashSet<String> set;

    public PrefixTree() {
         set = new HashSet<String>();
    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        if(set.contains(word)){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        for(String x: set){
            if(x.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}
