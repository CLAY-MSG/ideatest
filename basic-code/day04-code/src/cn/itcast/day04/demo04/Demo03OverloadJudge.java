package cn.itcast.day04.demo04;

public class Demo03OverloadJudge {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        short c = 10;
        short d = 20;
        int f = 10;
        int g = 20;
        long i = 10L;
        long j = 20L;
        System.out.println(compare(a,b));
        System.out.println(compare(c,d));
        System.out.println(compare(f,g));
        System.out.println(compare(i,j));


    }
    public static boolean compare(byte a,byte b){
        System.out.println("byte");
        if(a == b){
            return true;
        }else {
            return false;
        }

    }
    public static boolean compare(short a,short b){
        System.out.println("short");
        if(a == b){
            return true;
        }else {
            return false;
        }
    }
    public static boolean compare(int a,int b){
        System.out.println("int");
        if(a == b){
            return true;
        }else {
            return false;
        }
    }
    public static boolean compare(long a,long b){
        System.out.println("long");
        if(a == b){
            return true;
        }else {
            return false;
        }
    }

}
