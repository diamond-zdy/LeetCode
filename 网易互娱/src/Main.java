import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Stack<Integer>> list = new ArrayList<>();
        for (int i = 0;i < N;i++){
            Stack<Integer> stack = new Stack<>();
            stack.push(sc.nextInt());
            list.add(stack);
        }
        int bag = 0;
        while (M-- > 0){
            int n = sc.nextInt();
            int left = 0;
            int right = 0;
            for (int j = 0;j <= n;j++){
                String s = sc.nextLine();
                String[] strings = s.split(" ");
                if (strings[0].equals("left") && strings[1].equals("take")){
                    if (list.get(Integer.valueOf(strings[2])-1).size() == 1){
                        left = list.get(Integer.valueOf(strings[2])-1).peek();
                    }else {
                        left = list.get(Integer.valueOf(strings[2])-1).pop();
                    }
                }else if (strings[0].equals("left") && strings[1].equals("return")){
                    list.get(Integer.valueOf(strings[2])-1).push(left);
                    left = 0;
                }else if (strings[0].equals("left") && strings[1].equals("keep")){
                    //sum += left;
                    bag += left;
                    left = 0;
                }else if (strings[0].equals("right") && strings[1].equals("take")){
                    if (list.get(Integer.valueOf(strings[2])-1).size() == 1){
                        right = list.get(Integer.valueOf(strings[2])-1).peek();
                    }else {
                        right = list.get(Integer.valueOf(strings[2])-1).pop();
                    }
                }else if (strings[0].equals("right") && strings[1].equals("return")){
                    list.get(Integer.valueOf(strings[2])-1).push(right);
                    right = 0;
                }else if (strings[0].equals("right") && strings[1].equals("keep")) {
                    //sum += left;
                    bag += right;
                    right = 0;
                }
            }
            System.out.println(bag+right+left);
            bag = 0;
        }
    }
}
