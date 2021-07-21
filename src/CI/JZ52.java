package CI;

public class JZ52 {
    public boolean match (String str, String pattern) {
        int ptrS = 0;
        int ptrP = 0;
        Character before = null;
        //ptr指针走完就算通过
        while (ptrS<str.length()){
            if(str.charAt(ptrS) == pattern.charAt(ptrP)){
                ptrS++;
                ptrP++;
                before = str.charAt(ptrS);
            }else if(pattern.charAt(ptrP)=='.'){
                //通配符对上了
                ptrS++;
                ptrP++;
                before = '.';
            }else if(ptrP+1<str.length()&&pattern.charAt(ptrP+1)=='*'){
                //B  A* 形式可以跳过这一部分(可以为0个A)
                ptrP+=2;
            }else if(pattern.charAt(ptrP)=='*'){
                //对.*进行特殊处理,
                if(before == '.'){
                    //以.*结尾那就直接true
                    if(ptrP==pattern.length()-1){
                        return true;
                    }else {
                        //todo 如何处理 aa*a aaa

                        //处理AA.*BC AACCCCDFBD
                        //ptrP指针向后移动一位
                        //ptrS指针向后遍历到第一个与ptrP指针指向的字符相同的位置
                        ptrP++;
                        before = null;
                        while (ptrS<str.length()&&str.charAt(ptrS)!=pattern.charAt(ptrP)){
                            ptrS++;
                        }
                        if(ptrS<str.length()){
                            before = str.charAt(ptrS);
                        }
                    }
                }
                //AA*B AAAB 此处代码在PtrS指向第三个A时执行
                else if(before == str.charAt(ptrS)){
                    ptrS++;
                }else {
                    ptrP++;
                }
            }else {
                return false;
            }
        }
        if(ptrP==pattern.length()&&ptrS==str.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JZ52 jz52 = new JZ52();
        boolean aaa = jz52.match("aaa", "a*a");
        System.out.println();
    }
}
