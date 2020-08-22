import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//X 和同学跳高跳远
// 给定一个n为人数
//第二行和第三行输入n个字母 代表n个人的成绩排名（每个字母都不相同）
//例：输入 10
//        ABCDEFXIGH  X前面有ABCDEF
//        AHCXBDEFIG  X前面有AHC 所以两次相比 X 最好成绩是第三名 最差成绩第八名
//输出 3 8
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr1 = new String[n];
        String[] arr2 = new String[n];
        for (int i = 0;i < n;i++){
            arr1[i] = sc.next();
        }
        for (int i = 0;i < n;i++){
            arr2[i] = sc.next();
        }
        int count = 0;
        int count2 = 0;
        for (int i = 0;i < n;i++){
            if (arr1[i].equals("X")){
                count = i;
                break;
            }
        }
        for (int i = 0;i < n;i++){
            if (arr2[i].equals("X")){
                count2 = i;
                break;
            }
        }
        //System.out.println(count + " " + count2);
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0;i < count;i++){
            set.add(arr1[i]);
        }
        for (int i = count;i < n;i++){
            set2.add(arr1[i]);
        }
        int first = 1;
        int end = n+1;
        for (int i = 0;i < count2;i++){
            if (set.contains(arr2[i])){
                first++;
            }
        }
        for (int i = count2;i < n;i++){
            if (set2.contains(arr2[i])){
                end--;
            }
        }
        System.out.println(first + " " + end);
    }
}
