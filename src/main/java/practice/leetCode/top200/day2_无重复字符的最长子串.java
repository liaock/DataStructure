package practice.leetCode.top200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * Created by dell on 2022/1/8.
 */

/**
 *  使用滑动窗口解决该问题.
 *
 */
public class day2_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        Map<Integer,Character> recordMap = new HashMap<>();
        List<Character> list = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int maxLen = 0;
       //boolean repeatFlag = false;
        for (int i = 0; i < charArray.length; i++) {
            if(list.contains(charArray[i])){
                //repeatFlag = true;
                maxLen = list.size() > maxLen? list.size():maxLen;
                list = clear(list,list.indexOf(charArray[i]));
            }
            list.add(charArray[i]);
        }
        maxLen = list.size() > maxLen? list.size():maxLen;
        return maxLen;
    }

    private List<Character> clear(List<Character> list, int index) {
        return list.subList(index+1,list.size());
    }


    public static void main(String[] args) {
        day2_无重复字符的最长子串 obj = new day2_无重复字符的最长子串();
        System.out.println(obj.lengthOfLongestSubstring("bbbbbb"));
    }
}
