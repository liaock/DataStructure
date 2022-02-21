package practice.leetCode.top200;

/**
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * Created by dell on 2022/1/20.
 */
public class day13_快慢指针_删除有序数组中的重复项_important {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 1;
        int fast = 1;
        while (fast < nums.length){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                ++ slow;
            }
            fast ++;
        }
        return slow;
    }

    public static void main(String[] args) {
        day13_快慢指针_删除有序数组中的重复项_important obj = new day13_快慢指针_删除有序数组中的重复项_important();
        int []nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(obj.removeDuplicates(nums));
    }
}
