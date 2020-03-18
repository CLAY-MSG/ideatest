package cn.itcast.day11.demo01RedPacketDemo;

import cn.itcast.day11.demo01known.OpenMode;

import java.util.ArrayList;

public class Common implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        totalMoney = totalMoney * 100;

        int money = totalMoney / totalCount;

        int l = totalCount%totalCount;

        for (int i = 0; i < totalCount - 1; i++) {

            arrayList.add(money/100);

        }
        arrayList.add((money+l)/100);

        System.out.println("普通红包金额"+arrayList);

        return arrayList;
    }
}
