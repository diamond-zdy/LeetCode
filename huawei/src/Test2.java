import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
小明有一个爱好，走路喜欢走在地砖上，并且按照固定的步长走。
某天，小明要通过一个未完工的矩形路面，只有部分区域铺设了地砖格，尝试判断小明是否能按照固定步长N通过区域

 */
class node{
    public int x;
    public int y;
    public node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        boolean arrive = BFS(map,0,0,row - 1,col - 1,s);
        if (arrive){
            System.out.println("1");
        }else {
            System.out.println("0");
        }
    }

    public static boolean BFS(int[][] map, int startx, int starty, int destx,int desty,int s){
        int m = map.length;
        int n = map[0].length;
        Queue<node> q = new LinkedList<>();
        int[][] book = new int[m][n];
        q.offer(new node(startx,starty));
        book[startx][starty] = 1;
        int[][] next = {{-s,0},{s,0},{0,-s},{0,s}};
        boolean flag = false;
        while (!q.isEmpty()){
            for (int i = 0; i < 4; i++) {
                int nx = q.peek().x + next[i][0];
                int ny = q.peek().y + next[i][1];
                if (nx >= m || nx < 0 || ny >= n || ny < 0){
                    continue;
                }
                if (map[nx][ny] == 1 && book[nx][ny] == 0){
                    q.offer(new node(nx,ny));
                    book[nx][ny] = 1;
                }
                if(nx == destx && ny == desty){
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
            q.poll();
        }
        return flag;
    }
}