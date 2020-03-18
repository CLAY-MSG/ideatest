package cn.itcast.day16.demo04.MyException;

import javax.security.auth.login.LoginException;

//要求：我们模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册。
public class MyExceptionTest {

    private static String[] str = {"小米","小王","小张","小剑"};

    public static void main(String[] args) {

        try {
            register("小梁");
            System.out.println("成功");
        } catch (RegisterExceptionTest e) {
            e.printStackTrace();
        }
    }

    public static void register(String string) throws RegisterExceptionTest {

        for (String ss:str
             ) {
            if (string.equals(ss)){
                throw new RegisterExceptionTest("亲，该用户名"+string+"已经被注册。");
            }
        }
    }
}
