package rain.test.study2020.m01.d25;

/**
 * 给出两个长度相同的字符串，分别是 str1 和 str2。请你帮忙判断字符串 str1 能不能在 零次 或 多次 转化后变成字符串 str2。
 * <p>
 * 每一次转化时，将会一次性将 str1 中出现的 所有 相同字母变成其他 任何 小写英文字母（见示例）。
 * <p>
 * 只有在字符串 str1 能够通过上述方式顺利转化为字符串 str2 时才能返回 True，否则返回 False。​​
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "aabcc", str2 = "ccdee"
 * 输出：true
 * 解释：将 'c' 变成 'e'，然后把 'b' 变成 'd'，接着再把 'a' 变成 'c'。注意，转化的顺序也很重要。
 * 示例 2：
 * <p>
 * 输入：str1 = "leetcode", str2 = "codeleet"
 * 输出：false
 * 解释：我们没有办法能够把 str1 转化为 str2。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length == str2.length <= 10^4
 * str1 和 str2 中都只会出现 小写英文字母
 * <p>
 * 解题思路
 * 字母的转换一共有以下几种特殊情况
 * <p>
 * 1，当str1 == str2时显然可以转化
 * 2，如果str1 != str2，如果str2包含所有的26个字母，则没有了操作空间，因此肯定不能转化
 * 3，如果str1某两个下标i, j对应的字符相同，则必须要求str2中的相同下标也必须相同
 * 如果判断以上情况后没有问题，则可以转化成功
 */
public class CanConvert2 {

    public boolean canConvert(String str1, String str2) {
        int len = str1.length();
        if (len <= 1 && str1.equals(str2)) {
            return true;
        }

        // 检查str2 中是否包含了26个字符
        int count = 0;

        int[] chars = new int[26];
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) - 'a' == 0) {
                count++;
                chars[str2.charAt(i) - 'a'] = 1;
            }
        }
        if (count == 26) {
            return false;
        }
        // 创建
        int[] ends = new int[26];
        for (int i = 0; i < ends.length; i++) {
            ends[i] = -1;
        }

        //
        for (int i = 0; i < str1.length(); ++i) {
            int ind = str1.charAt(i) - 'a';
            if (ends[ind] != -1 && str2.charAt(ends[ind]) != str2.charAt(i)) {
                return false;
            }
            ends[ind] = i;
        }
        return true;

    }

}
