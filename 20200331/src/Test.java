import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            Map<String,Integer> map = new LinkedHashMap<>();
            for (int i = 0;i < n;i++){
                map.put(sc.next(),0);
            }
            int m = sc.nextInt();
            int invalid = 0;
            for (int i = 0;i < m;i++){
                String str = sc.next();
                if (map.get(str) == null){
                    invalid++;
                }else {
                    map.put(str,map.get(str)+1);
                }
            }
            for (Map.Entry entry: map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            System.out.println("Invalid :" + invalid);
        }
    }
}
