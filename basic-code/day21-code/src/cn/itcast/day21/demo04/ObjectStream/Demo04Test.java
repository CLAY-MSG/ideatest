package cn.itcast.day21.demo04.ObjectStream;

import java.io.*;
import java.util.ArrayList;



/*
    1. 将存有多个自定义对象的集合序列化操作，保存到list.txt 文件中。
    2. 反序列化list.txt ，并遍历集合，打印对象信息。
    案例分析
    1. 把若干学生对象 ，保存到集合中。
    2. 把集合序列化。
    3. 反序列化读取时，只需要读取一次，转换为集合类型。
    4. 遍历集合，可以打印所有的学生信息
*/
public class Demo04Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p1 = new Person("小张",18);
        Person p2 = new Person("小王",19);
        Person p3 = new Person("小李",26);
        Person p4 = new Person("小赵",17);
        Person p5 = new Person("小钱",23);
        Person p6 = new Person("小孙",21);

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\1Test\\list.txt"));
        oos.writeObject(list);

        ObjectInputStream ois =new ObjectInputStream(new FileInputStream("D:\\1Test\\list.txt"));
        Object o2 = ois.readObject();
        ArrayList<Person> list1 = (ArrayList<Person>)o2;
        for (Person p:list1
             ) {
            System.out.println(p.getName()+":"+p.getAge());
        }


        ois.close();
        oos.close();

    }

}
