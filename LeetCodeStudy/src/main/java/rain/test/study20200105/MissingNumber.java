package rain.test.study20200105;

import java.util.Arrays;

/**
 * 有一个数组，其中的值符合等差数列的数值规律，也就是说：
 *
 * 在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。
 * 我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组  arr。
 *
 * 给你这个缺值的数组 arr，请你帮忙找出被删除的那个数。
 *
 1228. 等差数列中缺失的数字

 // 思路就是怎么确定   等差 数列的 差值

 */
public class MissingNumber {

    public int missingNumber(int[] arr) {

        Arrays.sort(arr);
        int mid = (arr[arr.length-1]-arr[0])/(arr.length);

        for(int i=1;i<arr.length;i++){
            int ch = arr[i] - arr[i-1];
            if(ch >mid){
                return  arr[i-1]+mid;

            }

        }
        return  -1;


    }

    public static void main(String[] args) {
        int[]  arra = {5,7,11,13};

   int res  = new MissingNumber().missingNumber(arra);
        System.out.println(res);

    }


}
