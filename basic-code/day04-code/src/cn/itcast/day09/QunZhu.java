package cn.itcast.day09;

import java.util.ArrayList;

public class QunZhu extends User{

    public QunZhu() {
    }

    public QunZhu(String name, double leftMoney) {
        super(name, leftMoney);
    }

    public ArrayList<Double> send(double money , int count){

        double leftMoney = getLeftMoney();

        if (money > leftMoney) {
            return null;
        }
        setLeftMoney(leftMoney-money);

        ArrayList<Double> list= new ArrayList<>();
        money = money * 100;
        double m = money / count;
        double l = money % count;

        for (int i = 0; i < count - 1; i++) {
            list.add(m/100.0);

        }
        if( l == 0){
            list.add(m/100.0);
        }else {
            list.add((m+l)/100.0);
        }
        return list;
    }
}
