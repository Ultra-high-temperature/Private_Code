package PrimaryBook;

public class LB20 {
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length()<len) {
                len = strs[i].length();
            }
        }
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,len);
    }

}
