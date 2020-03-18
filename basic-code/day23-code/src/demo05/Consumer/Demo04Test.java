package demo05.Consumer;

import java.lang.reflect.Array;
import java.util.function.Consumer;

/*
    下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。”的格式将信息打印出来。要求将打印姓
    名的动作作为第一个Consumer 接口的Lambda实例，将打印性别的动作作为第二个Consumer 接口的Lambda实
    例，将两个Consumer 接口按照顺序“拼接”到一起
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
    }
 */
public class Demo04Test {
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        for (String str:array
             ) {
            print(str,(String s) -> {
               String[] ss = str.split(",");
                System.out.print(ss[0]+",");
            },(String f)->{
                String[] ss = str.split(",");
                System.out.println(ss[1]);
            });
        }
    }

    public static void print(String str, Consumer<String> con1,Consumer<String> con2){
        con1.andThen(con2).accept(str);

    }
}
