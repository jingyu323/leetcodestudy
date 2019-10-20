import java.util.Arrays;

/**
 * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序
 *
 * <p>同时该算法是冲破O(n2）的第一批算法之一
 *
 * <p>基本思想 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 *
 * 在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列
 */
public class ShellSort {


    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 3, 1, 0, 4, 7, 8};
        sort(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int gap = (arr.length) / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    swap(arr, j, j-gap);
                    j -= gap;
                }
            }
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
