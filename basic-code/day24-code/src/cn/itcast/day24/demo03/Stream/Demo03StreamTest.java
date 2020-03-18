package cn.itcast.day24.demo03.Stream;

import java.util.ArrayList;

/*
    现在有两个ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以
    下若干操作步骤：
        1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        6. 根据姓名创建Person 对象；存储到一个新集合中。
        7. 打印整个队伍的Person对象信息。
        import java.util.ArrayList;
        import java.util.List;
        public class DemoArrayListNames {
            public static void main(String[] args) {
                //第一支队伍
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
            }
        }
        public class Person {
            private String name;
            public Person() {}
            public Person(String name) {
                this.name = name;
            }
            @Override
            public String toString() {
                return "Person{name='" + name + "'}";
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
         }

    */
public class Demo03StreamTest {
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
        ArrayList<String> newOne1 = new ArrayList<>();
        ArrayList<String> newOne2 = new ArrayList<>();
        for (String str1:one
             ) {
            if (str1.length()==3){
                newOne1.add(str1);
            }
        }
        for (int i = 0; i < 3; i++) {
            newOne2.add(newOne1.get(i));
        }

        ArrayList<String> newTwo1 = new ArrayList<>();
        ArrayList<String> newTwo2 = new ArrayList<>();
        for (String str2:two
             ) {
            if(str2.startsWith("张")){
                newTwo1.add(str2);
            }
        }
        for (int i = 2; i < newTwo1.size(); i++) {
            newTwo2.add(newTwo1.get(i));
        }

        ArrayList<String> list = new ArrayList<>();
        for (String str:newOne2
             ) {
            list.add(str);
        }
        for (String str:newTwo2
             ) {
            list.add(str);
        }

        ArrayList<Person> personArrayList = new ArrayList<>();
        for (String str:list
             ) {
            Person p = new Person(str);
            personArrayList.add(p);

        }
        System.out.println(personArrayList);
    }

}
