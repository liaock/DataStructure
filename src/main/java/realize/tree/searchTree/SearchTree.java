package realize.tree.searchTree;

import realize.tree.TreeNode;

/**
 * Created by dell on 2021/9/20.
 */
public class SearchTree<T extends Comparable> {

    private TreeNode tree;

    public SearchTree(TreeNode tree) {
        this.tree = tree;
    }
    public SearchTree() {
        this.tree = new TreeNode(0);
    }

    public TreeNode find(T data){
        TreeNode node = tree;
        while (node != null){
            if(data.compareTo(node.getData())<0){
                node = node.getLeft();
            }else if(data.compareTo(node.getData())>0){
                node = node.getRight();
            }else{
                return node;
            }
        }
        return null;
    }

    public void insert(T data){
        TreeNode p = tree;
        while (p != null) {
            if (data.compareTo(p.getData()) > 0) {
                if (null == p.right) {
                    TreeNode newNode = new TreeNode(data);
                    p.right = newNode;
                    return;
                }
                p = p.getRight();
            } else {
                if (null == p.left) {
                    TreeNode newNode = new TreeNode(data);
                    p.left = newNode;
                    return;
                }
                p = p.getLeft();
            }
        }
    }

    public void delete(T data){
        TreeNode p = tree;
        TreeNode pp = null; // pp记录的是p的父节点.
        while (p != null && pp.getData() != data){
            pp = p;
            if(data.compareTo(p.getData())>0){
                p = p.getRight();
            }else {
                p = p.getLeft();
            }
        }
        if(p == null) return;
        // 要删除的节点有两个子节点
        if(p.left != null && p.right != null){
            // 查找右子树最小节点
            TreeNode minP = p.getRight();
            TreeNode minPP = p; //minP的父节点.
            while (minP.getLeft() != null ){
                p = minP;
                minP = minP.left;
            }
            p.setData(minP.getData());
            p = minP;
            pp = minPP;
        }

        //要删除的是叶子节点或者只有一个字节点
        TreeNode child = null;
        if(p.getLeft() !=null ){
            child = p.getLeft();
        }else if(p.getRight() != null){
            child = p.getRight();
        }else {
            child = null;
        }
        if(pp == null){
            tree = child; // 删除的是根节点
        }else if(pp.left == p){
            pp.left = child;
        }else {
            pp.right = child;
        }
    }

}
