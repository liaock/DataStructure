package practice.leetCode.top200;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * Created by dell on 2022/1/20.
 */
public class day14_两数相除 {
    public int divide(int dividend, int divisor) {


        for (int i = dividend; i > 0; i--) {
            int data = 0;
            for (int j = 0; j < divisor; j++) {
                data += i;
            }
            if(data == dividend || data < dividend && data+i>dividend){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        day14_两数相除 obj = new day14_两数相除();
        System.out.println(obj.divide(7,-3));
    }

}
