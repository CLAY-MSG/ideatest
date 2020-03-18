package cn.itcast.day21.demo03.ReverseStream;

import java.io.*;

/*
    将GBK编码的文本文件，转换为UTF-8编码的文本文件。
    案例分析
    1. 指定GBK编码的转换流，读取文本文件。
    2. 使用UTF-8编码的转换流，写出文本文件。
*/
public class Demo05Test {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter ose = new OutputStreamWriter(new FileOutputStream("D:\\1Test\\gbk.txt"),"GBK");
        ose.write("你好傻逼");
        ose.close();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\1Test\\gbk.txt"),"GBK");
        OutputStreamWriter ose1 = new OutputStreamWriter(new FileOutputStream("D:\\1Test\\utf-8.txt"),"UTF-8");
        int len;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1){
            ose1.write(chars,0,len);
        }
        ose1.close();
        isr.close();
    }
}
