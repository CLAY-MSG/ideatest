package cn.itcast.day15.demo06.Test;

import java.util.*;

//按照斗地主的规则，完成洗牌发牌的动作。
/*具体规则：
    1. 组装54张扑克牌将
    2. 54张牌顺序打乱
    3. 三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
    4. 查看三人各自手中的牌（按照牌的大小排序）、底牌
    规则：手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
    */
/*
    1. 准备牌：
    完成数字与纸牌的映射关系：
    使用双列Map(HashMap)集合，完成一个数字与字符串纸牌的对应关系(相当于一个字典)。
    2. 洗牌：
    通过数字完成洗牌发牌
    3. 发牌：
    将每个人以及底牌设计为ArrayList,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。
    存放的过程中要求数字大小与斗地主规则的大小对应。
    将代表不同纸牌的数字分配给不同的玩家与底牌。
    4. 看牌：
    通过Map集合找到对应字符展示。
    通过查询纸牌与数字的对应关系，由数字转成纸牌字符串再进行展示。
    */
public class DoudizhuTest {
    public static void main(String[] args) {
        ArrayList<String> huaseList = new ArrayList<>();
        ArrayList<String> paimianList = new ArrayList<>();
        ArrayList<String> pokeList = new ArrayList<>();
        LinkedHashMap<Integer,String> pokeMap = new LinkedHashMap<>();

        /*huaseList.add("♥");
        huaseList.add("♠");
        huaseList.add("♦");
        huaseList.add("♣");*/
        Collections.addAll(huaseList,"♥","♠","♦","♣");

        /*paimianList.add(2+"");
        paimianList.add("A");
        paimianList.add("K");
        paimianList.add("Q");
        paimianList.add("J");
        for (int i = 10; i >= 3; i--) {

            paimianList.add(i+"");

        }*/
        Collections.addAll(paimianList,"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4",
                "3");

        /*for (String str1:paimianList
             ) {
            for (String str2:huaseList
                 ) {
                String str =str2.concat(str1);
                pokeList.add(str);
            }
        }

        pokeMap.put(0,"大王");
        pokeMap.put(1,"小王");
        for (int i = 2,j = 0; i <= 53; i++, j++) {
            pokeMap.put(i,pokeList.get(j));
        }*/
        int count = 2;
        pokeMap.put(0,"大王");
        pokeMap.put(1,"小王");
        for (String str1:huaseList
             ) {
            for (String str2:paimianList
                 ) {
                pokeMap.put(count++,str1.concat(str2));
            }
        }

        ArrayList<Integer> numberList = new ArrayList<>();
        Set<Integer> numberSet =pokeMap.keySet();
        /*for (int a:numberSet
             ) {
            numberList.add(a);
        }*/
        numberList.addAll(numberSet);

        Collections.shuffle(numberList);

        ArrayList<String> play1List = new ArrayList<>();
        ArrayList<String> play2List = new ArrayList<>();
        ArrayList<String> play3List = new ArrayList<>();
        ArrayList<String> dipaiList = new ArrayList<>();
        List<Integer> play1NumberList = new ArrayList<>();
        List<Integer> play2NumberList = new ArrayList<>();
        List<Integer> play3NumberList = new ArrayList<>();
        List<Integer> dipaiNumberList = new ArrayList<>();

        for (int i = 0; i <= 53; i++) {
            if(i%3==0){
                play1NumberList.add(numberList.get(i));
            }else if(i%3==1){
                play2NumberList.add(numberList.get(i));
            }else if(i%3==2){
                play3NumberList.add(numberList.get(i));
            }
            if(i>=51){
                dipaiNumberList.add(numberList.get(i));
            }
        }

        /*play1NumberList.sort((o1, o2) -> o1-o2);
        play2NumberList.sort((o1, o2) -> o1-o2);
        play3NumberList.sort((o1, o2) -> o1-o2);
        dipaiNumberList.sort((o1, o2) -> o1-o2);*/
        Collections.sort(play1NumberList);
        Collections.sort(play2NumberList);
        Collections.sort(play3NumberList);
        Collections.sort(dipaiNumberList);

        for (int i = 0; i < play1NumberList.size(); i++) {
            play1List.add(pokeMap.get(play1NumberList.get(i)));
            play2List.add(pokeMap.get(play2NumberList.get(i)));
            play3List.add(pokeMap.get(play3NumberList.get(i)));
        }
        for (int i = 0; i < dipaiNumberList.size(); i++) {
            dipaiList.add(pokeMap.get(dipaiNumberList.get(i)));
        }
        /*for (int a:play1NumberList
             ) {
            play1List.add(pokeMap.get(a));
        }
        for (int a:play2NumberList
        ) {
            play2List.add(pokeMap.get(a));
        }
        for (int a:play3NumberList
        ) {
            play3List.add(pokeMap.get(a));
        }
        for (int a:dipaiNumberList
        ) {
            dipaiList.add(pokeMap.get(a));
        }*/

        System.out.println(play1List);
        System.out.println(play2List);
        System.out.println(play3List);
        System.out.println(dipaiList);

    }
}
