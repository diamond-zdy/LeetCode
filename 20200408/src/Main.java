import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**锤子剪刀布
 * 链接：https://www.nowcoder.com/questionTerminal/79db907555c24b15a9c73f7f7d0e2471
 * 来源：牛客网
 *
 * 大家应该都会玩“锤子剪刀布”的游戏：
 *
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
 *
 * 输入描述:
 * 输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代
 * 表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
 *
 *
 * 输出描述:
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯
 * 一，则输出按字母序最小的解。
 * 示例1
 * 输入
 * 10<br/>C J<br/>J B<br/>C B<br/>B B<br/>B C<br/>C C<br/>C B<br/>J B<br/>B C<br/>J J
 * 输出
 * 5 3 2<br/>2 3 5<br/>B B
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();

            Model mA = new Model();
            Model mB = new Model();

            for (int i = 0;i < N;i++){
                String a = sc.next();
                String b = sc.next();
                compare(a,b,mA,mB);
            }
            System.out.println(mA.win + " " + mA.tie + " " + mA.lose);
            System.out.println(mB.win + " " + mB.tie + " " + mB.lose);
            System.out.println(getMost(mA.map) + " " + getMost(mB.map));
        }
    }

    private static String getMost(Map<String,Integer> map) {
        if (map.get("C") >= map.get("J")){
            if (map.get("C") > map.get("B")){
                return "C";
            }else {
                return "B";
            }
        }else{
            if (map.get("J") > map.get("B")){
                return "J";
            }else {
                return "B";
            }
        }
    }

    private static void compare(String a, String b, Model mA, Model mB) {
        if (a.equals("C")){
            if (b.equals("C")){
                mA.tie++;
                mB.tie++;
            }else if (b.equals("J")){
                mA.win++;
                mB.lose++;
                mA.map.put("C",mA.map.get("C")+1);
            }else {
                mA.lose++;
                mB.win++;
                mB.map.put("B",mB.map.get("B")+1);
            }
        }else if (a.equals("J")){
            if (b.equals("J")){
                mA.tie++;
                mB.tie++;
            }else if (b.equals("C")){
                mA.lose++;
                mB.win++;
                mB.map.put("C",mB.map.get("C")+1);
            }else {
                mA.win++;
                mB.lose++;
                mA.map.put("J",mA.map.get("J")+1);
            }
        }else {
            if (b.equals("B")){
                mA.tie++;
                mB.tie++;
            }else if (b.equals("J")){
                mA.lose++;
                mB.win++;
                mB.map.put("J",mB.map.get("J")+1);
            }else {
                mA.win++;
                mB.lose++;
                mA.map.put("B",mA.map.get("B")+1);
            }
        }
    }

    static class Model{
        int win;
        int tie;
        int lose;
        Map<String,Integer> map;
        Model(){
            map = new HashMap<>();
            map.put("C",0);
            map.put("J",0);
            map.put("B",0);
        }
    }
}
