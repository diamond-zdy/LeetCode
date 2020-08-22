import java.util.Scanner;
//螺旋打印斐波那契数
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n][n];
        int right = 1,down = 2,left = 3,up = 4;
        int num = n*n;
        int dir = right;//标记
        int[] arr = new int[num];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2;i < num;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        int i = 0,j = 0;//i,j必须放外面，否则打印有误
        for (int p = num-1;p >= 0;p--){
            res[i][j] = arr[p];
            if (dir == right){ //从左向右打印
                if (j +1 < n && res[i][j+1] == 0){
                    j++;
                }else {//打印到头，从上到下打印
                    i++;
                    dir = down;
                    continue;
                }
            }
            if (dir == down){//从上到下打印
                if (i+1 < n && res[i+1][j] == 0){
                    i++;
                }else {
                    j--;
                    dir = left;//打印到头，从右到左打印
                    continue;
                }
            }
            if (dir == left){//从右到左打印
                if (j-1 >= 0 && res[i][j-1] == 0) {
                    j--;
                }else {
                    i--;
                    dir = up;//打印到头，从下到上打印
                    continue;
                }
            }
            if (dir == up){//从下到上打印
                if (i-1 >= 0 && res[i-1][j] == 0){
                    i--;
                }else {
                    j++;
                    dir = right;//打印到头，从左到右打印
                    continue;
                }
            }
        }
        for (int p = 0;p < res.length;p++){
            for (int q = 0;q < res.length;q++){
                System.out.print(res[p][q] + " ");
            }
            System.out.println();
        }
    }
}
