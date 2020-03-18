package demo06.Predicate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

/*
    数组当中有多条“姓名+性别”的信息如下，请通过Predicate 接口的拼装将符合要求的字符串筛选到集合
    ArrayList 中，需要同时满足两个条件：
    1. 必须为女生；
    2. 姓名为4个字。
    public class DemoPredicate {
        public static void main(String[] args) {
            String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        }
    }
*/
public class Demo06Test {
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        ArrayList<String> al = test(array,(String s)->{
            String[] ss = s.split(",");
            return ss[0].length()== 4;

        },(String f)->{
            String[] ss = f.split(",");
            return ss[1] .equals("女") ;
        });
        System.out.println(al);
    }

    public static ArrayList<String> test(String[] array, Predicate<String> s,Predicate<String> f) {
        ArrayList<String> al = new ArrayList<>();
        for (String str:array
             ) {
            if(s.and(f).test(str)){
                al.add(str);
            };
        }
        return al;

    }
}
