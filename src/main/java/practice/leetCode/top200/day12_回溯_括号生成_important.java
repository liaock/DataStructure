package practice.leetCode.top200;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
 *https://leetcode-cn.com/problems/generate-parentheses/
 *
 *
 * 全排列 就用回溯
 * Created by dell on 2022/1/18.
 */
public class day12_回溯_括号生成_important {


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backTrace(ans,0,0,n,new StringBuilder());
        return ans;
    }

    private void backTrace(List<String> ans, int open, int close, int n, StringBuilder stringBuilder) {
        if(stringBuilder.length() == 2*n){
            ans.add(stringBuilder.toString());
            return;
        }

        if(open< n){
            stringBuilder.append('(');
            backTrace(ans,open + 1,close,n,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() -1);
        }

        if(close<open){
            stringBuilder.append(')');
            backTrace(ans,open,close+1,n,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() -1);
        }

    }

    public static void main(String[] args) {
        day12_回溯_括号生成_important obj = new day12_回溯_括号生成_important();
        System.out.println(obj.generateParenthesis(3));
    }
}
