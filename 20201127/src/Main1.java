import java.util.Scanner;
/*n个数里出现次数大于等于n/2的数
输入n个整数，输出出现次数大于等于数组长度一半的数
输入描述：每个测试输入包含n个空格分隔的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2
输出出现次数大于等于n/2的数*/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int count = 0;
        String tmp = null;
        for (int i = 0;i < arr.length;i++){
            if (count == 0){
                tmp = arr[i];
                count++;
            }else {
                if (tmp.equals(arr[i])){
                    count++;
                }else {
                    count--;
                }
            }
        }
        System.out.println(tmp);
    }
}
