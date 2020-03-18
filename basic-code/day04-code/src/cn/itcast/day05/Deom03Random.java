package cn.itcast.day05;

import java.util.Random;
import java.util.Scanner;

public class Deom03Random {
    public static void main(String[] args) {
        /*int n = 50;
        Random r = new Random();
        int a = r.nextInt(n) + 1;
        System.out.println(a);*/
        Random r = new Random();
        int number = r.nextInt(100)+1;
        System.out.println(number);
        while (true) {
            System.out.println("请输入一个数字");
            Scanner sc = new Scanner(System.in);
            int guessNumber = sc.nextInt();
            if (guessNumber > number) {
                System.out.println("大了，请重新输入");
            } else if(guessNumber < number){
                System.out.println("小了，请重新输入");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
