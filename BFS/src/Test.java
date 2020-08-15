import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*二叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

        例如，给定一个 3叉树 :

        返回其层序遍历:

        [
        [1],
        [3,2,4],
        [5,6]
        ]

        说明:

        树的深度不会超过 1000。
        树的节点总数不会超过 5000。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Test {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            //临时存放每一层的数据
            List<Integer> newFloor = new LinkedList<>();
            while (size-- != 0){
                Node node = queue.peek();
                queue.poll();
                newFloor.add(node.val);
                for (Node child : node.children){
                    if (child != null){
                        queue.offer(child);
                    }
                }
            }
            if (!newFloor.isEmpty()){
                res.add(newFloor);
            }
        }
        return res;
    }
}