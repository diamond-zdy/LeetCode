import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] ch = in.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            Set<Character> set = new HashSet<Character>();
            for(int i = 0;i<ch.length;i++){
                if(set.add(ch[i]))
                    sb.append(ch[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
