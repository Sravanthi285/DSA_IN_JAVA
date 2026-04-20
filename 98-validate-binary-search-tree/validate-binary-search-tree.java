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
    TreeNode PreviousNode;
    public boolean isValidBST(TreeNode root) {
        return InOrderTraversal(root);
    }
    public boolean InOrderTraversal(TreeNode CurrentNode){
        if(CurrentNode == null) return true;
        if(! InOrderTraversal(CurrentNode.left)) return false;
        if(PreviousNode != null && PreviousNode.val >= CurrentNode.val ) return false;
        PreviousNode = CurrentNode;
        return InOrderTraversal(CurrentNode.right);
    }
}