package cn.itcast.day20.demo07.Prop;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.setProperty("filename","a.txt");
        prop.setProperty("length","254624");
        prop.setProperty("location","D:\\360\\a.txt");
        prop.stringPropertyNames();
        FileOutputStream fos = new FileOutputStream(new File("D:\\360\\a.txt"));
        prop.store(fos,"aks");
        prop.load(new FileInputStream("D:\\360\\a.txt"));
        Set<String> hs = prop.stringPropertyNames();
        for (String str:hs
             ) {
            System.out.println(str + "=" +prop.getProperty(str));
        }

    }
}
