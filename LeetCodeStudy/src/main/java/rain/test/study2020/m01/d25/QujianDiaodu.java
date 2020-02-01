package rain.test.study2020.m01.d25;

import java.util.Arrays;

/**
 * 问题描述：有n项工作，每项工作分别在Si开始，
 * Ti结束。例如S={1,2,4,6,8}，T={3,5,7,8,10}。
 * 对每项工作，你都可以选择与否，若选择参加，
 * 则必须至始至终参加全程参与，且参与工作的时间段不能有重叠。（如下图）
 * <p>
 * 每一步都做出一个局部最优的选择，最终的结果就是全局最优。
 * 注意哦，这是一种特殊性质，其实只有一部分问题拥有这个性质
 * <p>
 * <p>
 * 对这个问题，如果使用贪心算法的话，可能有以下几种考虑：
 * <p>
 * (1)、每次选取开始时间最早的；
 * <p>
 * (2)、每次选取结束时间最早的；
 * <p>
 * (3)、每次选取用时最短的；
 * <p>
 * (4)、在可选工作中，每次选取与最小可选工作有重叠的部分；
 * <p>
 * 对于上面的四种算法，只有算法(2)是正确的，其它的三种都可以找到相应的反例。具体证明如下：
 */
public class QujianDiaodu {
    public static void main(String args[]) {
        Job[] works = {
                new Job(1, 3),
                new Job(2, 5),
                new Job(4, 7),
                new Job(6, 9),
                new Job(8, 10)
        };
        int result = interval(works);
        System.out.println(result);
    }

    public static int interval(Job[] works) {
        Arrays.sort(works);
        int count = 0;
        //当前结束时间
        int t = 0;
        for (int i = 0; i < works.length; i++) {
            // 因为是全程参与 所以 开始之后的这段时间都得
            if (t < works[i].getS()) {
                t = works[i].getT();
                count++;
            }
        }
        return count;
    }
}

class Job implements Comparable<Job> {
    private int s;
    private int t;

    public Job(int s, int t) {
        this.s = s;
        this.t = t;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    @Override
    public int compareTo(Job o) {
        // 注意比较的是结束时间
        int res = this.getT() - o.getT();
        if (res > 0) {
            return 1;
        } else if (res == 0) {
            return 0;
        }
        return -1;
    }
}
