package cn.itcast.day11.demo01RedPacketDemo;

import cn.itcast.day11.demo01known.OpenMode;

import java.util.ArrayList;
import java.util.Random;

public class Lucky implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {

        ArrayList<Integer> luckArrayList = new ArrayList<>();

        Random random = new Random();
        totalMoney = totalMoney*100;
        int count = totalCount - 1;

        for (int i = 0; i < count; i++) {

            int money =random.nextInt((totalMoney/totalCount)*2 + 1);
            luckArrayList.add(money/100);
            totalMoney = totalMoney - money;
            totalCount--;
        }

        luckArrayList.add(totalMoney/100);

        System.out.println("运气红包金额"+luckArrayList);

        return luckArrayList;
    }
}
