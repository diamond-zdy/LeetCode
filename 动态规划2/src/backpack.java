//背包问题
public class backpack {
    public int backPackII(int m, int[] A, int[] V){
        if(m == 0){
            return 0;
        }
        int n = A.length;
        int[][] arr = new int[n+1][m+1];
        for (int i = 0;i <= n;i++){
            arr[i][0] = 0;
        }
        for (int i = 0;i <= m;i++){
            arr[0][i] = 0;
        }
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= m;j++){
                if (A[i-1] > j){
                    arr[i][j] = arr[i-1][j];
                }else {
                    int newvalue = arr[i-1][j-A[i-1]] + V[i-1];
                    arr[i][j] = Math.max(newvalue,arr[i-1][j]);
                }
            }
        }
        return arr[n][m];
    }
}
