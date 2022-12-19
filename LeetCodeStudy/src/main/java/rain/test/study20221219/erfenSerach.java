package rain.test.study20221219;

/**
 * 使用二分搜索法解决[最大值最小化]条件：
 * <p>
 * 答案在一个固定区间内
 * <p>
 * 比较容易判断某个值是否符合条件
 * <p>
 * 可行解对于区间满足一定的单调性（x符合条件，那么x-1或x+1也符合条件）
 * <p>
 * 时间复杂度：最优情况O(1)，平均/最坏时间复杂度O(log n)
 * <p>
 * 1.搜索数组要有排序
 * <p>
 * 数组一定得先有序
 */
public class erfenSerach {


    /**
     * 假设目标值在闭区间[l,r]中，每次将区间长度缩小一半，当l=mid时，找到目标值
     * <p>
     * 区间[l,r]划分为[l,mid-1]和[mid+1,r];更新操作为r=mid-1或l=mid+1
     */
    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) { //数组为空
            return -1;
        }
        int l = 0, r = nums.length - 1; //设置左右边界
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
