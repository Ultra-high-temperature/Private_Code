package javaTest;

public class c8 {

    public int atoi (String str) {
        if(str.isEmpty()){
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean f = false;

        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            if(c1=='-'){
                f=true;
                continue;
            }
            if(c1=='+'){
                continue;
            }
            int a = (int)c1-48;
            if(a>=0&&a<=9){
                stringBuilder.append(a);
            }
            else if(a!=-16){
                break;
            }
        }
        String s = stringBuilder.toString();
        if(s.length()>String.valueOf(Integer.MAX_VALUE).length()){
            if(f){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }else if(s.length()==String.valueOf(Integer.MAX_VALUE).length()) {
            String integer_max = String.valueOf(Integer.MAX_VALUE);
            for (int i = 0; i < s.length(); i++) {
                if(integer_max.charAt(i)>s.charAt(i)){
                    break;
                }else if(integer_max.charAt(i)<s.charAt(i)){
                    if(f){
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }
            }
        }

        if(f){
            s="-"+s;
        }
        return Integer.valueOf(s);
    }

    public static void main(String[] args) {
        int atoi = new c8().atoi(" 55510441643317");
        System.out.println(atoi);
    }
}
