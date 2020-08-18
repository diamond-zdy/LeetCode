import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*活字印刷
你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。

        注意：本题中，每个活字字模只能使用一次。

        示例 1：

        输入："AAB"
        输出：8
        解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
        示例 2：

        输入："AAABBC"
        输出：188

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/letter-tile-possibilities
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution2 {
    public int numTilePossibilities(String tiles){
        if (tiles.length() == 0){
            return 0;
        }
        //使用set
        Set<String> set = new HashSet<>();
        //标记是否使用过字母
        List<Integer> list = new ArrayList<>();
        //初始化标记
        for (int i = 0;i < tiles.length();i++){
            list.add(0);
        }
        //临时可修改的字符串
        StringBuffer sb = new StringBuffer("");
        dfs(tiles,set,list,sb);
        return set.size();
    }

    private void dfs(String tiles, Set<String> set, List<Integer> list, StringBuffer sb) {
        if (sb.length() != 0){
            set.add(sb.toString());
        }
        for (int i = 0;i < tiles.length();i++){
            if (list.get(i) == 1) continue;
            sb.append(tiles.charAt(i));
            list.set(i,1);
            dfs(tiles,set,list,sb);
            //回退
            list.set(i,0);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
