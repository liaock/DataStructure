package practice.leetCode.top200;

/**
 * 对称二叉树  https://leetcode-cn.com/problems/symmetric-tree/
 *  给定一个二叉树，检查它是否是镜像对称的。
 *  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * Created by dell on 2022/1/8.
 */
public class day3_二叉树_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
