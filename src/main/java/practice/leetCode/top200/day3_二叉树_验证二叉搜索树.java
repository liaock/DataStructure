package practice.leetCode.top200;

import practice.leetCode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

 有效 二叉搜索树定义如下：

 节点的左子树只包含 小于 当前节点的数。
 节点的右子树只包含 大于 当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by dell on 2022/1/8.
 */
public class day3_二叉树_验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> list = new ArrayList<>();
        midSearch(root,list);
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i+1)<= list.get(i)){
                return false;
            }
        }
        return true;
    }

    private void midSearch(TreeNode root, List<Integer> list) {
            if(root == null) {
                return;
            }
            midSearch(root.left, list);
            list.add(root.val);
            midSearch(root.right, list);
        }


    public static void main(String[] args) {
        int []arr = new int[]{5,1,4,0,0,3,6};
        day3_二叉树_验证二叉搜索树 day3_tree = new day3_二叉树_验证二叉搜索树();
        TreeNode treeNode = TreeNode.generateTreeNode(arr, 0);
        boolean validBST = day3_tree.isValidBST(treeNode);
        System.out.println(validBST);
    }
}
