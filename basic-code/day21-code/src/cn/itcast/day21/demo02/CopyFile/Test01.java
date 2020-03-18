package cn.itcast.day21.demo02.CopyFile;

//查询API，缓冲流读写方法与基本的流是一致的，我们通过复制大文件（375MB），测试它的效率。

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        try (
             FileInputStream fis = new FileInputStream("D:\\1Test\\jdk-9.0.4_windows-x64_bin.exe");
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream("D:\\1Test\\jdk-9.0.4_windows-x64_bin-Copy.exe");
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ){

            byte[] bytes = new byte[16*1024];
//            byte[] bytes = bis.readAllBytes();
            int len ;
            while ((len = bis.read(bytes))!= -1){
                bos.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        long f = System.currentTimeMillis();

        System.out.println(f-s+"毫秒");

    }
}
