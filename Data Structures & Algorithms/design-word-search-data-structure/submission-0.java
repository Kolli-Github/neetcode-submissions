class TrieNode{

    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;

}
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for(char c:word.toCharArray()){
            int index = c-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root,word,0);
    }

    public boolean dfs(TrieNode node,String word,int index){
        if(node==null){
            return false;
        }

        if(index == word.length()){
            if(node.isEnd == true){
                return true;
            }
            return false;
        }

        char curr = word.charAt(index);

        if(curr != '.'){
            int idx = curr-'a';
            return dfs(node.children[idx],word,index+1);
        }
        else{
            for(TrieNode n:node.children){
                if(n!=null){
                    boolean found = dfs(n,word,index+1);
                    if(found==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
