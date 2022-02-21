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
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack stack = new Stack();
        for (char achar : chars) {
            if(map.keySet().contains(achar)){
                stack.push(achar);
            }else {
                if(stack.size() == 0){
                    return false;
                }
                Character pop = (Character) stack.pop();
                if(map.get(pop) != achar){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }


    public static void main(String[] args) {
        day12_hash表_栈_有效的括号 obj = new day12_hash表_栈_有效的括号();
        System.out.println(obj.isValid("[[]]"));
    }

}
