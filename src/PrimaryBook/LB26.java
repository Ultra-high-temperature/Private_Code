package PrimaryBook;

public class LB26 {

    //找true 的下边界
    public int firstBadVersion0(int n) {
        int start = 0, end = n-1 ,aim = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)==true) {
                end = mid -1 ;
                aim = mid;
            } else {
                start = mid + 1;
            }
        }
        return aim +1 ;
    }

    public int firstBadVersion(int n) {
        // 直接二分即可,找到第一个为false的版本
        // 全闭区间
        int l = 1, r = n;
        while (l <= r){
            int mid = l + (r - l) /2 ;
            if (isBadVersion(mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    public int search (int[] nums, int target) {
        int l = 0,r = nums.length-1,aim = -1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if(target<nums[mid]){
                r = mid-1;
            }else if(target>nums[mid]) {
                l=mid+1;
            }else if(target==nums[mid]){
                r = mid-1;
                aim = mid;
            }
        }
        return aim;
    }


    boolean isBadVersion(int version){
        boolean[] booleans = { false, false, false, false,true, true, true, true};
        return booleans[version];
    }

    public static void main(String[] args) {
        LB26 lb26 = new LB26();
        int i = lb26.firstBadVersion(8);
        System.out.printf("");
    }
}
