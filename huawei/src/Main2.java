import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        if (arr[0][0] == 0){
            System.out.println(0);
        }
        boolean flg = true;
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if (arr[i][j+b] == 1){
                    j+=b;
                    if (j >= col){
                        flg = false;
                        break;
                    }
                    continue;
                }else if (arr[i+b][j] == 1){
                    i+=b;
                    if (i >= row){
                        flg = false;
                        break;
                    }
                    continue;
                }else {
                    flg = false;
                    break;
                }
            }
        }
        if (flg == true){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
