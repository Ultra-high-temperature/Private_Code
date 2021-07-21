package CI;

public class JZ43 {
    public String LeftRotateString(String str,int n) {
        if(str.isEmpty()||n==0){
            return str;
        }
        int move = n%str.length();
        String l = str.substring(0,move);
        String r = str.substring(move);
        return r+l;
    }

    public static void main(String[] args) {
        JZ43 jz43 = new JZ43();
        String abcXYZdef = jz43.LeftRotateString("abcXYZdef", 3);
        System.out.printf("");
    }
}
