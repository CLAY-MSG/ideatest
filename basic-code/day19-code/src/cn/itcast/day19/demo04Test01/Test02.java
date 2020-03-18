package cn.itcast.day19.demo04Test01;

//阶乘：所有小于及等于该数的正整数的积。
public class Test02 {
    public static void main(String[] args) {
        int result = cheng(10);
        System.out.println(result);
    }
    public static int cheng(int i){
        if (i <= 2){
            return i;
        }
        return i*cheng(i-1);
    }
}
