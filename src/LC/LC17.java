package LC;

public class LC17 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;

        for (int i = 0; i < gas.length; i++) {
            boolean label = true;
            int oil = 0;
            int j1 = 0;
            for (int j = i; j <= i + gas.length; j++) {
                j1 = j >= gas.length ? j - gas.length : j;//环形所以要判断回路
                oil += gas[j1];//在这个站加油
                if (oil - cost[j1] < 0) {
                    label = false;
                    break;//油不够开到下一个站点，所以停下来了
                } else {
                    oil -= cost[j1];//油可以开到下个站点
                }
            }

            if (i == j1   && label) {//完成回环
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas =  {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        LC17 lc17 = new LC17();
        int i = lc17.canCompleteCircuit(gas, cost);
        System.out.printf("结果是" + i);
    }
}
