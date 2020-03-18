package cn.itcast.day18.demo09.LambdaTest.demo01;

/*
    给定一个厨子Cook 接口，内含唯一的抽象方法makeFood ，且无参数、无返回值。如下：
    public interface Cook {
        void makeFood();
    }
    在下面的代码中，请使用Lambda的标准格式调用invokeCook 方法，打印输出“吃饭啦！”字样：
    public class Demo05InvokeCook {
        public static void main(String[] args) {
        // TODO 请在此使用Lambda【标准格式】调用invokeCook方法
        }
        private static void invokeCook(Cook cook) {
            cook.makeFood();
        }
    }
    */
public class Demo01Test {
    public static void main(String[] args) {
        invokeCook(()->{
            System.out.println("吃饭啦");
        });
    }

    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
