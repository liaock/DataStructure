package practice.leetCode.top200;

/**
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Created by dell on 2022/1/24.
 */
public class day15_二分查找_在排序数组中查找元素的第一个和最后一个位置_important {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length;
        int []result = new int[2];
        while (left <= right){
            int mid = (left+right)/2;
            if(mid >= nums.length) break;
            if(nums[mid] == target){
                result[0] = mid;
                result[1] = mid;
                while (mid-1>=left && nums[mid-1] == target ){
                    mid = mid - 1;
                    result[0] = mid;
                }

                while (mid+1 < nums.length && mid+1<=right && nums[mid+1] == target ){
                    mid = mid + 1;
                    result[1] = mid;
                }
                return result;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }


        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        day15_二分查找_在排序数组中查找元素的第一个和最后一个位置_important obj = new day15_二分查找_在排序数组中查找元素的第一个和最后一个位置_important();
        int[] ints = obj.searchRange(new int[]{1}, 1);
        System.out.println("["+ints[0] + "," +ints[1]+"]");
    }
}
