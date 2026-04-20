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
    int SecondMinimumValue = -1;
    public int findSecondMinimumValue(TreeNode root) {
        int MinimumValue = root.val;
        SecondMin(root, MinimumValue);
        return SecondMinimumValue;
        
    }
    private void SecondMin(TreeNode Node,int CurrentMinimumValue){
        if(Node == null)return;
        SecondMin(Node.left,CurrentMinimumValue);
        SecondMin(Node.right,CurrentMinimumValue);
        if(Node.val > CurrentMinimumValue){
            if(SecondMinimumValue == -1){
                SecondMinimumValue = Node.val;
            }else{
                SecondMinimumValue = Math.min( SecondMinimumValue, Node.val);
            }
        }
        
    }
}