package PrimaryBook;

public class LB16 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s=s.toLowerCase();
        while (i <= j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(!Character.isLetterOrDigit(a)){
                i++;continue;
            }
            if(!Character.isLetterOrDigit(b)){
                j--;continue;
            }
            if(a!=b){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        LB16 lb16 = new LB16();
        boolean palindrome = lb16.isPalindrome("race a car");
//        boolean palindrome = lb16.isPalindrome("A man, a plan, a canal: Panama");
//        boolean palindrome = lb16.isPalindrome("0P");
        System.out.printf(String.valueOf(palindrome));
    }
}
