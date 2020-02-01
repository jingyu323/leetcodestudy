package rain.test.study2020.m01.d30;

import java.util.Arrays;

/**
 * 例题1：钱币找零问题
 * 1、题目：指定币值和相应的数量，用最少的数量凑齐某金额。
 * 2、思路：利用贪心算法，我们优先选择面值大的钱币，以此类推，直到凑齐总金额
 */
public class MoneyExchange {
    /**
     * 贪心算法1：钱币找零问题
     */
    public void greedy1() {
        //面额
        int[] values = {1, 2, 5, 10, 20, 50, 100};
        //数量
        int[] counts = {3, 3, 2, 1, 1, 3, 3};
        //获取需要各种面值多少张
        int[] result = getNumber1(446, values, counts);
        System.out.println("各币值的数量：" + Arrays.toString(result));


    }

    /**
     * 贪心算法1：钱币找零问题
     *
     * @param sum
     * @param values
     * @param counts
     * @return
     */
    public int[] getNumber1(int sum, int[] values, int[] counts) {
        //按照币种创建 数组 每个位置上的数字代表
        int[] result = new int[7];
        int add = 0; //  当前凑的 金额

        //细节别忘了 等于0
        for (int i = values.length - 1; i >= 0; i--) {
            // 用最大的算出来  需要多少张 最后从总数中减去
            int num = (sum - add) / values[i];
            if (num > counts[i]) {
                num = counts[i];
            }

            add = add + num * values[i];
            result[i] = num;

        }
        return result;

    }
}
