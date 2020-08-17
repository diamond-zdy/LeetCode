/*被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

        找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

        示例:

        X X X X
        X O O X
        X X O X
        X O X X
        运行你的函数后，矩阵变为：

        X X X X
        X X X X
        X X X X
        X O X X
        解释:

        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/surrounded-regions
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 解题思路：
    若边上有O，所有与边上连接的O都不会被包围，所以从边上开始找*/
public class Solution3 {
    public void solve(char[][] board){
        if (board.length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        //寻找第一行和最后一行
        for (int i = 0;i < col;i++){
            if (board[0][i] == 'O'){
                dfs(board,row,col,0,i);
            }
            if (board[row-1][i] == 'O'){
                dfs(board,row,col,row-1,i);
            }
        }
        //寻找第一列和最后一列
        for (int i = 0;i < row;i++){
            if (board[i][0] == 'O')
                dfs(board,row,col,i,0);
            if (board[i][col-1] == 'O')
                dfs(board,row,col,i,col-1);
        }
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, int i, int i1) {
        board[i][i1] = '*';
        int[][] next = {{0,1},{0,-1},{-1,0},{1,0}};
        for (int j = 0;j < 4;j++){
            int ni = i+next[j][0];
            int ni1 = i1 + next[j][1];
            if (ni >= row || ni < 0
                    || ni1 >= col || ni1 < 0){
                continue;
            }
            if (board[ni][ni1] != 'X' && board[ni][ni1] != '*'){
                dfs(board,row,col,ni,ni1);
            }
        }
    }
}
