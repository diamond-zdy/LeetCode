//堆积木
//        时间限制： 3000MS
//        内存限制： 589824KB
//        题目描述：
//        同同在玩积木，每个积木上都有一个独一无二的二进制数字。同同的积木有特殊的规则，只有满足规则的积木才能被垒到一起。
//
//        对于一个积木，如果积木上写的数字是a，则对于所有的写着数字b的积木，只要满足a∩b=b,其中∩代表二进制与运算，
//        则积木b可以放到积木a的上面。每一堆积木最多仅有一个积木可以充当底座，被放在底座上的所有积木都必须满足上述关系。
//       （只要底座和积木满足关系即可以放在一堆，不需要考虑如何码放）
//
//        同同有一只笔，只能使用一次，效果是把某一个积木上数字的某一位从0改成1或者从1改成0。请问同同最少能让积木分在几堆里。

import java.util.Scanner;

//        输入描述
//        第一行两个数n,m(1≤m≤20,1≤n≤min(105,2m))，分别代表积木的数量和积木上数字对应二进制位最多有几位
//        第二行n个整数a1,a2,...,an(0≤ai≤2m)，代表每个积木上写的二进制数字的十进制表示形式。
//
//        输入保证每个积木上的数字不重复。
//
//        输出描述
//        一行一个整数代表最少的堆数。
public class Test2 {

}
