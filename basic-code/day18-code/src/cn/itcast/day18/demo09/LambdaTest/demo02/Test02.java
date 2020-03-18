package cn.itcast.day18.demo09.LambdaTest.demo02;

//给定一个计算器Calculator 接口，内含抽象方法calc 可以将两个int数字相加得到和值：

public class Test02 {
    public static void main(String[] args) {
        /*Calculator a = new Calculator() {

            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        };
        int b = a.calc(120,130);
        int c = new Calculator(){

            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        }.calc(150,180);
        System.out.println(b);
        System.out.println(c);*/
        invokeCalc(120,130,(int a,int b)->{
            return a+b;
        });
    }

    public static void invokeCalc(int a, int b, Calculator calculator){
        int result = calculator.calc(a,b);
        System.out.println(result);
    }
}
