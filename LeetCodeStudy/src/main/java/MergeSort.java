import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 8,  4, 5,7,1, 3,6,2};
        sort(arr, 0, arr.length - 1);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            System.out.println("arr：" + Arrays.toString(arr));
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left; // 左序列
        int j = mid + 1; // 右序列
        int t = 0; // 临时数组下标

        System.out.println("i：" +i+"j");
        while(i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }

    }



}
