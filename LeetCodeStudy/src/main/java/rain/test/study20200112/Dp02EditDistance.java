package rain.test.study20200112;

import java.util.Arrays;
import java.util.Scanner;

/***
 *编辑距离，又称Levenshtein距离（也叫做Edit Distance），
 * 是指两个字串之间，由一个转成另一个所需的最少编辑操作次数。
 * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
 */

public class Dp02EditDistance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String aStr = scan.nextLine();
        String bStr = scan.nextLine();
        int aLen = aStr.length();
        int bLen = bStr.length();

        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 0; i < aLen + 1; i++) {
            dp[i][0] = i;
        }
        System.out.println(Arrays.toString(dp));
    }


}
