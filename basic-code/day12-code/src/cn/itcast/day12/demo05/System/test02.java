package cn.itcast.day12.demo05.System;

//将src数组中前3个元素，复制到dest数组的前3个位置上复制元素前：src数组元素[1,2,3,4,5]，
// dest数组元素[6,7,8,9,10]复制元素后：src数组元素[1,2,3,4,5]，dest数组元素[1,2,3,9,10]

import java.lang.reflect.Array;
import java.util.Arrays;

public class test02 {
    public static void main(String[] args) {
        int[] a = new int[]{
                1,2,3,4,5,
        };
        int[] b = new int[]{
                6,7,8,9,10
        };
        arraycopyTest(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }
    private static void arraycopyTest(int[] c,int[] d){
        System.arraycopy(c,0,d,0,3);
    }
}
