package demo07.Function;

import java.util.function.Function;

/*
    请使用Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
    String str = "赵丽颖,20";
    1. 将字符串截取数字年龄部分，得到字符串；
    2. 将上一步的字符串转换成为int类型的数字；
    3. 将上一步的int数字累加100，得到结果int数字。
*/
public class Demo04Test {
    public static void main(String[] args) {
        String str = "赵丽颖,20";
        int a = test(str,(String s)->{
            return str.split(",")[1];
        },(String s)->{
            return Integer.parseInt(s);
        },(Integer h)->{
            return h + 100;
        });
        System.out.println(a);
    }

    public static int test(String str, Function<String,String> fun1, Function<String,Integer> fun2, Function<Integer,Integer> fun3){
        return fun1.andThen(fun2).andThen(fun3).apply(str);
    }
}
