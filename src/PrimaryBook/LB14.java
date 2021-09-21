package PrimaryBook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LB14 {
    public int firstUniqChar(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LB14 lb14 = new LB14();
        int loveleetcode = lb14.firstUniqChar("lleettccoo");
        System.out.printf("");
    }
}
