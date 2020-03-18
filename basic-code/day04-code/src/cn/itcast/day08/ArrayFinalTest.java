package cn.itcast.day08;

import java.util.Arrays;
import java.util.Random;

public class ArrayFinalTest {
	public static void main(String[] args) {
		String[] names =  { "付航", "李超", "梁华男", "石思佳", "郭宸滔", "杨科", "方晓刚", "姬帅龙", "张庆光", "许妮旦", "高严", "魏双鑫", "曾仕玉", "李雪健",
				"陈长昊", "杨豪", "杨威龙", "王安石", "祝中州", "谭宏亮", "张玄巍", "张晓磊", "淡孔伋", "万祯", "米帅广", "孙金亮", "陈锦科", "谢俊杰", "亢普照",
				"李桓", "季鹏欣", "朱少华", "郑志鹏", "李梦琪", "李敏", "王子君" };
		int index;
		Random rd = new Random();
		ArrayFinalTest aft = new ArrayFinalTest();
		String[][] strs = new String[5][3];
		String[] oldArray = new String[5];
		for (int i = 0; i < 5; i++) {
			int a = rd.nextInt(36);
			oldArray[i] = names[a];
		}
		String[] newArray = aft.getNewArray(oldArray);
		for (int i = 0; i < newArray.length; i++) {
			strs[i][0] = newArray[i];
			strs[i][1] = i + "";
			strs[i][2] = 51651615 + i + "";
		}

		for (int i = 0; i < strs.length; i++) {
			System.out.println(Arrays.toString(strs[i]));
		}
	}

	public String[] getNewArray(String[] oldArray) {
		int count = 0;
		for (int i = 0; i < oldArray.length-1; i++) {
			for (int j = i+1; j < oldArray.length; j++) {
				if(oldArray[i].equals(oldArray[j]) ){
					count++;
					break;
				}
			}
		}
		String[] newArray = new String[oldArray.length-count];
		int index = 0;
		for (int i = 0; i < oldArray.length; i++) {
			String temp = oldArray[i];
			boolean flag = false;
			for (int j = 0; j < newArray.length; j++) {
				if(oldArray[i].equals(newArray[j])){
					flag = true;
				}
			}
			if(flag == false){
				newArray[index++]=temp;
			}
		}

		return newArray;
	}
}
