package PrimaryBook;

public class LB07 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0 ; i--) {
            if(digits[i]==9){
                digits[i] = 0;
            }else {
                digits[i]+=1;
                break;
            }
        }
        if(digits[0]!=0){
            return digits;
        }else{
            int[] ints = new int[digits.length + 1];
            ints[0]=1;
            for (int i = 1; i < ints.length; i++) {
                ints[i] = digits[i-1];
            }
            return ints;
        }
    }

    public static void main(String[] args) {
        int[] ints = {9, 9, 9, 9, 9, 9};
        LB07 lb07 = new LB07();
        int[] ints1 = lb07.plusOne(ints);
        System.out.printf("");
    }
}
