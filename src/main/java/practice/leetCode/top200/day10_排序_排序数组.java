package practice.leetCode.top200;

/**
 * Created by dell on 2022/1/16.
 */
public class day10_排序_排序数组 {

    public int[] sortArray(int[] nums) {

        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }

        int mid = partition(nums,left,right);
        quickSort(nums,left,mid-1);
        quickSort(nums,mid+1,right);
    }

    private int partition(int[] nums, int left, int right) {
        int max = nums[right];
        int index = left;
        for (int i = left; i < right; i++) {
            if(nums[i] < max){
                swap(nums,i,index);
                index ++;
            }
        }

        swap(nums,index,right);

        return index;
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }


    public static void main(String[] args) {
        day10_排序_排序数组 obj = new day10_排序_排序数组();
        int[] nums = {5, 2, 3, 1};
        obj.sortArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

}
