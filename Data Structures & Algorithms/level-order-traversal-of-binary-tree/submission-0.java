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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>(); 
        if(root==null){
            return res;
        }
        queue.add(root);

        while(queue.size()!=0){
            int qlen = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<qlen;i++){
                TreeNode popped = queue.poll();
                level.add(popped.val);
                if(popped!=null){
                    if(popped.left!=null){
                        queue.add(popped.left);
                    }
                    if(popped.right!=null){
                        queue.add(popped.right);
                    }
                   
                }
            }
            res.add(level);
            
        }
        return res;
    }
}
