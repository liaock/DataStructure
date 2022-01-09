package practice.leetCode.top200;

import practice.leetCode.base.TreeNode;

/**
 * 对称二叉树  https://leetcode-cn.com/problems/symmetric-tree/
 *  给定一个二叉树，检查它是否是镜像对称的。
 *  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * Created by dell on 2022/1/8.
 *
 * 记得如何根据数组生成二叉树.
 */
public class day3_二叉树_递归_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(!(left == null && right == null || left !=null && right !=null)){
            return false;
        }
        if(left == null  && right == null){
            return true;
        }
        boolean flag1;
        boolean flag2;
        if(left.val == right.val){
            flag1 = isSymmetric(left.left, right.right);
            flag2 = isSymmetric(left.right,right.left);
        }else{
            return false;
        }
        return flag1 && flag2;
    }

    public static void main(String[] args) {
        int []arr = new int[]{1,2,2,0,3,0,3};
        day3_二叉树_递归_对称二叉树 tree = new day3_二叉树_递归_对称二叉树();
        TreeNode treeNode = TreeNode.generateTreeNode(arr, 0);
        boolean symmetric = tree.isSymmetric(treeNode);
        System.out.println(symmetric);
    }



}
