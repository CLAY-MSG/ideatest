package cn.itcast.day09;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value1 = sc.next();
        String value2 = sc.next();
        if(check(value1)&&check(value2)){
            System.out.println(compare(Integer.parseInt(value1),Integer.parseInt(value2)));;
        }else if(!check(value1)&&!check(value2)){
            System.out.println(compare(Double.parseDouble(value1),Double.parseDouble(value2)));;
        }
    }

    public static boolean compare(int a, int b){
        System.out.println("int");
        return a==b;
    }

    public static boolean compare(double a, double b){
        System.out.println("double");
        return a==b;
    }

    public static boolean check(String str){
        /*for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if(Character.isDigit(a)){
                return true;
            }
            return false;
        }*/
        boolean flag = false;
        Pattern patInt = Pattern.compile("[0-9]+");
        Pattern patDouble = Pattern.compile("[0-9]*//.[0-9]+");
        Matcher matInt = patInt.matcher(str);
        Matcher matDouble = patDouble.matcher(str);
        if(matInt.matches()){
            flag = true;
        }else if(matDouble.matches()){
            flag = false;
        }
        return flag;
    }
}
