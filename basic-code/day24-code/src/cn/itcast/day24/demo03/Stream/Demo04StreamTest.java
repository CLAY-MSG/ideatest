package cn.itcast.day24.demo03.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    将上一题当中的传统for循环写法更换为Stream流式处理方式。两个集合的初始内容不变， Person 类的定义也不
    变。
*/
public class Demo04StreamTest {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        /*ArrayList<String> newOne = new ArrayList<>();
        one.stream().filter((s)->{
            return s.length() == 3;
        }).limit(3).forEach((s)->{
            newOne.add(s);
        });*/

        Stream<String> oneStream = one.stream().filter(s-> s.length() == 3).limit(3);

        /*ArrayList<String> newTwo = new ArrayList<>();
        two.stream().filter((s)->{
            return s.startsWith("张");
        }).skip(2).forEach((s)->{
            newTwo.add(s);
        });*/

        Stream<String> twoStream = two.stream().filter(s->s.startsWith("张")).skip(2);

       /* ArrayList<String> list = new ArrayList<>();
        newOne.stream().forEach((s)->{
            list.add(s);
        });
        newTwo.stream().forEach((s)->{
            list.add(s);
        });*/

//       Stream.concat(oneStream, twoStream).map(name -> new Person(name)).forEach((s)->System.out.println(s));
//        用方法引用简写lamdam表达式
        Stream.concat(oneStream, twoStream).map(name -> new Person(name)).forEach(System.out::println);

//        System.out.println(list);
    }
}
