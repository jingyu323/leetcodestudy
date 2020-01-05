package rain.test.study20200105;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 1168. 水资源分配优化
 *
 * 图论
 *
 * 村里面一共有 n 栋房子。我们希望通过建造水井和铺设管道来为所有房子供水。
 *
 * 对于每个房子 i，我们有两种可选的供水方案：
 *
 * 一种是直接在房子内建造水井，成本为 wells[i]；
 * 另一种是从另一口井铺设管道引水，数组 pipes 给出了在房子间铺设管道的成本，其中每个 pipes[i] = [house1, house2, cost] 代表用管道将 house1 和 house2 连接在一起的成本。当然，连接是双向的。
 * 请你帮忙计算为所有房子都供水的最低总成本。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * 输出：3
 * 解释：
 * 上图展示了铺设管道连接房屋的成本。
 * 最好的策略是在第一个房子里建造水井（成本为 1），然后将其他房子铺设管道连起来（成本为 2），所以总成本为 3。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10000
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= pipes.length <= 10000
 * 1 <= pipes[i][0], pipes[i][1] <= n
 * 0 <= pipes[i][2] <= 10^5
 * pipes[i][0] != pipes[i][1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/optimize-water-distribution-in-a-village
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *别人的解题 思路
 *
 * 先在每个房子里都建一个井，则每个房子都是一个单独的联通分量，计算花费的总和，并记录下每个联通分量建井的成本，
 * 然后将边按权重排序，遍历排序后的边。对每一个边，首先利用并查集检查两端的顶点是否已经相连，如果已经相连则直接跳过，
 * 否则寻找两个顶点所处的联通分量中根节点建井的花费的较大值，如果这个较大值大于这条边的权重，则可以通过建立这条边，
 * 省去那个较大的建井成本，最后遍历完全部边，找到最大值
 *
 *
 */
public class MinCostToSupplyWater {
    int[] parent;
    int[] cost;
    public int findRoot(int p) {
        while(parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int ans = 0;

        parent = new int[n + 1];
        cost = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            parent[i] = i;
            cost[i] = wells[i - 1];
            ans += wells[i - 1];
        }

        Arrays.sort(pipes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int[] edge: pipes) {
            int h1 = edge[0];
            int h2 = edge[1];
            int weight = edge[2];
            int root1 = findRoot(h1);
            int root2 = findRoot(h2);
            if(root1 == root2)
                continue;
            if(cost[root1] > cost[root2] && cost[root1] > weight) {
                parent[root1] = root2;
                ans += weight - cost[root1];
            } else if(cost[root2] > weight) {
                parent[root2] = root1;
                ans += weight - cost[root2];
            }
        }
        return ans;
    }
}
