package practice.leetCode.top200;

import practice.leetCode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2022/1/11.
 */
public class day6_二叉树_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        search(root,list);
        return list;
    }

    private void search(TreeNode root, List<Integer> list) {
        if(null == root){
            return;
        }
        search(root.left,list);
        list.add(root.val);
        search(root.right,list);
    }

    public static void main(String[] args) {
        day6_二叉树_二叉树的中序遍历 obj = new day6_二叉树_二叉树的中序遍历();
        TreeNode treeNode = TreeNode.generateTreeNode(new int[]{1, 0, 2, 3}, 0);
        System.out.println(obj.inorderTraversal(treeNode));
    }

}
