package CI;

import java.util.*;

//https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7
public class JZ27 {

    private ArrayList<String> result = new ArrayList<>();
    private HashSet<String> checkSet = new HashSet<>();
    private String[] chars;
    public ArrayList<String> Permutation(String str) {
        chars = str.split("");
        fuc(0,str);
        Collections.sort(result);
        return result;
    }

    void fuc(int start,String str){
        if(start == str.length()){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                stringBuilder.append(chars[i]);
            }
            boolean contains = checkSet.contains(stringBuilder.toString());
            if (!contains){
                result.add(stringBuilder.toString());
                checkSet.add(stringBuilder.toString());
            }
        }
        for (int i = start; i < str.length(); i++) {
            swap(start,i,chars);
            fuc(start+1, str);
            swap(start,i,chars);
        }
    }

    void swap(int i,int j,String[] list){
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        JZ27 jz27 = new JZ27();
        ArrayList<String> abc = jz27.Permutation("abc");
        System.out.println();
    }

}
