package realize.stringmatch;

/**
 * 暴力匹配
 * Created by dell on 2021/10/7.
 */
public class BF {

    public void match(String originStr,String matchStr){
        for (int i = matchStr.length() ; i <= originStr.length(); i++) {
            if(this.equals(originStr.substring(i-matchStr.length(),i),matchStr)){
                System.out.println("匹配了");
            }
        }
    }

    private boolean equals(String substring, String matchStr) {
        char[] originChar = substring.toCharArray();
        char[] matchChar = matchStr.toCharArray();
        for (int i = 0; i < originChar.length; i++) {
            if(originChar[i] != matchChar[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BF bf = new BF();
        bf.match("abcdabcdabc","abc");
    }


}
