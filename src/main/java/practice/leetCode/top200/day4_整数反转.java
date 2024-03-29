package practice.leetCode.top200;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 假设环境不允许存储 64 位整数（有符号或无符号）。
 * https://leetcode-cn.com/problems/reverse-integer/
 * 示例 1：

 输入：x = 123
 输出：321
 示例 2：

 输入：x = -123
 输出：-321
 * Created by dell on 2022/1/9.
 */
public class day4_整数反转 {

    public int reverse(int x) {
        String s = x + "";
        String resultStr = "";
        if(s.substring(0,1).equals("-")){
            resultStr += "-";
            s = s.replace("-","");
        }
        char[] chars = s.toCharArray();
        for (int i = chars.length-1 ; i >= 0 ; i--) {
            resultStr += chars[i];
        }
        try {
            Integer.valueOf(resultStr);
        } catch (NumberFormatException e) {
           return 0;
        }
        return Integer.valueOf(resultStr);
    }
}
