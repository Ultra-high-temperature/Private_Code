package javaTest.c;

public class c12 {
    public long findMaxButtons (int[] buttons) {
        long num = 0;
        for (int i = 0; i <buttons.length; i++) {
            while (true){
                if(buttons[i]>1){
                    num = i+num+1;
                    buttons[i] -= 1;
                }else {
                    int temp = i+1;
                    while (true){
                        if(temp <buttons.length&&buttons[temp]>1){
                            num = temp+num+1;
                            buttons[temp] -= 1;
                            break;
                        }else if(temp == buttons.length){
                            num = num+buttons.length;
                            break;
                        }
                        temp++;
                    }
                    break;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
//        int[] a = {1,1,4,5,1,4};
        int[] a = {2,2,2};
        c12 c12 = new c12();
        long maxButtons = c12.findMaxButtons(a);
        System.out.println(maxButtons);
    }
}
