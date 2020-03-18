package cn.itcast.day08;


import java.util.Arrays;

//请使用Arrays 相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印。
public class Demo04Arrays {
    public static void main(String[] args) {
        String str = "HGJHguyFvhDUYubFsasd";

        char[] ch = str.toCharArray();

        Arrays.sort(ch);

        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }
}
