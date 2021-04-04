package CI;

//https://www.nowcoder.com/practice/0e26e5551f2b489b9f58bc83aa4b6c68
public class JZ2 {
    //库函数天下第一
    public String replaceSpace0 (String s) {
        return s.replaceAll(" ", "%20");
    }

    public String replaceSpace (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

        public static void main(String[] args) {
        JZ2 jz2 = new JZ2();
        jz2.replaceSpace(" helloworld ");
    }
}
