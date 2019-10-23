/***
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CourserSchedule{

    public static void main(String[] args) {
        int[][] prerequisites ={{1,0}};
        boolean res = canFinish(2,prerequisites);
        System.out.println(res);

    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] scheduleCources = new int[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            System.out.println(prerequisites[i][0]);
            scheduleCources[prerequisites[i][0]]++;
        }
        for (; ; ) {
            // 找一个 入度 为0的节点。
            int i = 0;
            for (i = 0; i < numCourses; i++) {
                if (!visited[i] && scheduleCources[i] == 0) {
                    break;
                }
            }
            if (i == numCourses) {//如果i和课程数量相等说明 数组和 课程必然有重复
                break;
            }
            // update the node
            for (int k = 0; k < prerequisites.length; k++) {
                if (prerequisites[k][1] == i) {
                    scheduleCources[prerequisites[k][0]]--;
                }
            }
            visited[i] = true;
        }
        for (int i = 0; i < scheduleCources.length; i++) {
            if (scheduleCources[i] > 0) {
                return false;
            }
        }
        return true;


    }




}
