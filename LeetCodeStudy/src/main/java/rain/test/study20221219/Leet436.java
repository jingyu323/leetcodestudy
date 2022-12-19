package rain.test.study20221219;

import java.util.Arrays;

/**
 * 寻找左右区间 436. 寻找右区间
 * <p>
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * <p>
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 * <p>
 * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 * <p>
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * 示例 3：
 * <p>
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-right-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * lamada
 * (parameters) -> expression[表达式]
 * (parameters) -> statements[语句]
 * (parameters) ->{ statements; }
 * <p>
 * <p>
 * 思路：数组 进行排序, 二分查找
 */
public class Leet436 {
    public static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        int[][] clone = new int[n][2];

        for (int i = 0; i < n; i++) {
            //将数组的第一个元素及其下标记录起来
            clone[i] = new int[]{intervals[i][0], i};
        }

        Arrays.sort(clone, (o1, o2) -> o1[0] - o2[0]);
//        Arrays.sort(clone,(o1,o2) -> {
//            System.out.println(o1);
//            int i = o1[0] - o2[0];
//            return i;
//        });


        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;
            while (l < r) {
  
                int mid = l + (r - l) / 2;
                if (clone[mid][0] >= intervals[i][1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }

            }
            // 如果r所在位置的左边界确实大于当前位置的右边界，则取出下标存入res，否则存入-1
            res[i] = clone[r][0] >= intervals[i][1] ? clone[r][1] : -1;


        }


        return res;

    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {2, 3}, {3, 4}};
        System.out.println(findRightInterval(intervals));

    }
}
