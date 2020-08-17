/*岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

        岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

        此外，你可以假设该网格的四条边均被水包围。

        示例 1:

        输入:
        [
        ['1','1','1','1','0'],
        ['1','1','0','1','0'],
        ['1','1','0','0','0'],
        ['0','0','0','0','0']
        ]
        输出: 1
        示例 2:

        输入:
        [
        ['1','1','0','0','0'],
        ['1','1','0','0','0'],
        ['0','0','1','0','0'],
        ['0','0','0','1','1']
        ]
        输出: 3
        解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/number-of-islands
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution4 {
    public int numIslands(char[][] grid){
        if (grid.length == 0)return 0;
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] book = new int[row][col];
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if (grid[i][j] == '1' && book[i][j] == 0){
                    res++;
                    dfs(grid,book,row,col,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int[][] book, int row, int col, int x, int y) {
        int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
        book[x][y] = 1;
        for (int i = 0;i < 4;i++){
            int nx = x+next[i][0];
            int ny = y+next[i][1];
            if (nx >= row || nx < 0
                    || ny >= col || ny < 0){
                continue;
            }
            if (grid[nx][ny] == '1' && book[nx][ny] == 0){
                book[nx][ny] = 1;
                dfs(grid,book,row,col,nx,ny);
            }
        }
    }
}
