package rain.test.study2020.m02.d1;

/**
 * 有n个需要在同一天使用同一个教室的活动a1,a2,…,an，教室同一时刻只能由一个活动使用。
 * 每个活动ai都有一个开始时间si和结束时间fi ，一旦被选择后，活动ai就占据半开时间区间[si,fi)。
 * 如果[si,fi]和[sj,fj]互不重叠，ai和aj两个活动就可以被安排在这一天，该问题就是要安排这些活动使得尽量多的活动能不冲突的举行。
 * 例如下图所示的活动集合S，其中各项活动按照结束时间单调递增排序。
 * <p>
 * 使用贪心算法，目标是实现安排尽可能多的活动，那么我们优先找那些结束时间早的活动，
 * 为后面的活动留出更多时间，即以结束时间为贪心。
 * 3、算法实现：
 * 注：这里我们稍打乱了顺序，在代码中采用了插入排序的方法对数据简单整理，使得结束时间从小到大排列
 */

public class ActiveSelection {

    /**
     * 贪心算法2：活动选择问题
     */
    public void greedy2() {
        int[] st = {1, 5, 0, 5, 3, 3, 6, 8, 8, 2, 12};
        int[] et = {4, 9, 6, 7, 8, 5, 10, 12, 11, 13, 14};
        int num = getNumber2(st, et);
        System.out.println("活动数量：" + num);


    }

    /**
     * 贪心算法2：活动选择问题
     *
     * @param a
     * @param b
     * @return
     */
    public int getNumber2(int[] a, int[] b) {  //优先选择结束时间早的
        int num = 0;
        int tempa = 0;
        int tempb = 0;
        int j = 0;
        int endTime = 0;

        for (int i = 1; i < b.length; i++) {
            tempa = a[i];
            tempb = b[i];
            for (j = i - 1; j >= 0 && tempb < b[j]; j--) {
                b[j + 1] = b[j];
                a[j + 1] = a[j];
                if (j == 0) {
                    j--;
                    break;
                }

            }
            b[j + 1] = tempb;
            a[j + 1] = tempa;
        }
        num++;
        endTime = b[0];
        for (int k = 1; k < b.length; k++) {
            if (a[k] > endTime) {
                num++;
                endTime = b[k];
            }

        }
        return num;

    }
}
