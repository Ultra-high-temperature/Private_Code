package CI;


public class JZ32 {
    public String PrintMinNumber(int [] numbers) {
        fastSort(numbers,0, numbers.length-1);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            s.append(numbers[i]);
        }
        return s.toString();
    }

    //升序 找第一个比他小的
    public void fastSort(int [] numbers,int start,int end){
        if (start>=end){
            return;
        }
        int i = start;
        int j = end;
        int mid = numbers[start];
        while (i<j){
            while (compare(mid,numbers[j])&&i<j){
                j--;
            }

            while (compare(numbers[i],mid)&&i<j){
                i++;
            }
            if(i<j){
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
        int temp = numbers[i];
        numbers[i] = numbers[start];
        numbers[start] = temp;

        fastSort(numbers,start,i-1);
        fastSort(numbers,i+1,end);
    }

    //a<=b return true
    public boolean compare(int a,int b){
        if(Double.valueOf(a+""+b)<=Double.valueOf(b+""+a)){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[] array = {3,32,321};
        int length = array.length;
//        quicksort(array, 0, length - 1);
        String s = new JZ32().PrintMinNumber(array);
        System.out.printf("");
    }
}
