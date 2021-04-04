package CI;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/ef1f53ef31ca408cada5093c8780f44b
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
// 1 2 5 3 4 --> 1 5 3 2 4
public class JZ13 {
    // 错误思路：从左往右找到第一个偶数，从此处出发找到第一个奇数，交换位置
    // 错误思路：从左往右找到第一个偶数 ，将其后的奇数向前移动一格，直到遇到偶数 (无法处理连续偶数)

    //储存奇数和偶数，过会还原回去
    public int[] reOrderArray1(int[] array) {
        // 奇数
        ArrayList<Integer> list1 = new ArrayList<>();
        // 偶数
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (!list1.isEmpty()) {
                array[i] = list1.remove(0);
            } else {
                array[i] = list2.remove(0);
            }
        }
        return array;
    }

    //冒泡法，if i为偶数 从i之后的地方找一个奇数放到这里
    public int[] reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                int j = i+1;
                while (j<array.length&&array[j]%2==0) j++;
                //遍历完剩下的区间也没有找到奇数
                if(j==array.length) break;
                int tmp = array[j];
                for (int k = j; k > i; k--) {
                    array[k] = array[k-1];
                }
                array[i] = tmp;
            }
        }
        return array;
    }


        // 思路错误，无法处理 44443333的情况
    //找到最近的两个奇数位置i,j 将期间的偶数后移一位
    public int[] reOrderArrayError1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int j = i + 1;
                while (j < array.length && array[j] % 2 == 0) j++; //找i后面的第一个奇数j
                // 检索到数组边界仍未发现奇数j
                if (j == array.length) {
                    break;
                }
                int temp = array[j];
                //将i+1 到 j-1之间的偶数 向右挪一位
                for (int k = j; k > i + 1; k--) {
                    array[k] = array[k - 1];
                }
                array[i + 1] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 3, 4};
        JZ13 jz13 = new JZ13();
        int[] ints = jz13.reOrderArray(a);
        System.out.println();
    }
}
