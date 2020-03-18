package cn.itcast.day05;


import java.util.ArrayList;

//自定义4个学生对象,添加到集合,并遍历
public class Demo04ArrayList02 {
    public static void main(String[] args) {
        Student stu1 = new Student("小李","男",18);
        Student stu2 = new Student("小张","男",18);
        Student stu3 = new Student("小今","男",18);
        Student stu4 = new Student("小级","男",18);
        ArrayList<Student>  stu = new ArrayList<>();
        stu.add(stu1);
        stu.add(stu2);
        stu.add(stu3);
        stu.add(stu4);
        for (int i = 0; i < stu.size(); i++) {
            Student student = new Student();
            System.out.println(student.getName()+student.getSex()+student.getAge());
        }
    }
}

