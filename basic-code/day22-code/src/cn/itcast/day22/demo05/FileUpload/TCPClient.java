package cn.itcast.day22.demo05.FileUpload;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

//文件上传
/*
    1. 【客户端】输入流，从硬盘读取文件数据到程序中。
    2. 【客户端】输出流，写出文件数据到服务端。
    3. 【服务端】输入流，读取文件数据到服务端程序。
    4. 【服务端】输出流，写出文件数据到服务器硬盘中。
*/
public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动……");
        Socket socket = new Socket("127.0.0.1",8879);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("D:\\1Test\\client.txt");
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len ;
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();

        while ((len = is.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }



        fis.close();
        socket.close();
        System.out.println("加载完成");



    }
}
