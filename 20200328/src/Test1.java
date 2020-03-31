public class Test1 {
    public static void main(String[] args) {
        System.out.printf("%d\n", foo(20, 13));
    }
    public static int foo(int x, int y){
        if (x <= 0 || y <= 0)
            return 1;
        return 3 * foo( x-6, y/2 );
    }
}
