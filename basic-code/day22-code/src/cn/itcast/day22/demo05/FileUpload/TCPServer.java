package cn.itcast.day22.demo05.FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端启动……");
        ServerSocket ss = new ServerSocket(8879);
        while (true){
            Socket s = ss.accept();
            new Thread(()->{
                try {
                    InputStream is = s.getInputStream();

                    FileOutputStream fos = new FileOutputStream("E:\\"+System.currentTimeMillis()+"server.txt");
                    OutputStream os = s.getOutputStream();

                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = is.read(bytes)) != -1){
                        fos.write(bytes,0,len);
                    }

                    os.write("完成".getBytes());

                    fos.close();
                    s.close();
                    System.out.println("加载完成");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();

        }
    }

}
