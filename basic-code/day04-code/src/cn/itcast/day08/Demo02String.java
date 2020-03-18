package cn.itcast.day08;

//定义一个方法，把数组{1,2,3}按照指定个格式拼接成一个字符串。格式参照如下：[word1#word2#word3]。

public class Demo02String {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        String s = print(a);
        System.out.println(s);
    }
    public static String print( int[] r){
        String s = new String("[");
        for (int i = 0; i < r.length; i++) {
            if (i < r.length - 1) {
                s = s.concat(r[i]+"#");
            }else {
                s = s.concat(r[i]+"]");
            }
        }
        return s;
    }
}
