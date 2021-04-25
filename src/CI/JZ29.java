package CI;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
//给定一个数组，找出其中最小的K个数。
// 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
// 如果K>数组的长度，那么返回一个空的数组
public class JZ29 {
    //构造大顶堆，比较堆顶的值 与 数组剩下的元素 小于堆顶则进行交换
    //等于元素等于堆顶怎么办？
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList<Integer>();
        }

        //初始构造大顶堆 在0 到 k-1范围内构造大顶堆
        //为什么要自顶向下再构建一次大顶堆
        //1,5 7,2 3 4 6 假设有如左的大顶堆，此时从后往前 遍历到7 7>1 swap
        //7,5 1,2 3 4 6 此时子结构 1,4 6 就不满足大顶堆了
        for (int i = k - 1; i > 0; i--) {
            int father = (i - 1) / 2;
            if (input[father] < input[i]) {
                swap(input, i, father);
                adjustHeap(i,input,k-1);
            }
        }

        //遍历剩下的数组
        for (int i = k; i < input.length; i++) {
            if(input[0]>input[i]){
                swap(input,i,0);
                adjustHeap(0,input,k-1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }

    //自顶向下调整大顶堆 i是从哪个节点开始 ，end是堆内最后一个元素的下标
    void adjustHeap(int root,int[] heap,int end){
        int l = 2*root+1;
        int r = 2*root+2;
        if(l<=end&&heap[root]<heap[l]){
            swap(heap,root,l);
            adjustHeap(l,heap,end);
        }
        if(r<=end&&heap[root]<heap[r]){
            swap(heap,root,r);
            adjustHeap(r,heap,end);
        }
    }

    public static void main(String[] args) {
        JZ29 jz29 = new JZ29();
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> integers = jz29.GetLeastNumbers_Solution(arr, 4);
        System.out.printf("");
    }
}
