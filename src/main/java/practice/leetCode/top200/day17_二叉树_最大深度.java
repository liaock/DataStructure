package practice.leetCode.top200;

import practice.leetCode.base.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * Created by dell on 2022/2/20.
 */
public class day17_二叉树_最大深度 {

    public int maxDepth(TreeNode root) {
        int deepTh = 1;
        if(root == null){
            return 0;
        }
        int maxDeepTh = search(root, deepTh,deepTh);
        return maxDeepTh;
    }

    private int search(TreeNode root, int deepTh,int maxDeepTh) {
        if(deepTh > maxDeepTh){
            maxDeepTh = deepTh;
        }
        if(root.left != null){
            deepTh ++;
            maxDeepTh = search(root.left, deepTh, maxDeepTh);
            if(root.right != null){
                maxDeepTh = search(root.right,deepTh,maxDeepTh);
            }
        }else {
            if(root.right != null){
                deepTh ++;
                maxDeepTh = search(root.right,deepTh,maxDeepTh);
            }
        }
        return maxDeepTh;
    }


    public static void main(String[] args) {
        day17_二叉树_最大深度 obj = new day17_二叉树_最大深度();
        int i = obj.maxDepth(TreeNode.generateTreeNode(new int[]{3, 9, 20, 0, 0, 15, 7}, 0));
        System.out.println(i);
    }

}
