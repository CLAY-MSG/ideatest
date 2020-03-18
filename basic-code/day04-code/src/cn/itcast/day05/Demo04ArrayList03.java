package cn.itcast.day05;


import java.util.ArrayList;

//定义以指定格式打印集合的方法(ArrayList类型作为参数)，使用{}扩起集合，使用@分隔每个元素。格式参照 {元素
//@元素@元素}。
public class Demo04ArrayList03 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("小张");
        al.add("小里");
        al.add("小关");
        al.add("小孙");
        arrayList(al);
    }
    public static void arrayList(ArrayList<String> arrayListP){
        System.out.println("{"+arrayListP.get(0)+"@"+arrayListP.get(1)+"@"+arrayListP.get(2)+"@"+arrayListP.get(3)+"}");
        // 拼接左括号
        System.out.print("{");
        // 遍历集合
        for (int i = 0; i < arrayListP.size(); i++) {
            // 获取元素
            String s = arrayListP.get(i);
            // 拼接@符号
            if (i != arrayListP.size() - 1) {
                System.out.print(s + "@");
            } else {
        // 拼接右括号
                System.out.print(s + "}");
            }
        }

    }
}
