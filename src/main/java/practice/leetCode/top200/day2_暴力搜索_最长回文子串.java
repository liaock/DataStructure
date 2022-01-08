package practice.leetCode.top200;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 示例 1：
 输入：s = "babad"
 输出："bab"
 解释："aba" 同样是符合题意的答案。
 *
 * Created by dell on 2022/1/8.
 */
public class day2_暴力搜索_最长回文子串 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;
        int index = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            for (int j = i+1; j < charArray.length; j++) {
                if( validPalindromic(charArray,i,j) && j-i+1 > maxLen){
                    index = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(index,index + maxLen);
    }

    public boolean validPalindromic(char[] charArray,int left,int right){
        while (left < right){
            if(charArray[left] != charArray[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
