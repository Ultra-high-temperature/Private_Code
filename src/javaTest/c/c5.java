package javaTest.c;

public class c5 {

    public String aba(String s){
        int large = s.length();
        int maxBasePoint = 0, maxMove = 0;

        int basePoint, move;
        //形如 qwerrewq 是回文串,需要加以处理

        for (int i = 0; i < s.length(); i++) {//回文串中点
            basePoint =i; move = 0;
            for (int j = 1; j < 501; j++) {
                if (i - j < 0 || i + j > s.length() - 1) {
                    break;
                }
                if (s.charAt(i-j)==s.charAt(i+j)){
                    move++;
                }
            }
            if (move>maxMove){
                maxBasePoint=basePoint;
                maxMove=move;
            }
        }
        String substring = s.substring(maxBasePoint - maxMove, maxBasePoint + maxMove+1);
        return substring;
    }

    public String abba(String s){
        int large = s.length();
        int maxBasePoint = 0, maxNextPoint=1,maxMove = 0;

        int basePoint, nextPoint,move;
        //形如 qwerrewq 是回文串,需要加以处理

        for (int i = 0; i < s.length(); i++) {//回文串中点
            basePoint =i; nextPoint = i+1; move = 0;
            for (int j = 0; j < 501; j++) {
                if (basePoint - j < 0 || nextPoint + j > s.length() - 1) {
                    break;
                }
                if (s.charAt(basePoint-j)==s.charAt(nextPoint+j)){
                    move++;
                }
            }
            if (move>maxMove){
                maxBasePoint=basePoint;
                maxNextPoint=nextPoint;
                maxMove=move;
            }
        }
        String substring = s.substring(maxBasePoint - maxMove+1, maxNextPoint + maxMove);
        return substring;
    }
    public String longestPalindrome(String s) {
        String aba = aba(s);
        String abba= abba(s);
        if(aba.length()>abba.length()){
            return aba;
        }else {
            return abba;
        }
    }

    public static void main(String[] args) {
        String aba = new c5().longestPalindrome("baabcbaba");
        System.out.println(aba);
    }
}
