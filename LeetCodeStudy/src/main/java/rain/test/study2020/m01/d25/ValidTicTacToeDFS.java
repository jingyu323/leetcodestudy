package rain.test.study2020.m01.d25;


/**
 * 用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
 * <p>
 * 该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
 * “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 示例 1:
 * 输入: board = ["O  ", "   ", "   "]
 * 输出: false
 * 解释: 第一个玩家总是放置“X”。
 * <p>
 * 示例 2:
 * 输入: board = ["XOX", " X ", "   "]
 * 输出: false
 * 解释: 玩家应该是轮流放置的。
 * <p>
 * 示例 3:
 * 输入: board = ["XXX", "   ", "OOO"]
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: board = ["XOX", "O O", "XOX"]
 * 输出: true
 * 说明:
 * <p>
 * 游戏板 board 是长度为 3 的字符串数组，其中每个字符串 board[i] 的长度为 3。
 *  board[i][j] 是集合 {" ", "X", "O"} 中的一个字符。
 * <p>
 * <p>
 * 思想
 * <p>
 * 考虑井字游戏板生效的必要条件：
 * <p>
 * 因为所有的玩家轮流放棋，所以 X 的数量一定大于等于 O 的数量。
 * <p>
 * 获胜的玩家一定是在自己放棋后赢得比赛。
 * <p>
 * 如果第一个玩家获胜，则 X 的数量比 O 的数量多 1。
 * 如果第二个玩家获胜，则 X 的数量与 O 的数量相同。
 * 游戏板上不可能同时出现 3 个 X 在一行 和 3 个 O 在另一行。因为一旦有玩家获胜，游戏结束，另外一名玩家不能再放棋。
 */
public class ValidTicTacToeDFS {
    public boolean validTicTacToe(String[] board) {
        char[][] newBoard = new char[3][3];
        //转换数组
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = board[i].toCharArray();
        }


        int num = 0;
        char[][] mark = new char[3][3]; // 标志位 其实也就树转化为
        for (int i = 0; i < 3; i++) {
            for (int j = 0; i < 3; j++) {
                if (newBoard[i][j] != ' ') {
                    num++; // 记录棋子数量
                }
                mark[i][j] = ' ';
            }
        }

        return dfs(mark, newBoard, true, num);
    }

    /**
     * @param mark
     * @param board
     * @param flag
     * @param num
     * @return
     */
    public boolean dfs(char[][] mark, char[][] board, boolean flag, int num) {
        if (num == 0) { // 棋子数量为0，则终止
            return true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mark[i][j] == ' ' && board[i][j] == 'X' && flag) {
                    mark[i][j] = 'X';
                    //进行检查 ， 进行下一步
                    // 两种情况需要回溯，重新下棋
                    // 情况1：当前下完满足结束并且棋子数量不为0；
                    // 情况2：后续的dfs返回false（后面下棋不满足）
                    if ((check(mark) && num - 1 != 0) || !dfs(mark, board, !flag, num - 1)) {
                        continue;
                    }
                    return true;
                } else if (mark[i][j] == ' ' && board[i][j] == 'O' && !flag) {
                    mark[i][j] = 'O';
                    if ((check(mark) && num - 1 != 0) || !dfs(mark, board, !flag, num - 1)) { // 同上
                        mark[i][j] = ' ';
                        continue;
                    }
                    return true;

                }
            }
        }
        return false;
    }


    /* 是否满足结束条件 */
    public boolean check(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == 'X' || board[i][0] == 'O') && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
            if ((board[0][i] == 'X' || board[0][i] == 'O') && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }
        if ((board[0][0] == 'X' || board[0][0] == 'O') && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if ((board[0][2] == 'X' || board[0][2] == 'O') && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }
        return false;
    }

}
