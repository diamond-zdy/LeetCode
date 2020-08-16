import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/*打开转盘锁
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

        锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

        列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

        字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

        示例 1:

        输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
        输出：6
        解释：
        可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
        注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
        因为当拨动到 "0102" 时这个锁就会被锁定。
        示例 2:

        输入: deadends = ["8888"], target = "0009"
        输出：1
        解释：
        把最后一位反向旋转一次即可 "0000" -> "0009"。
        示例 3:

        输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
        输出：-1
        解释：
        无法旋转到目标数字且不被锁定。
        示例 4:

        输入: deadends = ["0000"], target = "8888"
        输出：-1
         
        提示：

        死亡列表 deadends 的长度范围为 [1, 500]。
        目标数字 target 不会在 deadends 之中。
        每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/open-the-lock
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution2 {
    public int openLock(String[] deadends, String target){
        //哈希表查找更快
        Set<String> deadendsSet = new HashSet<>();
        for (String str : deadends){
            deadendsSet.add(str);
        }
        //如果0000在死亡队列中，则永远到达不了
        if (deadendsSet.contains("0000")){
            return -1;
        }
        //初始化队列
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        //加标记，已经搜索过的不再搜索
        Set<String> book = new HashSet<>();
        book.add("0000");

        int step = 0;
        while (!q.isEmpty()){
            int n = q.size();
            //从上一步转换之后的字符都需要进行验证和转换
            //并且只做一次转换，类似于层序遍历，转换的步数和层相同
            //同一层的元素都是经过上一步转换得到的
            for (int i = 0;i < n;i++){
                String curStr = q.peek();
                q.poll();
                if (curStr.equals(target)) return step;
                //四位密码锁，每一位都可以转换一次
                for (int j = 0;j < 4;j++){
                    char newC1 = curStr.charAt(j);
                    char newC2 = curStr.charAt(j);
                    //当前位置可以向前或向后拨一位
                    if (newC1 == '9'){
                        newC1 = '0';
                    }else {
                        newC1++;
                    }
                    if (newC2 == '0'){
                        newC2 = '9';
                    }else {
                        newC2--;
                    }

                    StringBuffer newStr1 = new StringBuffer(curStr);
                    StringBuffer newStr2 = new StringBuffer(curStr);

                    newStr1.setCharAt(j,newC1);
                    newStr2.setCharAt(j,newC2);
                    if (!deadendsSet.contains(newStr1.toString())
                            && !book.contains(newStr1.toString())){
                        q.offer(newStr1.toString());
                        book.add(newStr1.toString());
                    }
                    if (!deadendsSet.contains(newStr2.toString())
                            && !book.contains(newStr2.toString())){
                        q.offer(newStr2.toString());
                        book.add(newStr2.toString());
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
