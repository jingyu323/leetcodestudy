package rain.test.study20201017;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 353. 贪吃蛇
 * 请你设计一个 贪吃蛇游戏，该游戏将会在一个 屏幕尺寸 = 宽度 x 高度 的屏幕上运行。如果你不熟悉这个游戏，可以 点击这里 在线试玩。
 * <p>
 * 起初时，蛇在左上角的 (0, 0) 位置，身体长度为 1 个单位。
 * <p>
 * 你将会被给出一个 (行, 列) 形式的食物位置序列。当蛇吃到食物时，身子的长度会增加 1 个单位，得分也会 +1。
 * <p>
 * 食物不会同时出现，会按列表的顺序逐一显示在屏幕上。比方讲，第一个食物被蛇吃掉后，第二个食物才会出现。
 * <p>
 * 当一个食物在屏幕上出现时，它被保证不能出现在被蛇身体占据的格子里。
 * <p>
 * 对于每个 move() 操作，你需要返回当前得分或 -1（表示蛇与自己身体或墙相撞，意味游戏结束）。
 * <p>
 * 示例：
 * <p>
 * 给定 width = 3, height = 2, 食物序列为 food = [[1,2],[0,1]]。
 * <p>
 * Snake snake = new Snake(width, height, food);
 * <p>
 * 初始时，蛇的位置在 (0,0) 且第一个食物在 (1,2)。
 * <p>
 * |S| | |
 * | | |F|
 * <p>
 * snake.move("R"); -> 函数返回 0
 * <p>
 * | |S| |
 * | | |F|
 * <p>
 * snake.move("D"); -> 函数返回 0
 * <p>
 * | | | |
 * | |S|F|
 * <p>
 * snake.move("R"); -> 函数返回 1 (蛇吃掉了第一个食物，同时第二个食物出现在位置 (0,1))
 * <p>
 * | |F| |
 * | |S|S|
 * <p>
 * snake.move("U"); -> 函数返回 1
 * <p>
 * | |F|S|
 * | | |S|
 * <p>
 * snake.move("L"); -> 函数返回 2 (蛇吃掉了第二个食物)
 * <p>
 * | |S|S|
 * | | |S|
 * <p>
 * snake.move("U"); -> 函数返回 -1 (蛇与边界相撞，游戏结束)
 */
public class SnakeGame {

    int[][] food;
    int width, height;
    int i, j;
    Deque<int[]> data;
    boolean[][] flag;
    private int foodIdx;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodIdx = 0;
        i = 0;
        j = 0;


        data = new ArrayDeque<>();
        data.push(new int[]{0, 0});

        flag = new boolean[height][width];
        flag[0][0] = true;


    }

    public static void main(String[] args) {
        int[][] food = {{1, 2}, {0, 1}};
        int width = 3, height = 2;


        SnakeGame obj = new SnakeGame(width, height, food);
        int param_1 = obj.move("R");
        System.out.println(param_1);
        int param_2 = obj.move("D");
        System.out.println(param_2);
        int param_3 = obj.move("R");
        System.out.println(param_3);
        int param_4 = obj.move("U");
        int param_5 = obj.move("L");
        int param_6 = obj.move("U");

        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < height && j >= 0 && j < width;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int new_i = i, new_j = j;
        if (direction.equals("U")) new_i--;
        if (direction.equals("D")) new_i++;
        if (direction.equals("L")) new_j--;
        if (direction.equals("R")) new_j++;

        //判断是否到边界
        if (!isValid(new_i, new_j)) {
            return -1;
        }

        int[] lastPos = data.getLast();
        //判断 当flag 为true  说明已经在蛇队列中，并且不等于尾结点  则说明已经碰撞
        if (flag[new_i][new_j] && (new_i != lastPos[0] || new_j != lastPos[1])) {
            return -1;
        }
        data.addFirst(new int[]{new_i, new_j});
        // 标记占用的格子 如果占用则为true  否则为false
        flag[new_i][new_j] = true;
        // 当前队列中添加数据
        if (foodIdx < food.length && food[foodIdx][0] == new_i && food[foodIdx][1] == new_j) {
            foodIdx++;
        } else {
            //否则移除
            int[] tail = data.removeLast();
            if (tail[0] != new_i || tail[1] != new_j)
                flag[tail[0]][tail[1]] = false;
        }

        i = new_i;
        j = new_j;

        return data.size() - 1;


    }
}
