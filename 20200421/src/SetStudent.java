class student{
    int sex;
    int age;
    boolean type;
    public boolean check(){
        if (age < 12){
            System.out.println("is a xiao");
            type = true;
        }else {
            System.out.println("is a zhongxue");
            type = false;
        }
        return type;
    }
}
public class SetStudent {
    public static void main(String[] args) {
        student a = new student();
        a.age = 10;
        System.out.println("学生年龄10岁");
        System.out.println(a.check());
        a.age = 15;
        System.out.println("学生年龄15岁");
        System.out.println(a.check());
    }
}
