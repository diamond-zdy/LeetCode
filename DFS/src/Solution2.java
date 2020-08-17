
public class Solution2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int oldColor = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        //建立标记
        int[][] book = new int[row][col];
        dfs(image,row,col,sr,sc,oldColor,newColor,book);
        return image;
    }

    private void dfs(int[][] image,int row,int col, int sr, int sc, int oldColor, int newColor,int[][] book) {
        int[][] next = {{0,1},{0,-1},{-1,0},{1,0}};
        //处理当前逻辑，并标记染色过了
        image[sr][sc] = newColor;
        book[sr][sc] = 1;
        //遍历每一种可能，四个方向
        for (int i = 0;i < 4;i++){
            int newSr = sr + next[i][0];
            int newSc = sc + next[i][1];
            //判断位置是否越界
            if (newSr >= row || newSr < 0
                    || newSc >= col || newSc < 0){
                continue;
            }
            //如果符合要求且没被渲染过，则继续渲染
            if (image[newSr][newSc] == oldColor && book[newSr][newSc] == 0){
                dfs(image,row,col,newSr,newSc,oldColor,newColor,book);

            }
        }
    }
}
