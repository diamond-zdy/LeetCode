import java.util.*;
//成绩排序
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < n;i++){
            map.put(sc.nextInt(),sc.nextInt());
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o2.getValue() > o1.getValue()){
                    return -1;
                }else if(o2.getValue().equals(o1.getValue())){
                    return o2.getKey() > o1.getKey() ? -1 : 1;
                }
                return 1;
            }
        });
        for (Map.Entry<Integer,Integer> m : list){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

