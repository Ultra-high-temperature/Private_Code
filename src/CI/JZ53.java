package CI;

import java.util.*;
import java.util.stream.Stream;

public class JZ53 {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch,2);
        }else {
            map.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (Map.Entry entry :map.entrySet()) {
            if((Integer) entry.getValue() == 1){
                return (Character) entry.getKey();
            }
        }
        return '#';
    }
}
