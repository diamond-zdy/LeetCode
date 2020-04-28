import java.util.*;

/**顺时针打印矩阵
 * 链接：https://www.nowcoder.com/questionTerminal/97e7a475d2a84eacb60ee545597a8407?f=discussion
 * 来源：牛客网
 *
 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 *
 * 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
 *
 * 测试样例：
 * [[1,2],[3,4]],2,2
 * 返回：[1,2,4,3]
 */
public class Printer {
    public static int[] clockwisePrint(int[][] mat, int n, int m) {

        int startX = 0;
        int endX = m - 1;
        int startY = 0;
        int endY = n - 1;
        int index = 0;
        int[] result = new int[n * m];

        while (startX <= endX && startY <= endY) {

            // 从左到右打印
            if(startX <= endX){
                for (int i = startX; i <= endX; i++) {
                    result[index++] = mat[startY][i];
                }
            }
            // 从上往下打印
            if (startY < endY) {
                for (int i = startY + 1; i <= endY; i++) {
                    result[index++] = mat[i][endX];
                }
            }
            // 从右往左打印
            if (startX < endX && endY > startY) {
                for (int i = endX - 1; i >= startX; i--) {
                    result[index++] = mat[endY][i];
                }
            }
            // 从下往上打印
            if (startY < endY && endX > startX) {
                for (int i = endY - 1; i >= startY + 1; i--) {
                    result[index++] = mat[i][startX];
                }
            }
            startX++;
            endX--;
            startY++;
            endY--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4}};
        int[] res = clockwisePrint(arr,2,2);
        System.out.println(Arrays.toString(res));
    }
}