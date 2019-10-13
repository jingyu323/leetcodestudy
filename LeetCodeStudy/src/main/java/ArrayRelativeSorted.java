import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * * 数组的相对排序
 *
 * <p>给你两个数组，arr1 和 arr2，
 *
 * <p>arr2 中的元素各不相同 arr2 中的每个元素都出现在 arr1 中 对 arr1 中的元素进行排序，使 arr1
 * 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * <p>
 *
 * <p>示例：
 *
 * <p>输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6] 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * <p>来源：力扣（LeetCode）
 *
 * 总结本方法的核心就是 int类型的数组转为 List<Integer> 利用list 进行遍历， 同时利用列表可以删除元素
 * 然后将剩下的元素，进行排序，排序之后直接添加到队尾</>
 *
 */
public class ArrayRelativeSorted {

    /**
     * 思路是 遍历arrr中的数组，然后从一中找相关的元素，进行排序，找到一个就剔除相关的元素，然后把剩下的进行排序直接添加到队列尾部
     * @param arr1
     * @param arr2
     * @return
     */

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tem = new int[arr1.length];

        List<Integer> tempArr1 =  Arrays.stream(arr1).boxed().collect(Collectors.toList());

        int index =0;

        for(int ele:arr2){
            for (int i = tempArr1.size() - 1; i >= 0; i--) {
                Integer e = tempArr1.get(i);
                if(ele == e){
                    tem[index++]=ele;
                    tempArr1.remove(e);
                }
            }
        }

        if(!tempArr1.isEmpty()){
            Collections.sort(tempArr1);
            for(int i=0;i<tempArr1.size();i++){
                tem[index++]=(Integer) tempArr1.get(i);;
            }
        }
        return tem;

    }

  public static void main(String[] args) {
      int[] arr1 =new int[]{2,3,1,3,2,4,6,7,9,2,19};
      int[] arr2 =new int[]{2,1,4,3,9,6};
    int[] res = new ArrayRelativeSorted().relativeSortArray(arr1,arr2);

    System.out.println(res);
  }
}
