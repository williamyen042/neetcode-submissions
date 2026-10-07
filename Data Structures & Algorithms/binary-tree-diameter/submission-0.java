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
    private int diam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diam;
    }
    private int helper(TreeNode root) {
        //max height, not diam.
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        diam = Math.max(diam, left + right);

        //ca;lc height
        return 1 + Math.max(left, right);
    }
}
