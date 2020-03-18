package cn.itcast.day19.demo04Test01;

//分析：多级目录的打印，就是当目录的嵌套。遍历之前，无从知道到底有多少级目录，所以我们还是要使用递归实现。

import java.io.File;

public class Test03 {
    public static void main(String[] args) {
        File file = new File("D:\\IDEA\\IdeaProjects\\basic-code");
        println(file);
    }

    public static void println(File file){
        File[] files = file.listFiles();

        if (files != null) {
            for (File file1:files
            ) {
                if (file1.isFile()){
                    System.out.println("文件名为:"+file1.getAbsolutePath());
                }else {
                    System.out.println("目录名为"+file1.getAbsoluteFile());
                    println(file1);
                }

            }
        }

    }
}
