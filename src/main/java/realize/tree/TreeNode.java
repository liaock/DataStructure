package realize.tree;

/**
 * Created by dell on 2021/9/15.
 */
public class TreeNode<T extends Comparable>{
    T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data){
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public int compareTo(TreeNode o) {
        return this.compareTo(o);
    }
}
