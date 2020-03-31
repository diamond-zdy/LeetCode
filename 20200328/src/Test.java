import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] score = new int[N];
            int i = 0;
            for (i = 0;i < N;i++){
                score[i] = sc.nextInt();
            }
            for (i = 0;i < M;i++){
                String c = sc.next();
                int A = sc.nextInt();
                int B = sc.nextInt();
                process(c,A,B,score);
            }
        }
    }

    private static void process(String c, int A, int B, int[] score) {
        int begin,end;
        if (c.equals("Q")){
            end = Math.max(A,B);
            begin = Math.min(A,B)-1;
            int max = score[begin];
            for (int i = begin;i < end;i++){
                if (max < score[i]){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else if (c.equals("U")){
            score[A-1] = B;
        }
    }
}
