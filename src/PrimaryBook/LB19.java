package PrimaryBook;

public class LB19 {

    public String countAndSay(int n){
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = say(s);
        }
        return s;
    }

    public String say(String s) {
        StringBuilder result = new StringBuilder();
        int num=1;
        char before = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if(before!=s.charAt(i)){
                buildResultStr(before,num,result);
                before = s.charAt(i);
                num = 0;
            }
            num++;
        }
        buildResultStr(before,num,result);
        return result.toString();
    }
    void buildResultStr(char c,int num,StringBuilder sb){
        sb.append(num).append(c);
    }

    public static void main(String[] args) {
        LB19 lb19 = new LB19();
        String s = lb19.countAndSay(5);
        System.out.printf(s);

    }
}
