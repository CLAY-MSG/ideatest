package cn.itcast.day05;


import java.util.ArrayList;
import java.util.Random;

//生成6个1~33之间的随机整数,添加到集合,并遍历
//
public class Demo04ArrayList  {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> al = new ArrayList<>();
        /*int a = r.nextInt(33)+1;
        int b = r.nextInt(33)+1;
        int c = r.nextInt(33)+1;
        int d = r.nextInt(33)+1;
        int e = r.nextInt(33)+1;
        int f = r.nextInt(33)+1;
        al.add(a);
        al.add(b);
        al.add(c);
        al.add(d);
        al.add(e);
        al.add(f);*/
        for (int i = 0; i < 6; i++) {
            int a = r.nextInt(33)+1;
            al.add(a);
        }
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }
}
