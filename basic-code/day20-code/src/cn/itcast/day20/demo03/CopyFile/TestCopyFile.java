package cn.itcast.day20.demo03.CopyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopyFile {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\360\\host-big.jpg");
        File file1 = new File("D:\\360\\host-big-copy.jpg");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file1);
        long s = System.currentTimeMillis();
        byte[] by = fis.readAllBytes();
        fos.write(by);
        /*byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b))!=-1) {
            fos.write(b, 0 , len);
        }*/
        long f = System.currentTimeMillis();
        System.out.println(f-s);
        fos.close();
        fis.close();
    }
}
