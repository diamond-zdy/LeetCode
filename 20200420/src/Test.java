import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**求和
 * 输入两个整数n和m，从数列1，2，3.......n中随意取几个数,使其和等于m,要求将其中所有的可能组合列出来
 *
 * 输入描述:
 *
 * 每个测试输入包含2个整数,n和m
 *
 * 输出描述:
 *
 * 按每个组合的字典序排列输出,每行输出一种组合
 *
 * 示例1
 *
 * 输入
 *
 * 55
 *
 * 输出
 *
 * 14
 *
 * 23
 *
 * 5
 *
 * 题目的意思：
 *
 * 从1到n中随机选取几个数，让其和等于m根据这句话，选出来的数不能重复，但是选取的个数任意
 *
 * 所以可以利用深度优先搜索【DFS】+回溯来解决
 *
 * 其中深度优先搜索算法用来寻找所有可能的组合，而回溯是用来筛选出所有可能组合中的可行解【如果发现某候选解不是可行解，直接丢弃】
 *
 * 注：由于选出来的数不能重复，所以在进行深搜时，下一次深搜应是从当前元素的下一个元素继续往后看
 *
 * 步骤：
 *
 * 1.从第一个元素开始相加
 *
 * 2.让局部和继续累加候选的剩余值
 *
 * 3.局部和等于目标值，保存组合，向上回退，寻找其它组合
 */
public class Test {
    private static List<ArrayList<Integer>> res = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            back(1,0,m,n);
            for (ArrayList<Integer> l : res){
                for (int i = 0;i < l.size();i++){
                    System.out.print(l.get(i));
                    if (i != l.size()-1){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static void back(int bigIndex, int sum, int target, int n) {
        if (sum >= target){
            if (sum == target){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = bigIndex;i <= n;i++){
            if (i > target){
                continue;
            }
            list.add(i);
            back(i+1,sum+i,target,n);
            list.remove(list.size()-1);
        }
    }
}
