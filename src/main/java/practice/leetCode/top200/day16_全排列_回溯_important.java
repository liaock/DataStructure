package practice.leetCode.top200;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * Created by dell on 2022/2/20.
 */
public class day16_全排列_回溯_important {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int index = -1;
        backTrace(nums,tempList,resultList,index);

        return resultList;

    }

    private void backTrace(int[] nums, List<Integer> tempList, List<List<Integer>> resultList, int index) {
        if(tempList.size() >= nums.length){
            resultList.add(new ArrayList<>(tempList));
            tempList = new ArrayList<>();
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!tempList.contains(nums[i])){
                tempList.add(nums[i]);
                backTrace(nums,tempList,resultList,i+1);
                tempList.remove(tempList.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        day16_全排列_回溯_important obj = new day16_全排列_回溯_important();
        List<List<Integer>> permute = obj.permute(new int[]{1});
        System.out.println(permute);
    }

}
