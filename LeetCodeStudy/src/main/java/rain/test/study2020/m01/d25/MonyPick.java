package rain.test.study2020.m01.d25;

/**
 * 问题描述：分别有1,5,10,50,100元，分别有5,2,2,3,5张纸币。问若要支付k元，则需要多少张纸币？
 * <p>
 * 问题分析：
 * <p>
 * 我们只需要遵循“优先使用面值大的硬币”即可。
 * <p>
 * 1.尽可能多的使用100元（即最大的）；
 * <p>
 * 2.余下部分尽可能多的使用50元；
 * <p>
 * 3.余下部分尽可能多的使用10元；
 * <p>
 * 4.余下部分尽可能多的使用5元；
 * <p>
 * 5.余下部分使用1元；
 */

public class MonyPick {
    int N = 5;
    int[] Money = {5, 2, 2, 3, 5};
    int[] Value = {1, 5, 10, 50, 100};

    public static void main(String[] args) {
        int money = 520;

        int res = new MonyPick().solve(money);
        System.out.println(res);


    }

    int solve(int money) {
        int num = 0;

        for (int i = N - 1; i > 0; i--) {
            int c = Math.min(money / Value[i], Money[i]);
            money = money - Value[i] * c;
            num += c;
        }

        // 如果没 money大于0 则说明 没有分配完成 则返回 ，所以返回-1
        if (money > 0) {
            num = -1;
        }

        return num;
    }
}
