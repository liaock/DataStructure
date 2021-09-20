package realize.tree.searchTree;

import realize.tree.TreeNode;

/**
 * Created by dell on 2021/9/20.
 */
public class Main {

    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree(new TreeNode(10));
        searchTree.insert(1);
        searchTree.insert(2);
        searchTree.insert(3);
        searchTree.insert(4);
        searchTree.insert(5);
        searchTree.insert(6);
        searchTree.insert(11);
        searchTree.insert(12);
        searchTree.insert(13);
        searchTree.insert(14);
        searchTree.insert(15);
        searchTree.insert(16);
        searchTree.insert(17);

        TreeNode node = searchTree.find(15);
        System.out.println(node);
    }

}
