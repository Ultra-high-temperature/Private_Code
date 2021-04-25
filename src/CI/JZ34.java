package CI;

import java.util.*;

public class JZ34 {

    //蠢到爆的高级API版
    public int FirstNotRepeatingChar1(String str) {
        //记录key 字符 value 下标
        LinkedHashMap<Character,Integer> indexMap = new LinkedHashMap();
        LinkedHashSet<Character> numSet = new LinkedHashSet();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(indexMap.containsKey(c)){
                numSet.add(c);
            }else {
                indexMap.put(c,i);
            }
        }
        Set<Character> characters = indexMap.keySet();
        characters.removeAll(numSet);
        Optional<Character> optional = characters.stream().findFirst();
        Character first = null;
        if(optional.isPresent()){
            first = optional.get();
        }
        if(first!=null&&indexMap.get(first)!=null){
            return indexMap.get(first);
        }else {
            return -1;
        }
    }

    //稍加优化
    public int FirstNotRepeatingChar2(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),-1);
            }else {
                map.put(str.charAt(i),i);
            }
        }
        for (Map.Entry<Character, Integer> entry:
             map.entrySet()) {
            if(entry.getValue()!=-1){
                return entry.getValue();
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0){
            return -1;
        }
        //英文字母的ascii码小于122
        int[] arr = new int[128];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if(arr[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }

        public static void main(String[] args) {
        JZ34 jz34 = new JZ34();
        int google = jz34.FirstNotRepeatingChar("google");
        System.out.printf("");

    }
}
