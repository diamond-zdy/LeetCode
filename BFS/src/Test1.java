import java.util.*;
/*单词接龙
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

        每次转换只能改变一个字母。
        转换过程中的中间单词必须是字典中的单词。
        说明:

        如果不存在这样的转换序列，返回 0。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
        示例 1:

        输入:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

        输出: 5

        解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        返回它的长度 5。
        示例 2:

        输入:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]

        输出: 0

        解释: endWord "cog" 不在字典中，所以无法进行转换。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/word-ladder
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Test1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        int res = 1;
        Set<String> wordDict = new HashSet<>();
        for (String wd : wordList){
            wordDict.add(wd);
        }
        //标记单词是否已经访问过，访问过的不再访问
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- != 0){
                String curword = q.peek();
                q.poll();
                for (int i = 0;i < curword.length();i++){
                    StringBuffer sb = new StringBuffer(curword);
                    for (char ch = 'a';ch <= 'z';ch++){
                        sb.setCharAt(i,ch);
                        String str = sb.toString();
                        //如果表中没有此单词或单词已经访问过则跳过
                        if (!wordDict.contains(str) || visited.contains(str)){
                            continue;
                        }
                        //转换成功，res+1
                        if (str.equals(endWord)){
                            return res+1;
                        }
                        visited.add(str);
                        q.offer(str);
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
