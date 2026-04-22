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

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxSum;
    }

    private int[] solve(TreeNode node) {

        if (node == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = solve(node.left);
        int[] right = solve(node.right);

        if (left[0] == 1 && right[0] == 1 &&
            node.val > left[2] && node.val < right[1]) {

            int sum = left[3] + right[3] + node.val;
            maxSum = Math.max(maxSum, sum);

            int min = Math.min(node.val, left[1]);
            int max = Math.max(node.val, right[2]);

            return new int[]{1, min, max, sum};
        }

       
        return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}