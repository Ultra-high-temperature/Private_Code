package javaTest;

public class c10 {
    public boolean isMatch(String s, String p) {
        //判断是否有*
        if (p.indexOf("*")!=-1){
            return true;
        }
        //判断s.length() > p.length()
        if (s.length() > p.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==p.charAt(i)||p.charAt(i)=='.'){
                continue;
            }else {
                return false;
            }
        }
        //遍历字符串 ,逐一对比
        return true;
    }

    public static void main(String[] args) {
        boolean match = new c10().isMatch("", "*");
        System.out.println(match);
    }
}
