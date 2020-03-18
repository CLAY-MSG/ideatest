package cn.itcast.day08;


import java.util.Scanner;

//键盘录入一个字符串，统计字符串中大小写字母及数字字符个数
public class Demo03String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = sc.nextLine();
        char[] a = new char[]{};
        a = s.toCharArray();
        int big = 0;
        int small = 0;
        int number = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 'A' && a[i] <= 'Z'){
                big = big + 1;
            }else if(a[i] >= 'a' && a[i] <= 'z'){
                small = small + 1;
            }else if(a[i] >= '0' && a[i] <= '9'){
                number = number + 1;
            }else{
                System.out.println("该字符"+a[i]+"无效");
            }
        }
        System.out.println(big);
        System.out.println(small);
        System.out.println(number);
    }

}
