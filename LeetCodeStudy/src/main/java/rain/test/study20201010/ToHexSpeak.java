package rain.test.study20201010;

/**
 * 1271. 十六进制魔术数字
 * <p>
 * 你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：首先将它变成字母大写的十六进制字符串，然后将所有的数字 0 变成字母 O ，将数字 1  变成字母 I 。
 * <p>
 * 如果一个数字在转换后只包含 {"A", "B", "C", "D", "E", "F", "I", "O"} ，那么我们就认为这个转换是有效的。
 * <p>
 * 给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回 "ERROR" 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "257"
 * 输出："IOI"
 * 解释：257 的十六进制表示是 101 。
 * 示例 2：
 * <p>
 * 输入：num = "3"
 * 输出："ERROR"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^12
 * 给定字符串不会有前导 0 。
 * 结果中的所有字母都应该是大写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hexspeak
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ToHexSpeak {
    public static String toHexspeak(String num) {
        String toHexString = Long.toHexString(Long.valueOf(num));

        for (int i = 0; i < toHexString.length(); i++) {
            //0-9 48 -57 出去 0 1  刚好50 如果
            if (toHexString.charAt(i) >= 50 && toHexString.charAt(i) <= 57) {
                return "ERROR";
            }
        }

        return toHexString.replaceAll("0", "O").replaceAll("1", "I").toUpperCase();

    }

    public static void main(String[] args) {
        System.out.println(toHexspeak("257"));


    }
}
