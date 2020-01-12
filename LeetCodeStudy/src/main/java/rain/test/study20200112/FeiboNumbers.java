package rain.test.study20200112;

/**
 * 斐波那契数列用  动态规划实现
 */

public class FeiboNumbers {

    public static void main(String[] args) {

        int n = 9;
        System.out.println(fb(9));


    }


    public static int fb(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int leng = 0;
        int[] tmp = new int[n];
        tmp[0] = 1;
        tmp[1] = 1;
        tmp[2] = 1;
        for (int i = 3; i < n; i++) { //小于n 刚好构建出来来的就是n的数字，还有就是i=2 还是等于3的问题 ，
            // i=3就相当于下标加了一位 i就需要=n 否则会少一次循环否则结果就不对
            tmp[i] = tmp[i - 1] + tmp[i - 2];
            leng = i;
        }

        return tmp[leng];

    }


}
