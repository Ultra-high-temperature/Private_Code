package CI;

public class JZ44 {
    public String ReverseSentence(String str) {
        if(str.isEmpty()){
            return str;
        }
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length-1; i >0 ; i--) {
            sb.append(s[i]);
            sb.append(" ");
        }
        sb.append(s[0]);
        return sb.toString();
    }
}
