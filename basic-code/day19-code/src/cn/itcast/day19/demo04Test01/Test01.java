package cn.itcast.day19.demo04Test01;

//计算1 ~ n的和
//分析：num的累和 = num + (num-1)的累和，所以可以把累和的操作定义成一个方法，递归调用。

public class Test01 {
    public static void main(String[] args) {
        int sum = sum(100);
        System.out.println(sum);
    }

    public static int sum(int i){
        if(i == 1){
            return 1;
        }
        return i + sum(i-1);


    }
}
