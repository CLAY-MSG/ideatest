package cn.itcast.day19.demo04Test01;

import java.io.File;

/*
    搜索D:\aaa 目录中的.java 文件。
    分析：
    1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
    2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。
*/
public class Test04 {
    public static void main(String[] args) {
        File file = new File("D:\\IDEA\\IdeaProjects\\basic-code");
        getFile(file);
    }

    public static void getFile(File file){
        File[] files = file.listFiles();

        for (File file1:files
             ) {
            if (file1.isFile()){
                if (file1.getName().endsWith(".java")){
                    System.out.println(file1.getAbsoluteFile());
                }
            } else {
                getFile(file1);
            }
        }
    }


}
