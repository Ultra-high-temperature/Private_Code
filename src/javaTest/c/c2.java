package javaTest.c;


import java.util.Stack;

public class c2 {

    public double findMedianSortedArrays (int[] A, int[] B) {
        Stack stack=new Stack();
        int a=0;
        int b=0;

        if(A.length==0){
            if((B.length)%2==1)
                return B[(int)B.length/2];
            else
                return ((double)B[B.length/2-1]+(double)B[B.length/2])/2;
        }

        if(B.length==0){
            if((A.length)%2==1)
                return A[(int)A.length/2];
            else
                return ((double)A[A.length/2-1]+(double)A[A.length/2])/2;
        }

        for (int i = 0; i <= (A.length+B.length)/2; i++) {
            if(A[a]<B[b]&&a<A.length){
                stack.add(A[a]);
                a++;
            }else {
                stack.add(B[b]);
                b++;
            }
        }
        if((A.length+B.length)%2==1){
            stack.pop();
            return (double) stack.pop();
        }else {
            int s1= (int)stack.pop();
            int s2= (int)stack.pop();
            return ((double) s1+(double) s2)/2;
        }

    }


    public static void main(String[] args) {
        int numbers[]={};
        int numbers2[]={2,3};
        c2 c2=new c2();
        c2.findMedianSortedArrays(numbers,numbers2);
    }
}
