package rain.test.study2020.m01.d30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * <p>
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * Example:
 * <p>
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 * [[1,2],[3,4],[5,6],[7,8]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）
 * <p>
 * <p>
 * 第三个版本 还原以前的那个 用开始排序的
 */
public class FindMinArrowShots3 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};

        int tes = new FindMinArrowShots().findMinArrowShots(arr);
        System.out.println("-->>" + tes);
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        List<Point2> pointList = new ArrayList<Point2>(points[0].length);

        for (int i = 0; i < points.length; i++) {
            Point2 point = new Point2(points[i][0], points[i][1]);
            pointList.add(point);
        }

        Collections.sort(pointList);
        int count = 1;

        int start = pointList.get(0).getStart();
        int end = pointList.get(0).getEnd();

        for (int i = 1; i < pointList.size(); i++) {
            Point2 tmp = pointList.get(i);
            System.out.println(tmp);
            //
            if (end >= tmp.getStart()) {
                end = Math.min(end, tmp.getEnd());
            } else {
                count++;
                end = tmp.getEnd();
            }


        }


        return count;
    }
}

class Point2 implements Comparable<Point2> {
    private int start;
    private int end;

    public Point2(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Point :start-->>" + start + "  , end is " + end;
    }

    @Override
    public int compareTo(Point2 o) {
        int res = this.getStart() - o.getStart();
        if (res != 0) {
            return res;
        }

        return this.getEnd() - o.getEnd();
    }
}
