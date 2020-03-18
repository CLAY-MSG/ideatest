package cn.itcast.day08;


//请使用Math 相关的API，计算在 -10.8 到5.9 之间，绝对值大于6 或者小于2.1 的整数有多少个？
public class Demo05Math {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        for (double i = -10.8; i < 5.9; i++) {
            if (Math.abs(Math.ceil(i)) > 6 || Math.abs(Math.ceil(i)) < 2.1) {
                a++;
                System.out.println(i);
            }
        }
        System.out.println(a);
    }
}
