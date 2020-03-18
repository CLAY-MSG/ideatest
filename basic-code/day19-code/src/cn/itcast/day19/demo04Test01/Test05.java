package cn.itcast.day19.demo04Test01;

import java.io.File;
import java.io.FileFilter;

/*
    java.io.FileFilter 是一个接口，是File的过滤器。 该接口的对象可以传递给File类的listFiles(FileFilter)
    作为参数， 接口中只有一个方法。
        boolean accept(File pathname) ：测试pathname是否应该包含在当前File目录中，符合则返回true。
    分析：
        1. 接口作为参数，需要传递子类对象，重写其中方法。我们选择匿名内部类方式，比较简单。
        2. accept 方法，参数为File，表示当前File下所有的子文件和子目录。保留住则返回true，过滤掉则返回
        false。保留规则：
        1. 要么是.java文件。
        2. 要么是目录，用于继续遍历。
        3. 通过过滤器的作用， listFiles(FileFilter) 返回的数组元素中，子文件对象都是符合条件的，可以直接打
        印。
*/
public class Test05 {
    public static void main(String[] args) {
        File file = new File("D:\\IDEA\\IdeaProjects\\basic-code");
        fileFilter(file);
    }

    public static void fileFilter(File file){
        /*File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().endsWith(".java")||pathname.isDirectory()){
                    return true;
                }
                return false;
            }

        });*/
        File[] files = file.listFiles((File pathname)->{
            return pathname.getName().endsWith(".java")||pathname.isDirectory();
        });
        for (File file1:files
        ) {
            if(file1.isFile()){
                System.out.println(file1.getAbsoluteFile());
            }else if(file1.isDirectory()){
                fileFilter(file1);
            }
        }
    }

}
