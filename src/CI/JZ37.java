package CI;

//升序数组找指定值的个数
public class JZ37 {
    //二分查找找到一个值，然后从该值出发向两头扫描，统计数量，最坏时间复杂度 n
    public int GetNumberOfK1(int [] array , int k) {
        int start = 0;
        int end = array.length-1;
        int mid = (start+end)/2;
        int result = 0;
        while (start<=end){
            if(array[mid] == k){
                result++;
                int l = mid;
                int r = mid;
                while (l-1>=0||r+1<array.length){
                    if(--l>=0&&array[l]==k){
                        result++;
                    }
                    if(++r<array.length&&array[r]==k){
                        result++;
                    }
                }
                return result;
            }else if(array[mid]>k){
                end = mid-1;
                mid = (start+end)/2;
            }else if(array[mid]<k){
                start = mid+1;
                mid = (start+end)/2;
            }
        }
        return result;
    }

    //二分查找找上界与下界 ，相减即可得到
    //找上下界的关键在于处理相等时的结果
    //找上界就往右移，找下界就往左移
    public int GetNumberOfK(int [] array , int k){
        int l = 0;
        int r = array.length;
        int mid = 0;
        int start,end;
        while (l<r){
            mid = (l+r)/2;
            //小于目标值右移 ，等于(大于)左移，找下界
            if(array[mid]<k){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        start=l;
        l = 0;
        r = array.length;
        while (l<r){
            mid = (l+r)/2;
            //等于(小于)右边移，大于左移，找上界
            if(array[mid]<=k){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        end=l;
        return end-start;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,3,3,3,4,5};
        JZ37 jz37 = new JZ37();
        int i = jz37.GetNumberOfK(arr, 5);
        System.out.printf("i");
    }
}
