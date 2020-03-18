package cn.itcast.day13.demo04.Doudizhu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*按照斗地主的规则，完成洗牌发牌的动作。
    具体规则：使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。*/
/*
 * 准备牌：

 牌可以设计为一个ArrayList<String>,每个字符串为一张牌。
 每张牌由花色数字两部分组成，我们可以使用花色集合与数字集合嵌套迭代完成每张牌的组装。
 牌由Collections类的shuffle方法进行随机排序。

 * 发牌

 将每个人以及底牌设计为ArrayList<String>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。


 * 看牌

 直接打印每个集合。*/
public class Doudizhu {
    public static void main(String[] args) {
        ArrayList<String> huaseList= new ArrayList<>();
        ArrayList<String> numberList =new ArrayList<>();
        ArrayList<String> pokerList = new ArrayList<>();

        huaseList.add("♠");
        huaseList.add("♥");
        huaseList.add("♣");
        huaseList.add("♦");

        for (int i = 2; i <= 10; i++) {
            numberList.add(i+"");
        };
        numberList.add("A");
        numberList.add("J");
        numberList.add("Q");
        numberList.add("K");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                String str = huaseList.get(i).concat(numberList.get(j));
                pokerList.add(str);
            }
        }

        pokerList.add("大王");
        pokerList.add("小王");

        Collections.shuffle(pokerList);

        Doudizhu.fapai(pokerList);


    }
    public static void fapai(ArrayList<String> poker){
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (int i = 0; i <= 53; i++) {
            if(i%3==0){
                player1.add(poker.get(i));
            }else if(i%3==1){
                player2.add(poker.get(i));
            }else if(i%3==2){
                player3.add(poker.get(i));
            }
            if(i>=51){
                dipai.add(poker.get(i));
            }
        }

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(dipai);
    }

}
