import java.util.Scanner;

/*
有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？


         

            
      * 统计出兔子总数。
      * 
      * @param monthCount 第几个月
      * @return 兔子总数
      
            public static int getTotalCount(int monthCount)
            {
                return 0;
            }
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int month = sc.nextInt();
            System.out.println(getTotalCount(month));
        }
    }
    public static int getTotalCount(int monthCount){
        int count = 0;
        if (monthCount >= 4){
            count = getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
        }else if (monthCount == 3){
            count = 2;
        }else {
            count = 1;
        }
        return count;
    }
}
