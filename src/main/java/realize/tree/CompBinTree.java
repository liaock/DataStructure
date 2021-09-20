package realize.tree;

/**
 * 完全二叉树
 * Created by dell on 2021/9/15.
 */
public class CompBinTree {


    public static void main(String[] args) {
        Integer [] tree = {1,2,3,4,5,6,7,8,9};
        CompBinTree compBinTree = new CompBinTree();
        TreeNode root = generateTree(tree,0);
        //compBinTree.preOrder(root);
          compBinTree.inOrder(root);
//        compBinTree.postOrder(root);
    }

    private static TreeNode generateTree(Integer[] tree, int index) {
        TreeNode treeNode = null;
        if(index < tree.length ) {
            if(tree[index] == null){
                return null;
            }
            treeNode = new TreeNode(tree[index]);
            treeNode.left = generateTree(tree, 2*index+1);
            treeNode.right = generateTree(tree, 2*index+2);
            return treeNode;
        }
        return treeNode;
    }

    private void postOrder(TreeNode root) {
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.getData());
    }

    private void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.println(root.getData());
        preOrder(root.right);
    }

    private void preOrder(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.println(root.getData());
        preOrder(root.left);
        preOrder(root.right);
    }
}
