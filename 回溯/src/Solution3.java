import java.util.ArrayList;
import java.util.List;
/*N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

        上图为 8 皇后问题的一种解法。

        给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

        每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

        示例:

        输入: 4
        输出: [
        [".Q..",  // 解法 1
        "...Q",
        "Q...",
        "..Q."],

        ["..Q.",  // 解法 2
        "Q...",
        "...Q",
        ".Q.."]
        ]
        解释: 4 皇后问题存在两个不同的解法。
         
        提示：

        皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自 百度百科 - 皇后 ）

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/n-queens
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class pair{
    public int x;
    public int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution3 {
    public List<List<String>> solveNQueens(int n){
        //按坐标位置存放所有解决方案
        List<List<pair>> res = new ArrayList<>();
        //存放一种解决方案中的所有坐标
        List<pair> solution = new ArrayList<>();

        nQueenBackTrace(res,solution,0,n);
        //将结果转成String
        return transRes(res,n);
    }

    private List<List<String>> transRes(List<List<pair>> res, int n) {
        List<String> tmp = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();
        for (List<pair> solution : res){
            List<StringBuffer> solutionString = new ArrayList<>();

            for (int i = 0;i < n;i++){
                StringBuffer sb = new StringBuffer();
                for (int j = 0;j < n;j++){
                    sb.append('.');
                }
                solutionString.add(sb);
            }
            for (pair i : solution){
                solutionString.get(i.x).setCharAt(i.y,'Q');
            }
            List<String> curRet = new ArrayList<>();
            for (StringBuffer sb : solutionString){
                curRet.add(sb.toString());
            }
            ret.add(curRet);
        }
        return ret;
    }

    private void nQueenBackTrace(List<List<pair>> res, List<pair> solution, int curRow, int n) {
        if (curRow == n){
            List<pair> list = new ArrayList<>();
            for (pair p : solution){
                list.add(p);
            }
            res.add(list);
        }
        //尝试当前位置是否可以放一个皇后
        for (int col = 0;col < n;col++){
            if (isVaild(solution,curRow,col)){
                //如果可以，保存当前位置，继续下一行的判断
                solution.add(new pair(curRow,col));
                nQueenBackTrace(res,solution,curRow+1,n);
                //回溯，删除当前位置，尝试当前行的其他位置
                solution.remove(solution.size()-1);
            }
        }
    }

    private boolean isVaild(List<pair> solution, int curRow, int col) {
        //判断当前行尝试的皇后位置是否和前面几行的皇后位置有冲突
        //i.second == col : 第i个皇后与当前点在同一列
        //i.first + i.second == row + col : 第i个皇后与当前点在 撇 上，横坐标+纵坐标值相同
        //i.first - i.second == row - col : 第i个皇后与当前点在 捺 上，横坐标-纵坐标值相同
        for (pair p : solution){
            if (p.y == col || p.x+p.y == col + curRow || p.x-p.y == curRow - col){
                return false;
            }
        }
        return true;
    }
}
