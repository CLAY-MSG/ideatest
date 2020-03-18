package cn.itcast.day09;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {

    }

    public Member(String name, double leftMoney) {
        super(name, leftMoney);
    }

    public void accept(ArrayList<Double> arrayList){

        Random rd = new Random();

        int a =rd.nextInt(arrayList.size());

        Double money = arrayList.remove(a);

        double leftMoney = getLeftMoney();

        String str = String.format("%.2f",leftMoney+money);

        double d = Double.valueOf(str);
        setLeftMoney(d);
    }


}
