import java.util.Scanner;
//一个机器人从（0，0）处开始走，N表示向上走，S表示向下走，E表示向右走，W表示向左走
//如果走到了以前走过的地方则返回True ，否则返回False；
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        if (n == 0){
            System.out.println("False");
        }
        int[][] arr = new int[n*2-1][n*2-1];
        int x = n-1;
        int y = n-1;
        boolean flg = true;
        for (int i = 0;i < n;i++){
            arr[x][y] = 1;
            if (s.charAt(i) == 'N'){
                x--;
                if (arr[x][y] == 1){
                    flg = false;
                    break;
                }
            }
            if (s.charAt(i) == 'S'){
                x++;
                if (arr[x][y] == 1){
                    flg = false;
                    break;
                }
            }
            if (s.charAt(i) == 'E'){
                y++;
                if (arr[x][y] == 1){
                    flg = false;
                    break;
                }
            }
            if (s.charAt(i) == 'W'){
                y--;
                if (arr[x][y] == 1){
                    flg = false;
                    break;
                }
            }
        }
        if (flg){
            System.out.println("False");
        }else {
            System.out.println("True");
        }
    }
}
