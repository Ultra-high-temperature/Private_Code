package LC;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LC19 {


    /**
     *
     * @param s string字符串
     * @return string字符串ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<String>> partition (String s) {
//        if (s==null||s.isEmpty()||s.length()==1){
//            return new ArrayList<ArrayList<String>>(Arrays.asList(s));
//        }
        ArrayList<ArrayList<String>> result = new ArrayList();
        ArrayList<String> temp = new ArrayList();
        cut(result ,temp,s, 0);
        return result;
    }

    // 含开头
    public void cut(ArrayList result ,ArrayList<String> temp,String s, int start){
        if(start==s.length()){
            result.add(temp);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start,i)){
                String substring = s.substring(start, i + 1);
                ArrayList<String> fork = new ArrayList<>(temp);
                fork.add(substring);
                cut(result,fork,s,i+1);
            }
        }
    }

    // start end 都包含
    boolean isPalindrome(String s,int start,int end){
        while (start<=end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1";
//        System.out.printf(s.substring(2,5));
        LC19 lc19 = new LC19();
        ArrayList<ArrayList<String>> partition = lc19.partition(s);
        System.out.printf("");
    }
}
