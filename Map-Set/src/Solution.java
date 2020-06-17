import java.util.*;

public class Solution {

    /*找出只出现一次的数字*/
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length;i++){
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> res = set.iterator();
        return res.next();
    }

   /* 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

    要求返回这个链表的 深拷贝。 

    我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

    val：一个表示 Node.val 的整数。
    random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
             

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node p = head;
        while (p!=null){
            map.put(p,new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

/* 宝石与石头
  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

    J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

    示例 1:

    输入: J = "aA", S = "aAAbbbb"
    输出: 3
    示例 2:

    输入: J = "z", S = "ZZ"
    输出: 0
    注意:

    S 和 J 最多含有50个字母。
             J 中的字符不重复。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/jewels-and-stones
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(char j : J.toCharArray()){
            set.add(j);
        }
        int res = 0;
        for (char s : S.toCharArray()){
            if (set.contains(s)){
                res++;
            }
        }
        return res;
    }

    /*坏键盘打字 牛客网*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String old = sc.nextLine();
            String res = sc.nextLine();

            Set<Character> setRes = new HashSet<>();
            for (char ch : res.toUpperCase().toCharArray()){
                setRes.add(ch);
            }

            Set<Character> broke = new HashSet<>();
            for (char ch : old.toUpperCase().toCharArray()){
                if (!setRes.contains(ch) && !broke.contains(ch)){
                    broke.add(ch);
                    System.out.print(ch);
                }
            }
        }
    }

    /*前k个高频单词

    给一非空的单词列表，返回前 k 个出现次数最多的单词。

    返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

    示例 1：

    输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    输出: ["i", "love"]
    解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/top-k-frequent-words
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

    /*
    * top问题三部曲：
    * 1.构建词频
    * 2.构建最小堆
    * 3.弹出答案*/
    public List<String> topKFrequent(String[] words, int k) {

        //构建单词及频率
        Map<String,Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        //构建最小堆
        PriorityQueue min = new PriorityQueue((o1, o2) ->
                (map.get(o1) - map.get(o2)) == 0 ? ((String)o2).compareTo(((String)o1)) : (map.get(o1) - map.get(o2)));
        for (String word : map.keySet()){
            min.add(word);
            if (min.size() > k){
                min.poll();
            }
        }

        //弹出答案
        List<String> res = new ArrayList<>();
        while (!min.isEmpty()){
            res.add((String) min.poll());
        }
        Collections.sort(res,((o1, o2) ->
                (map.get(o2) - map.get(o1)) == 0 ? o1.compareTo(o2) : (map.get(o2) - map.get(o1))));
        return res;
    }
}
