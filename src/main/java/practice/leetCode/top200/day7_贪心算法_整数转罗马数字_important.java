package practice.leetCode.top200;

/**
 *
 * https://leetcode-cn.com/problems/integer-to-roman/
 *
 * Created by dell on 2022/1/12.
 */
public class day7_贪心算法_整数转罗马数字_important {
    public String intToRoman(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String res = "";
        for(int i=0; i<13; i++){
            while(num>=values[i]){
                num -= values[i];
                res += reps[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        day7_贪心算法_整数转罗马数字_important obj = new day7_贪心算法_整数转罗马数字_important();
        System.out.println(obj.intToRoman(1994));
    }

}
