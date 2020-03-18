package cn.itcast.day12.demo05.System;

//验证for循环打印数字1-9999所需要使用的时间（毫秒）

public class test01 {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        for (int i = 1; i <= 9999; i++) {
            System.out.println(i);
        }
        long b = System.currentTimeMillis();
        System.out.println("程序共耗时："+(b-a));
    }
}
