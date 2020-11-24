import java.util.*;
/*数组中的逆序对
有一组数，对于其中任意两个数字，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。请设计一个高效的算法，计算给定数组中的逆序对个数
给定一个int数组A和她的大小n，请返回A中的逆序对个数。保证n小于等于5000.*/
public class AntiOrder {
    public int count(int[] A, int n) {
        // write code here
        int res = 0;
        for (int i = 0;i < n-1;i++){
            for (int j = i+1;j < n;j++){
                if (A[i] > A[j]){
                    res++;
                }
            }
        }
        return res;
    }
}