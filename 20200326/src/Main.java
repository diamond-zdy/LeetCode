import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String shop = sc.nextLine();
            String need = sc.nextLine();
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0;i < shop.length();i++){
                char ch = shop.charAt(i);
                list.add(ch);
            }
            int count = 0;
            for (int i = 0;i < need.length();i++){
                char ch = need.charAt(i);
                for (int j = 0;j < list.size();j++){
                    if (ch == list.get(j)){
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if (count == need.length()){
                System.out.println("Yes " + (shop.length()-count));
            }else {
                System.out.println("No " + (need.length()-count));
            }
        }
    }
}
