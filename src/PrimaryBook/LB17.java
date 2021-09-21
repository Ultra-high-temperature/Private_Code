package PrimaryBook;

public class LB17 {
//    public int myAtoi(String s) {
//        if(s.length()==0){
//            return 0;
//        }
//        int i = 0;
//        boolean symbol = true;
//        while (s.length()>i&&s.charAt(i) == ' ') {
//            i++;
//        }
//        if (Character.isDigit(s.charAt(i))) {
//            symbol = true;
//        } else if (s.charAt(i) == '+') {
//            symbol = true;
//            i++;
//        } else if (s.charAt(i) == '-') {
//            symbol = false;
//            i++;
//        } else {
//            return 0;
//        }
//
//        if(i == s.length()){
//            return 0;
//        }
//
//        StringBuilder str = new StringBuilder();
//        while (i<s.length()&&Character.isDigit(s.charAt(i))&&s.charAt(i)=='0'){
//            i++;
//        }
//        while (i < s.length() && Character.isDigit(s.charAt(i))) {
//            str.append(s.charAt(i++));
//        }
//
//        if(str.length()==0){
//           return 0;
//        }
//
//        String value;
//        if (symbol == true) {
//            value = String.valueOf(Integer.MAX_VALUE);
//        } else {
//            value = String.valueOf(Integer.MIN_VALUE);
//            str = new StringBuilder("-" + str);
//        }
//        if (value.length() > str.length()) {
//            return Integer.valueOf(str.toString());
//        } else if (value.length() < str.length()) {
//            if(symbol == true){
//                return Integer.MAX_VALUE;
//            }else {
//                return Integer.MIN_VALUE;
//            }
//        }
//        for (int j = 0; j < str.length(); j++) {
//            if (str.charAt(j) > value.charAt(j)) {
//                if(symbol == true){
//                    return Integer.MAX_VALUE;
//                }else {
//                    return Integer.MIN_VALUE;
//                }
//            } else if (str.charAt(j) > value.charAt(j)) {
//                return Integer.valueOf(str.toString());
//            }
//        }
//        return Integer.valueOf(str.toString());
//    }

    public int myAtoi(String s) {
        int result = 0;
        int symbol;
        int i = 0;
        if(s.length()==0) return 0;
        while (i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        if(s.length()==i) return 0;
        if(s.charAt(i)=='+'){
            i++;
            symbol = 1;
        }else if(s.charAt(i)=='-'){
            i++;
            symbol = -1;
        }else if(Character.isDigit(s.charAt(i))==true){
            symbol = 1;
        }else {
            return 0;
        }
        int temp;
        while (i<s.length()&&Character.isDigit(s.charAt(i))){
            temp = result;
            result = result*10+(s.charAt(i)-'0');
            if(temp!=result/10){
                if(symbol==1) {
                    return Integer.MAX_VALUE;
                }
                if(symbol==-1) {
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return result*symbol;
    }


    public static void main(String[] args) {
        LB17 lb17 = new LB17();
//        int i = lb17.myAtoi("2147483647");
//        int i1 = lb17.myAtoi("-2147483648");
//
//        int i4 = lb17.myAtoi(" 2147483647 ASD");
//        int i5 = lb17.myAtoi(" -2147483648 asdf");
//
//        int i6 = lb17.myAtoi("d 2147483647 ASD");
//        int i7 = lb17.myAtoi("d -2147483648 asdf");
//
//        int i2 = lb17.myAtoi("6147483647");
//        int i3 = lb17.myAtoi("-6147483648");
//        int i8 = lb17.myAtoi("+-112");
//        int i9 = lb17.myAtoi("+");
//        int i10 = lb17.myAtoi(" -42");
        int i11 = lb17.myAtoi(" ");
        System.out.printf("");
    }
}
