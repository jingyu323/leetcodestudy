package rain.test.study2020.m02.d1;

/**
 * 3：背包问题
 * 1、题目：现有几种拥有一定重量和价值两个属性的物品，需要放到一个容量一定（能承受的重量一定）的包中，物品放入包中时，
 * 物品可以不完全放入包中，而放入一部分，求价值最大的方案。
 * 2、思路： 背包问题一般不能使用贪心算法。 然而我们考虑这样一种背包问题：在选择物品i装入背包时，可以选择物品的一部分，
 * 而不一定要全部装入背包。这时便可以使用贪心算法求解了。 计算每种物品的单位重量价值作为贪心选择的依据指标，
 * 选择单位重量价值最高的物品，将尽可能多的该物品装入背包，依此策略一直地进行下去，直到背包装满为止。
 * 在零一背包问题中贪心选择之所以不能得到最优解原因是贪心选择无法保证最终能将背包装满，
 * 部分闲置的背包空间使每公斤背包空间的价值降低了。
 * 在程序中已经事先将单位重量价值按照从大到小的顺序排好
 */
public class GreedyPackage {
}
