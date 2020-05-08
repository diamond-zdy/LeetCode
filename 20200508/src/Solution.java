/**二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public static boolean Find(int target, int [][] array) {
        int hang = array.length;
        int lie = array[0].length;
        int row = 0;
        int column = lie-1;
        while (row < hang && column >= 0){
            int value = array[row][column];
            if (value < target){
                row++;
            }else if (value > target){
                column--;
            }else if (value == target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        boolean found = Find(0,arr);
        System.out.println(found);
    }
}