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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null && subRoot!=null){
            return false;
        }
        if(root!=null && subRoot == null){
            return true;
        }
        boolean isSame = isSameTree(root,subRoot);
        if(isSame == true){
            return true;
        }

        boolean checkleft = isSubtree(root.left,subRoot);
        boolean checkright = isSubtree(root.right, subRoot);
        if(checkleft==true || checkright==true){
            return true;
        }

        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }

        boolean lsame = isSameTree(p.left,q.left);
        boolean rsame = isSameTree(p.right,q.right);

        if(lsame==false || rsame == false){
            return false;
        }

        return true;
    }
}
