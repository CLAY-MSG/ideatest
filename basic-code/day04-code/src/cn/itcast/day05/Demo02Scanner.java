package cn.itcast.day05;

import java.util.Scanner;

public class Demo02Scanner {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int a = sc.nextInt();
        System.out.println("请输入第二个整数：");
        int b = sc.nextInt();
        int sum;
        sum = a + b;
        System.out.println(sum);
        */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int a = sc.nextInt();
        System.out.println("请输入一个整数");
        int b = sc.nextInt();
        System.out.println("请输入一个整数");
        int c = sc.nextInt();
        int max;
        /*if(a > b && a > c){
            max = a;
            System.out.println(max);
        }else if(b > a && b > c){
            max = b;
            System.out.println(max);
        }else if(c > a && c > b){
            max = c;
            System.out.println(max);
        }*/
        int temp = (a > b ? a : b);
        max = (c > temp ? c : temp);
        System.out.println(max);

    }
}
