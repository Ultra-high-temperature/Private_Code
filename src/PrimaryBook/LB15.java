package PrimaryBook;

import java.util.HashMap;

public class LB15 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }

        HashMap<Character , Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i),map2.get(t.charAt(i))+1);
            }else {
                map2.put(t.charAt(i),1);
            }
        }

        return map2.equals(map);
    }

    public static void main(String[] args) {

    }
}
