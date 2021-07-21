package CI;

import java.util.ArrayList;
import java.util.Iterator;

public class JZ46 {
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (list.size()!=1){
            if(i==m){
                iterator.remove();
                i=1;
            }else {
                i++;
            }
            if(!iterator.hasNext()){
                iterator = list.iterator();
            }
            iterator.next();

        }
        return list.get(0);
    }

    public static void main(String[] args) {
        JZ46 jz46 = new JZ46();
        int i = jz46.LastRemaining_Solution(5, 3);
        System.out.printf("");
    }
}
