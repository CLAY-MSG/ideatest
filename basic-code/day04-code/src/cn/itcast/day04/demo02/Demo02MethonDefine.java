package cn.itcast.day04.demo02;
/*修饰符：现阶段的固定写法，public static
返回值类型：也就是方法最终产生的数据结果是什么类型
方法名称：方法的名字，规则和变量一样，小驼峰
参数类型：进入方法的数据是什么类型
参数名称：进入方法的数据对应的变量名称
PS：参数如果有多个，使用逗号进行分隔
方法体：方法需要做的事情，若干行代码
return：两个作用，第一停止当前方法，第二将后面的返回值还给调用处
返回值：也就是方法执行后最终产生的数据结果

注意：return后面的“返回值”，必须和方法名称前面的“返回值类型”，保持对应。

定义一个两个int数字相加的方法。三要素：
返回值类型：int
方法名称：sum
参数列表：int a, int b

方法的三种调用格式。
1. 单独调用：方法名称(参数);
2. 打印调用：System.out.println(方法名称(参数));
3. 赋值调用：数据类型 变量名称 = 方法名称(参数);

注意：此前学习的方法，返回值类型固定写为void，这种方法只能够单独调用，不能进行打印调用或者赋值调用。*/
public class Demo02MethonDefine {
    public static void main(String[] args) {
        sum(5,10);
        System.out.println("单独调用");
        System.out.println(sum(5,10)+"打印调用");
        int a = sum(5,10);
        System.out.println(a+"赋值调用");


        System.out.println(compare(3,2));
        System.out.println(compare(3,3));

        System.out.println(sum());

        print(10);
    }
    public static int sum(int a,int b){
        int result = a + b;
        return result;
    }
    public static boolean compare(int c,int d){
        boolean result;
        if (c == d) {
            result = true;
        }else {
            result = false;
        }
        return result;
    }
    public static int sum(){
        int sum = 0;
        for (int i = 1; i <=100 ; i++) {
            sum = sum + i;
        }
        return sum;
    }
    public static void print(int e){
        int i = 0;
        while (i <= e) {
            System.out.println("Hello,World!");
            i++;
        }
    }
}
