package practice.leetCode.base;

/**
 * Created by dell on 2022/1/9.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generateTreeNode(int []arr,int index){
        TreeNode treeNode = null;
        if(index < arr.length) {
            if(arr[index] == 0){
                return null;
            }
            treeNode = new TreeNode(arr[index]);
            treeNode.left = generateTreeNode(arr, 2 * index + 1);
            treeNode.right = generateTreeNode(arr, 2 * index + 2);
        }
        return treeNode;
    }
}