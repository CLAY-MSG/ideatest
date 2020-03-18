package demo04.Supplier;

import java.util.function.Supplier;

//使用Supplier 接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。提示：接口的泛型请使用java.lang.Integer 类。
public class Demo03Test {
    public static void main(String[] args) {
        int[] array = new int[]{
                7,8,98,25,6,4,1,56,41,5,2,68,
        };
        int result = getMaxNumber(()->{
            int max = array[0];
            for (int i = 0; i < array.length; i++) {
                if(array[i] > max){
                    max = array[i];
                }
            }
            return max;
        });
        System.out.println(result);
    }
    public static int getMaxNumber(Supplier<Integer> sup){
        return sup.get();
    }
}
