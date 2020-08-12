import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(",");
        char[] c = s[0].toCharArray();
        int len = s[0].length();
        int col = Integer.valueOf(s[1]);
        int n = 2*col-1;
        int q = (len/n)*col;
        int p = len%n;
        if (p != 0){
            if (p < col){
                q += ((p/2)+(p%2));
            }else {
                q += ((p/2+1)+(p%2));
            }
        }
        int row = q;
        int m = 0;
        int tmp = col/2;
        char[][] ch = new char[row][col];
        while (m < len){
            for (int i = 0;i < row;i++){
                for (int j = 0;j < col;j++){
                    if (j == i%col || j == (col-i)%col){
                        ch[i][j] = c[m];
                        m++;
                    }else ch[i][j] = 'a';
                }
            }
        }
        int i = 0;
        int j = 0;
        while (i < col){
            while (j < row){
                if (ch[j][i] != 'a'){
                    System.out.print(ch[i][j]);
                }
                j++;
            }
            i++;
        }
    }
}
