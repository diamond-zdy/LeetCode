import java.util.Scanner;

/**计算日期到天数转换
 * 链接：https://www.nowcoder.com/questionTerminal/769d45d455fe40b385ba32f97e7bcded
 * 来源：牛客网
 *
 * 根据输入的日期，计算是这一年的第几天。。
 *
 * 详细描述：
 *
 * 输入某年某月某日，判断这一天是这一年的第几天？。
 *
 * 接口设计及说明：
 *
 *  /*****************************************************************************
 *  Description   : 数据转换
 *  Input Param   : year 输入年份
 *                 Month 输入月份
 *                 Day 输入天
 *
 *  Output Param  :
 *  Return Value  : 成功返回0，失败返回-1（如：数据错误）
 *  *****************************************************************************/
 /*

public static int iConverDateToDay(int year,int month,int day)
        *{
        *      /* 在这里实现功能，将结果填入输入数组中
        return 0;
        }*/

         /*****************************************************************************
  Description   :
   Input Param   :

   Output Param  :
   Return Value  : 成功:返回outDay输出计算后的第几天;
                                            失败:返回-1
   *****************************************************************************/
        /*public static int getOutDay()
        *{
        *return 0;
        *}
        *
        *
        *
        *
        *
        *
        *
        *
        *
        *
        *输入描述:
        *输入三行，分别是年，月，日
        *
        *
        *
        *输出描述:
        *成功:返回outDay输出计算后的第几天;
        *失败:返回-1
        *
        *示例1
        *输入
        *2012
        *12
        *31
        *输出
        *366
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int outday = Day(year,month,day);
            System.out.println(outday);
        }
    }

    private static int Day(int year, int month, int day) {
        int[] Day = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (year <= 0 || month <= 0 || day <= 0 || month > 12 || day > Day[month-1]){
            return -1;
        }else if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            Day[1] = 29;
        }
        int sum = 0;
        for (int i = 0;i < month-1;i++){
            sum += Day[i];
        }
        return sum+day;
    }
}
