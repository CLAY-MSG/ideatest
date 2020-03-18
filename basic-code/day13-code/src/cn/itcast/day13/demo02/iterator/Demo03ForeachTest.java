package cn.itcast.day13.demo02.iterator;

public class Demo03ForeachTest {
    public static void main(String[] args) {
        int[] a = {
                1,2,3,4,5
        };
        for (int q:a
             ) {
            System.out.println(q);
        }
        String[] str = {
                "张三","王五","李四","赵柳","田七"
        };
        for (String strq:str
             ) {
            System.out.println(strq);
        }
    }
}
