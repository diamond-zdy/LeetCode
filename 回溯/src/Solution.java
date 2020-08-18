import java.util.ArrayList;
import java.util.List;

/*电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

        示例:

        输入："23"
        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        说明:
        尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution {
    String[] mapString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer("");
        backTrace(digits,res,sb,0);
        return res;
    }

    private void backTrace(String digits, List<String> res, StringBuffer sb, int curDepth) {
        if (curDepth == digits.length()){
            if (sb.length() != 0){
                res.add(sb.toString());
            }
            return;
        }
        //找到当前字符在String映射表中的位置
        int curMapIndex = digits.charAt(curDepth)-'0';
        String curMap = mapString[curMapIndex];
        for (int i = 0;i < curMap.length();i++){
            backTrace(digits,res,sb.append(curMap.charAt(i)),curDepth+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
