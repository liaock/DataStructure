package practice.leetCode.top200;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

  

 示例 1：

 输入：strs = ["flower","flow","flight"]
 输出："fl"
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * Created by dell on 2022/1/13.
 */
public class day7_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        String res="";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != c){
                    return res;
                }
            }
           res += String.valueOf(c);
        }
        return res;
    }

    public static void main(String[] args) {
        day7_最长公共前缀 obj = new day7_最长公共前缀();
        System.out.println(obj.longestCommonPrefix(new String[]{"",""}));
    }
}
