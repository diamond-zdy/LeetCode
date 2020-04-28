import java.util.*;

/**左右最值最大差
 * 链接：https://www.nowcoder.com/questionTerminal/f5805cc389394cf69d89b29c0430ff27?f=discussion
 * 来源：牛客网
 *
 * 给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K]，右部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？
 *
 * 给定整数数组A和数组的大小n，请返回题目所求的答案。
 *
 * 测试样例：
 * [2,7,3,1,1],5
 * 返回：6
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {2,7,3,1,1};
        int res = findMaxGap(A,5);
        System.out.println(res);
    }
    public static int findMaxGap(int[] A, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < n;i++){
            if (max < A[i]) max = A[i];
        }
        return max - Math.min(A[0],A[n-1]);
    }
}
