/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    int i =0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String values[] = data.split(",");
        return buildTree(values);
    }

    public void dfs(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");

        dfs(root.left,sb);
        dfs(root.right,sb);
    }

    public TreeNode buildTree(String[]values){
        if(values[i].equals("null")){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[i]));
        i++;
        root.left = buildTree(values);
        root.right = buildTree(values);

        return root;
    }
}
