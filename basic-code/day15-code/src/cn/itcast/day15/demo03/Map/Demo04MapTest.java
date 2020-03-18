package cn.itcast.day15.demo03.Map;

import java.util.*;

//计算一个字符串中每个字符出现次数。
/*分析：
    1. 获取一个字符串对象
    2. 创建一个Map集合，键代表字符，值代表次数。
    3. 遍历字符串得到每个字符。
    4. 判断Map中是否有该键。
    5. 如果没有，第一次出现，存储次数为1；如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
    6. 打印最终结果*/
public class Demo04MapTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str =scanner.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char a =ch[i];
            if (map.containsKey(a)){
                Integer b = map.get(a);
                b++;
                map.put(a,b);
            }else {
                map.put(a,1);
            }
        }
        Set<Character> set = map.keySet();
        for (char zh:set) {
            Integer zk = map.get(zh);
            System.out.println(zh+"="+zk);
        }



    }
}
