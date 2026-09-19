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

class Solution {

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxHeight(root);
        return result;
    }

    public int maxHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)>1){
            result = false;
            return -1;
        }

        return 1 + (Math.max(leftHeight,rightHeight));
    }
}
