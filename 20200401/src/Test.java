import java.math.BigInteger;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String IP = sc.nextLine();
            String IP10 = sc.nextLine();
            System.out.println(IPtoLong(IP));
            System.out.println(LongToIP(IP10));
        }
    }

    private static String LongToIP(String ip10) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder(Long.toBinaryString(Long.valueOf(ip10)));
        while (sb.length() < 32){
            sb.insert(0,'0');
        }
        for (int i = 0;i < 32;i += 8){
            String str = sb.substring(i,i+8);
            BigInteger bigInteger = new BigInteger(str,2);
            stringBuilder.append(bigInteger.intValue()).append(".");
        }
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        return stringBuilder.toString();
    }

    private static long IPtoLong(String ip) {
        String[] str = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String string:str) {
            int num = Integer.parseInt(string);
            if (num >=0 && num <= 255){
                StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(num));
                while (stringBuilder.length() < 8){
                    stringBuilder.insert(0,'0');
                }
                sb.append(stringBuilder.toString());

            }
        }
        return Long.valueOf(sb.toString(),2);
    }
}
