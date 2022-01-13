package practice.leetCode.top200;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * Created by dell on 2022/1/12.
 */
public class day6_罗马数字转整数 {

    public int romanToInt(String s) {
        Map<Character,Integer> roman2IntMap = new HashMap<>();
        roman2IntMap.put('I',1);
        roman2IntMap.put('V',5);
        roman2IntMap.put('X',10);
        roman2IntMap.put('L',50);
        roman2IntMap.put('C',100);
        roman2IntMap.put('D',500);
        roman2IntMap.put('M',1000);

        Map<String,Integer> specialMap = new HashMap<>();
        specialMap.put("IV",4);
        specialMap.put("IX",9);
        specialMap.put("XL",40);
        specialMap.put("XC",90);
        specialMap.put("CD",400);
        specialMap.put("CM",900);

        if(specialMap.containsKey(s)){
            return specialMap.get(s);
        }
        int result = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(i == chars.length-1){
                result += roman2IntMap.get(chars[i]);
            }else if(specialMap.containsKey(String.valueOf(chars[i]) + String.valueOf(chars[i+1]))){
                Integer temp = specialMap.get(String.valueOf(chars[i]) + String.valueOf(chars[i + 1]));
                result += temp;
                i = i + 1;
            }else {
                result += roman2IntMap.get(chars[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        day6_罗马数字转整数 obj = new day6_罗马数字转整数();
        System.out.println(obj.romanToInt("MCMXCIV"));
    }

}
