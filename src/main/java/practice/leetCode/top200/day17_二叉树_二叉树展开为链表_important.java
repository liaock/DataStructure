package practice.leetCode.top200;

import practice.leetCode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * Created by dell on 2022/2/20.
 */
public class day17_二叉树_二叉树展开为链表_important {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preSearch(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }

    private void preSearch(TreeNode root,List<TreeNode> list) {
        if(null != root){
            list.add(root);
            preSearch(root.left,list);
            preSearch(root.right,list);
        }
    }

    public static void main(String[] args) {
        day17_二叉树_二叉树展开为链表_important obj = new day17_二叉树_二叉树展开为链表_important();
        obj.flatten(TreeNode.generateTreeNode(new int[]{1,2,5,3,4,0,6},0));
    }

}
