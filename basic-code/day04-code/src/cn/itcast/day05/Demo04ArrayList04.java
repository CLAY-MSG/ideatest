package cn.itcast.day05;


import java.util.ArrayList;
import java.util.Random;

//定义获取所有偶数元素集合的方法(ArrayList类型作为返回值)
public class Demo04ArrayList04 {
    public static void main(String[] args) {
//        System.out.println(ol());
        Random rd = new Random();
        ArrayList<Integer> arrayListA = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int a = rd.nextInt(1000);
            arrayListA.add(a);
        }
        System.out.println(arrayListA);
        System.out.println(getArrayList(arrayListA));
    }
    public static ArrayList<Integer> getArrayList(ArrayList<Integer> arrayList){
        ArrayList<Integer> oArrayList = new ArrayList<>();
        int a;
        for (int i = 0; i < arrayList.size(); i++) {
            a = arrayList.get(i);
            if ( a % 2 == 0 ) {
                oArrayList.add(a);
            }
        }
        return oArrayList;
    }

    /*public static ArrayList<Integer> ol(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int a = 0;
        for (int i = 0; i < 100; i++) {

            arrayList.add(a);
            a = a + 2;
        }
        return arrayList;
    }*/
}
