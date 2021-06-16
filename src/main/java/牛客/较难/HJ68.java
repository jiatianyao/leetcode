package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 成绩排序
 * 注：0代表从高到低，1代表从低到高
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
 *
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 */
public class HJ68 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int m = Integer.parseInt(str1);
            int sort = Integer.parseInt(reader.readLine());
            Student[] st = new Student[m];
            for (int i = 0; i < m; i++) {
                String s = reader.readLine();
                st[i] = new Student(s);
            }
            Arrays.sort(st,sort ==1 ? Student.INCREASE :Student.DECREASE );
            for (Student student : st) {
                System.out.println(student.toString());
            }

        }
    }
}

class Student{
    private int grade;
    private String name;
    public static final Comparator<Student> INCREASE = new increase();
    public static final Comparator<Student> DECREASE = new decrease();
    public Student(String str) {
        String[] s = str.split(" ");
        this.name = s[0];
        this.grade = Integer.parseInt(s[1]);
    }
    public String toString() {
        return name + " " + grade;
    }
    private static class decrease implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return w.grade - v.grade;
        }
    }
    private static class increase implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.grade - w.grade;
        }
    }
}
