import java.util.Arrays;

public class InsertSort {
  public static void main(String[] args) {

      int []arr = {4,6,8,5,9,1};
      sort(arr);
      System.out.println(Arrays.toString(arr));



  }


    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int j, int i) {
      int tem =  arr[j];

        arr[j] = arr[i];
        arr[i] = tem;

    }
}
