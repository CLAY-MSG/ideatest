package cn.itcast.day08;

public class Demo01String {
    public static void main(String[] args) {
        String str = new String();
        System.out.println(str);
        char[] ch = new char[]{'S','D','F'};
        String str1 = new String(ch);
        System.out.println(str1);
        byte[] by = new byte[] {97,101,99};
        String str2 = new String(by);
        System.out.println(str2);
    }
}
