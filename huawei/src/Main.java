import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*
某咖啡店每杯咖啡售价5元
每位客户只买一杯咖啡，客户支付面额为5,10,20 购物之后根据面额给客户找钱
开始备用零钱为0
根据客户购买顺序，返回是否可以正确找零钱以及当前客户序号
说明：如果能正确找零，则返回最后一个客户的序号，如果不能，则返回当前客户序号
客户编号从1开始
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(",");
            int len = arr.length;
            boolean res = true;
            int[] tmp = new int[3];
            //int max = 0;
            for (int i = 0;i < len;i++){

                if (Integer.valueOf(arr[i]) == 10){
                    if (tmp[0] >= 1){
                        tmp[0]--;
                        tmp[1]++;
                    }else {
                        res = false;
                        System.out.print(res + ",");
                        System.out.print(i+1);
                        break;
                    }
                }else if(Integer.valueOf(arr[i]) == 5){
                    tmp[0]++;
                }else if (Integer.valueOf(arr[i]) == 20){
                    if (tmp[0]>=1 && tmp[1]>=1){
                        tmp[0]--;
                        tmp[1]--;
                        tmp[2]++;
                    }else if (tmp[0] >= 3 ){
                        tmp[0] -= 3;
                        tmp[2]++;
                    }else {
                        res = false;
                        System.out.print(res + ",");
                        System.out.print(i+1);
                        break;
                    }
                }else {
                    res = false;
                    System.out.print(res + ",");
                    System.out.print(i+1);
                    break;
                }
            }
            if (res == true){
                System.out.print(res + ",");
                System.out.print(len);
            }
        }
    }
}
