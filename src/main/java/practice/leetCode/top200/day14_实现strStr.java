package practice.leetCode.top200;

/**
 * Created by dell on 2022/1/20.
 */
public class day14_实现strStr {

    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        if(haystack == ""){
            return -1;
        }

        int len = needle.length();
        int start = 0;
        int end = start + len;
        while (end <= haystack.length()){
            if(haystack.substring(start,end).equals(needle)){
                return start;
            }else {
                start ++;
                end = start + len;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        day14_实现strStr obj = new day14_实现strStr();
        System.out.println(obj.strStr("abc","c"));
    }
}
