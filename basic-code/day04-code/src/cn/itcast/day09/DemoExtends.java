package cn.itcast.day09;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoExtends {
    public static void main(String[] args) {
        QunZhu qz = new QunZhu("小计",100000);

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入红包金额");

        double money = scanner.nextDouble();

        System.out.println("请输入红包份数");

        int count = scanner.nextInt();

        ArrayList<Double> sendList = qz.send(money,count);

        if (sendList == null) {
            System.out.println(" 余额不足...");

            return;

        }
        Member member1 = new Member("小张",100);
        Member member2 = new Member("小孙",88);
        Member member3 = new Member("小强",126);


        member1.accept(sendList);
        member2.accept(sendList);
        member3.accept(sendList);

        qz.show();
        member1.show();
        member2.show();
        member3.show();
    }
}
