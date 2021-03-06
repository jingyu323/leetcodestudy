package rain.test.study2020.m01.d25;


import java.util.ArrayList;
import java.util.List;

/**
 * 1276. 不浪费原料的汉堡制作方案
 * 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
 * <p>
 * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
 * <p>
 * 巨无霸汉堡：4 片番茄和 1 片奶酪
 * 小皇堡：2 片番茄和 1 片奶酪
 * 请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
 * <p>
 * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：tomatoSlices = 16, cheeseSlices = 7
 * 输出：[1,6]
 * 解释：制作 1 个巨无霸汉堡和 6 个小皇堡需要 4*1 + 2*6 = 16 片番茄和 1 + 6 = 7 片奶酪。不会剩下原料。
 * 示例 2：
 * <p>
 * 输入：tomatoSlices = 17, cheeseSlices = 4
 * 输出：[]
 * 解释：只制作小皇堡和巨无霸汉堡无法用光全部原料。
 * 示例 3：
 * <p>
 * 输入：tomatoSlices = 4, cheeseSlices = 17
 * 输出：[]
 * 解释：制作 1 个巨无霸汉堡会剩下 16 片奶酪，制作 2 个小皇堡会剩下 15 片奶酪。
 * 示例 4：
 * <p>
 * 输入：tomatoSlices = 0, cheeseSlices = 0
 * 输出：[0,0]
 * 示例 5：
 * <p>
 * 输入：tomatoSlices = 2, cheeseSlices = 1
 * 输出：[0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= tomatoSlices <= 10^7
 * 0 <= cheeseSlices <= 10^7
 * <p>
 * <p>
 * <p>
 * <p>
 * 设巨无霸汉堡有 xx 个，皇堡有 yy 个，由于所有的材料都需要用完，因此我们可以得到二元一次方程组：
 * <p>
 * \begin{cases} 4x + 2y = \text{tomatoSlices} \\ x + y = \text{cheeseSlices} \end{cases}
 * {
 * 4x+2y=tomatoSlices
 * x+y=cheeseSlices
 * ​
 * <p>
 * <p>
 * 解得：
 * <p>
 * \begin{cases} x = \frac{1}{2} * \text{tomatoSlices} - \text{cheeseSlices} \\ y = 2 * \text{cheeseSlices} - \frac{1}{2} * \text{tomatoSlices} \end{cases}
 * {
 * x=
 * 2
 * 1
 * ​
 * ∗tomatoSlices−cheeseSlices
 * y=2∗cheeseSlices−
 * 2
 * 1
 * ​
 * ∗tomatoSlices
 * ​
 * <p>
 * <p>
 * 根据题意，x, y \geq 0x,y≥0 且 x, y \in \mathbb{N}x,y∈N，因此需要满足：
 * <p>
 * \begin{cases} \text{tomatoSlices} = 2k, \quad k \in \mathbb{N} \\ \text{tomatoSlices} \geq 2 * \text{cheeseSlices} \\ 4 * \text{cheeseSlices} \geq \text{tomatoSlices} \end{cases}
 * ⎩
 * ⎪
 * ⎨
 * ⎪
 * ⎧
 * ​
 * <p>
 * tomatoSlices=2k,k∈N
 * tomatoSlices≥2∗cheeseSlices
 * 4∗cheeseSlices≥tomatoSlices
 * ​
 * <p>
 * <p>
 * 若不满足，则无解。
 * <p>
 * 求解 二元一次方程
 *
 * <p>
 */
public class NumOfBurgers {

    public static void main(String[] args) {

    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int x = (tomatoSlices - 2 * cheeseSlices) / 2;
        int y = cheeseSlices - x;

        List numOfBurgers = new ArrayList<>();
        // 只要tomatoSlices % 2==0   基本上就可以满足
        if (tomatoSlices % 2 != 0 || x < 0 || y < 0) {
            return numOfBurgers;
        }
        numOfBurgers.add(x);
        numOfBurgers.add(y);
        return numOfBurgers;

    }
}
