package practice.leetCode.top200;

/**
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * Created by dell on 2022/1/21.
 */
public class day15_二分查找_搜索旋转排序数组_important {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        day15_二分查找_搜索旋转排序数组_important obj = new day15_二分查找_搜索旋转排序数组_important();
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2},0));
    }
}
