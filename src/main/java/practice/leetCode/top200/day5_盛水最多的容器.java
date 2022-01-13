package practice.leetCode.top200;

/**
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * Created by dell on 2022/1/11.
 */
public class day5_盛水最多的容器 {
    public int maxArea(int[] height) {
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i+1; j < height.length; j++) {
//               if(height[i] >= height[j]){
//                   max = height[j] * (j-i) > max? height[j] * (j-i):max;
//               }else {
//                   max = height[i] * (j-i) > max? height[i] * (j-i):max;
//               }
//            }
//        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left<right){
            if(height[left] >= height[right]){
                   max = height[right] * (right-left) > max? height[right] * (right-left):max;
               }else {
                   max = height[left] * (right-left) > max? height[left] * (right-left):max;
               }
            if(height[left] <= height[right]){
                left ++;
            }else {
                right --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        day5_盛水最多的容器 obj = new day5_盛水最多的容器();
        System.out.println(obj.maxArea(new int[]{1,1}));
    }


}
