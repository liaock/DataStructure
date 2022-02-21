package practice.leetCode.top200;

import practice.leetCode.base.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * Created by dell on 2022/2/20.
 */
public class day16_广度优先_二叉树_二叉树的中层遍历_important {

//    /**
//     *  方法一： Map 分层.
//     * @param root
//     * @return
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> resultList = new ArrayList<>();
//        if(root == null){
//            return resultList;
//        }
//
//        Map<Integer,List<Integer>> levelMap = new HashMap<>();
//        caculate(root,levelMap,1);
//        for (List<Integer> list : levelMap.values()) {
//            resultList.add(list);
//        }
//
//        return resultList;
//    }
//
//    private void caculate(TreeNode root, Map<Integer, List<Integer>> levelMap, int level) {
//        List<Integer> tempList;
//        if(null != levelMap.get(level)){
//            tempList = levelMap.get(level);
//        }else{
//            tempList = new ArrayList<>();
//            levelMap.put(level,tempList);
//        }
//        tempList.add(root.val);
//
//        if(root.left != null){
//            level = level + 1;
//            caculate(root.left,levelMap,level);
//            if(root.right != null){
//                caculate(root.right,levelMap,level);
//            }
//        }else {
//            if(root.right != null){
//                level = level + 1;
//                caculate(root.right,levelMap,level);
//            }
//        }
//
//    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.size() > 0){
            List<Integer> tempList = new ArrayList<>();
            resultList.add(tempList);
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

        }

        return resultList;
    }


    public static void main(String[] args) {
        day16_广度优先_二叉树_二叉树的中层遍历_important obj = new day16_广度优先_二叉树_二叉树的中层遍历_important();
        List<List<Integer>> lists = obj.levelOrder(TreeNode.generateTreeNode(new int[]{1,2,3,0,0,5}, 0));
        System.out.println(lists);
    }

}
