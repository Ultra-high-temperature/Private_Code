package CI;

public class JZ49 {
    public int StrToInt(String str) {
        if(str.isEmpty()){
            return 0;
        }
        double result = 0;
        //true 正数
        boolean symbol = true;
        int length = str.length();
        int startIndex = 0;
        if(str.charAt(0) == '-'){
            symbol = false;
            startIndex = 1;
        }else if(str.charAt(0) == '+'){
            startIndex = 1;
        }
        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c<'0'||c>'9'){
                return 0;
            }
            int value = c-48;
            result += value*Math.pow(10, length - i-1);
        }
        if(symbol==false){
            result*=-1;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        JZ49 jz49 = new JZ49();
        int i = jz49.StrToInt("-214a47");
        System.out.println();
    }
}
