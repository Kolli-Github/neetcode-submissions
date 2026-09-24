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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root==null){
            return res;
        }
        q.add(root);
        int right = -200;
        
        while(q.size()!=0){
            int qlen = q.size();
            // List<Integer> level = new ArrayList<>();
            // int right = -1;
            for(int i=0;i<qlen;i++){
                TreeNode popped = q.poll();
                if(popped!=null){
                    // level.add(popped.val);
                    right = popped.val;
                    if(popped.left!=null){
                        q.add(popped.left);
                    }
                    if(popped.right!=null){
                        q.add(popped.right);
                    }
                }
            }
            res.add(right);
        }
        return res;
    }
}
