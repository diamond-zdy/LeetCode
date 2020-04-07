import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/610e6c0387a0401fb96675f58cda8559
 * 来源：牛客网
 *
 * 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
 * 1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
 * 2. 待所有字条加入完毕，每人从箱中取一个字条；
 * 3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
 * 现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
 *
 * 输入描述:
 * 输入包含多组数据，每组数据包含一个正整数n（2≤n≤20）。
 *
 * 输出描述:
 * 对应每一组数据，以“xx.xx%”的格式输出发生无人获奖的概率。
 * 示例1
 * 输入
 * 2
 * 输出
 * 50.00%
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            float res = (count(n)/mul(n))*100;
            System.out.printf("%.2f",res);
            System.out.println("%");
        }
    }
    //递归求阶乘；
    private static float mul(int n) {
        if (n == 0){
            return 1;
        }else {
            return n*mul(n-1);
        }
    }

    //错排算法
    /**
     * //当n个编号元素放在n个编号位置，元素编号与位置编号各不对应的方法数用D(n)表示，
     *     //那么D(n-1)就表示n-1个编号元素放在n-1个编号位置，各不对应的方法数，其它类推.
     *     //第一步，把第n个元素放在一个位置，比如位置k，一共有n-1种方法；
     *     //第二步，放编号为k的元素，这时有两种情况：把它放到位置n，那么，对于剩下的n-1个元素，
     *     //由于第k个元素放到了位置n，剩下n-2个元素就有D(n-2)种方法；
     *     //第k个元素不把它放到位置n，这时，对于这n-1个元素，有D(n-1)种方法；
     *     //综上得到递推公式，可以发现可以用递归来做；
     *     //D(n) = (n-1) [D(n-2) + D(n-1)]
     *     //特殊地，D(1) = 0, D(2) = 1.
     *     //那么D(5)=4*[D(3)+D(4)]；依次求得D(3)、D(4),最后D(5)=44
     *     //所以5个人拿不到奖的概率就是44/120=36.67%
     */
    private static float count(int n) {
        if (n == 1){
            return 0;
        }else if (n == 2){
            return 1;
        }else {
            return (n-1)*(count(n-1)+count(n-2));
        }
    }
}
