package practice.leetCode.tree;

import realize.tree.CompBinTree;
import realize.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

 提醒一下，二叉搜索树满足下列约束条件：

 节点的左子树仅包含键 小于 节点键的节点。
 节点的右子树仅包含键 大于 节点键的节点。
 左右子树也必须是二叉搜索树。

 https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * Created by dell on 2021/10/19.
 */
public class 把二叉搜索树转换为累加树 {
    public TreeNode convertBST(TreeNode<Integer> root) {
        //思路， 中序遍历，输出全部.. 然后累加，再生成树.
        List<Integer> list = new ArrayList<Integer>();
        list = generateList(root,list);

        List<Integer> sumList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            int num = 0;
            for(int j=i;j<list.size();j++){
                if(null == list.get(j)){
                    num+=0;
                }else{
                    num+=list.get(j);
                }
            }
            sumList.add(num);
        }
        Integer[]temp = new Integer[sumList.size()];
        return generateTree(sumList.toArray(temp),0);
    }

    private List<Integer> generateList(TreeNode<Integer> root, List<Integer> list) {
        if(root == null){
            return list;
        }
        list = generateList(root.getLeft(), list);
        list.add(root.getData());
        list = generateList(root.getRight(),list);
        return list;
    }

    private   TreeNode generateTree(Integer[] tree, int index) {
        TreeNode treeNode = null;
        if(index < tree.length ) {
            if(tree[index] == null){
                return null;
            }
            treeNode = new TreeNode(tree[index+1]);
            treeNode.left = generateTree(tree, 2*index);
            treeNode.right = generateTree(tree, 2*index+2);
            return treeNode;
        }
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(2);
        TreeNode<Integer> left = new TreeNode<Integer>(1);
        TreeNode<Integer> right = new TreeNode<Integer>(3);
        root.setLeft(left);
        root.setRight(right);
        把二叉搜索树转换为累加树 test = new 把二叉搜索树转换为累加树();
        TreeNode node = test.convertBST(root);
        System.out.println(node);
    }
}
