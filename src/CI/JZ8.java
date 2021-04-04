package CI;

//https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
public class JZ8 {
    //jz 7 的换皮版
    public int JumpFloor(int target) {
        if(target<=2){
            return target;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= target; i++) {
            i2 = i1+i2;
            i1 = i2-i1;
        }
        return i2;
    }
}
