package practice.leetCode.top200;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 * Created by dell on 2022/1/18.
 */
public class day12_hash表_栈_有效的括号 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if(map.values().contains(chars[i])){
                stack.push(chars[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character character = stack.pop();
                if(map.get(chars[i]) != character){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }


    public static void main(String[] args) {
        day12_hash表_栈_有效的括号 obj = new day12_hash表_栈_有效的括号();
        System.out.println(obj.isValid("]"));
    }

}
