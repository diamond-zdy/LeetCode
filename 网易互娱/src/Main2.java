import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    //先画出地图找出起点和终点的位置
    //广度优先搜索找出最短路径
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int N = sc.nextInt();
            int[][] arr = new int[N+1][N+1];
            int q = N/2;
            int row = q;
            int col = q;
            arr[row][col] = 1;
            for (int i = 0;i < N;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (b == 1){
                    if (a == 0){
                        row -= 1;
                    }else if (a == 1){
                        row += 1;
                    }else if (a == 2){
                        col -= 1;
                    }else if (a == 3){
                        col += 1;
                    }
                }
                arr[row][col] = 1;
            }
            int rowZ = row;
            int colZ = col;
            arr[rowZ][colZ] = 1;
            for (int i = 0;i < N;i++){
                for (int j = 0;j < N;j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            int flg = BFS(q,q,rowZ,colZ,arr);
            System.out.println(flg);
        }
    }

    private static int BFS(int x, int y, int xZ, int yZ, int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int res = Integer.MAX_VALUE;
        int count = 0;
        Queue<node> q = new LinkedList<>();
        int[][] book = new int[m][n];
        q.offer(new node(x,y));
        book[x][y] = 1;
        int[][] next = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean flg = false;
        while (!q.isEmpty()){
            for (int i = 0;i < 4;i++){
                int nx = q.peek().x + next[i][0];
                int ny = q.peek().y + next[i][1];
                if (nx >= n || nx < 0 || ny >= m || ny < 0){
                    continue;
                }
                if (arr[nx][ny] == 1 && book[nx][ny] ==0){
                    q.offer(new node(nx,ny));
                    book[nx][ny] = 1;
                    count++;
                }
                if (nx == xZ && ny == yZ){
                    flg = true;
                    if (count < res){
                        res = count;
                    }
                    break;
                }
            }
            if (flg){
                break;
            }
            q.poll();
        }
        return res;
    }
}
class node{
    public int x;
    public int y;

    public node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
