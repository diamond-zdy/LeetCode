import java.util.Scanner;

/**球的半径和体积
 * 链接：https://www.nowcoder.com/questionTerminal/4b733a850c364c32b368555c8c2ec96b
 * 来源：牛客网
 *
 * 输入球的中心点和球上某一点的坐标，计算球的半径和体积
 *
 * 输入描述:
 * 球的中心点和球上某一点的坐标，以如下形式输入：x0 y0 z0 x1 y1 z1
 *
 *
 * 输出描述:
 * 输入可能有多组，对于每组输入，输出球的半径和体积，并且结果保留三位小数
 *
 * 为避免精度问题，PI值请使用arccos(-1)。
 * 示例1
 * 输入
 * 0 0 0 1 1 1
 * 输出
 * 1.732 21.766
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            double x0 = sc.nextDouble();
            double y0 = sc.nextDouble();
            double z0 = sc.nextDouble();
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double z1 = sc.nextDouble();
            double R = Math.sqrt((x0-x1)*(x0-x1)+(y0-y1)*(y0-y1)+(z0-z1)*(z0-z1));
            double V = 4*Math.acos(-1)*R*R*R/3;
            System.out.printf("%.3f %.3f",R,V);
        }
    }
}
