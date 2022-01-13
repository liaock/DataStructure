package practice.leetCode.top200;

import java.util.*;

/**
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 示例 1：
 输入：nums = [-1,0,1,2,-1,-4]
 输出：[[-1,-1,2],[-1,0,1]]
 链接：https://leetcode-cn.com/problems/3sum
 * Created by dell on 2022/1/13.
 */
public class day8_双指针_三数之和_important {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length - 1;
            ArrayList<Integer> list;
            while (left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    set.add(list);
                    left ++;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left ++;
                }else {
                    right --;
                }
            }
        }
        for (List<Integer> list : set) {
            resultList.add(list);
        }
        return resultList;
    }

    public static void main(String[] args) {
        day8_双指针_三数之和_important obj = new day8_双指针_三数之和_important();
        System.out.println(obj.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

}
