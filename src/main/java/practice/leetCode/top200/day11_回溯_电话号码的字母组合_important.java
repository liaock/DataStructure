package practice.leetCode.top200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Created by dell on 2022/1/17.
 */
public class day11_回溯_电话号码的字母组合_important {

    public List<String> letterCombinations(String digits) {
        HashMap<Character,List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));

        List<String> resultList = new ArrayList<>();
        if (digits.length() == 0) {
            return resultList;
        }
        char[] chars = digits.toCharArray();
        String str = "";
        backTrace(resultList,map,digits.toCharArray(),str,0);

        return resultList;
    }

    private void backTrace(List<String> resultList, HashMap<Character, List<String>> map, char[] chars, String str,int index) {
        if(index == chars.length){
            resultList.add(str);
            return;
        }

        List<String> curList = map.get(chars[index]);
        for (int i = 0; i < curList.size(); i++) {
            str += curList.get(i);
            backTrace(resultList,map,chars,str,index + 1);
            str = str.substring(0,str.length()-1);
        }
    }


    public static void main(String[] args) {
        day11_回溯_电话号码的字母组合_important obj = new day11_回溯_电话号码的字母组合_important();
        System.out.println(obj.letterCombinations(""));
    }

}
