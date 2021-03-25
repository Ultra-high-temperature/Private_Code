package javaTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;


public class Q1Test {

    //行是所在的节点，列是能去的位置
    static int minValue = Integer.MAX_VALUE;
    static int end;
    static int max;

    public static void dfs(int[][] arr,int now,int nowValue){
        if(nowValue>minValue){
            return;
        }
        if (now==end){
            if(nowValue<minValue){
                minValue=nowValue;
            }
        }
        for (int i = 0; i < max; i++) {
            if(arr[now][i]!=0){
                dfs(arr,i,nowValue+arr[now][i]);
            }
        }
        return;
    }

//    public static void main(String[] args) throws IOException {
//        int[][] arr = new int[1000][1000];
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
//        Integer max0 = Integer.valueOf(reader.readLine());
//        max = max0;
//        String s = reader.readLine();
//        String[] s1 = s.split(" ");
//
//        Integer start = Integer.valueOf(s1[0]);
//        Integer end0 = Integer.valueOf(s1[1]);
//        end = end0;
//
//        while (true) {
//            String[] s2 = reader.readLine().split(" ");
//            int x = Integer.parseInt(s2[0]);
//            int y = Integer.parseInt(s2[1]);
//            int value = Integer.parseInt(s2[2]);
//            if(x==y)
//                break;
//            arr[x][y] = value;
//        }
//        dfs(arr,start,0);
//        if(minValue == Integer.MAX_VALUE){
//            System.out.println(0);
//        }else {
//            System.out.println(minValue);
//        }
//    }

    public int MaxMilk (int[] grass, int[] milk) {

        int num = 0;

        LinkedHashSet<Integer> grassSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> milkSet = new LinkedHashSet<>();
        for (int i = 0; i <grass.length; i++) {
//            int i = getMax(milk);
            if (grassSet.contains(Integer.valueOf(grass[i]))||
                    milkSet.contains(Integer.valueOf(milk[i]))||grassSet.isEmpty()){
                grassSet.add(grass[i]);
                milkSet.add(milk[i]);
                num += milk[i];
            }else {
                checkItem(grass, milk, i,grassSet,milkSet);
            }
        }
        return num;
    }

    private void checkItem(int[] grass, int[] milk, int i, LinkedHashSet<Integer> grassSet, LinkedHashSet<Integer> milkSet) {
        ArrayList<Integer> needRemoveList = new ArrayList<>();
        Integer removedMilk = 0;
        for (int j = 0; j <i; j++) {
            // 寻找与新进来的产生冲突的值，记录需要移除哪些奶牛
            if(grass[j]>grass[i]&&milk[j]<milk[i]){
                needRemoveList.add(j);
                removedMilk += milk[j];
            }
        }
    }



}
