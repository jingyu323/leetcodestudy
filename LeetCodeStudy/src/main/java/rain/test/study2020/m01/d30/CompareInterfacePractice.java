package rain.test.study2020.m01.d30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareInterfacePractice implements Comparable<CompareInterfacePractice> {
    private String name;
    private int age;

    public CompareInterfacePractice(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        List<CompareInterfacePractice> personList = new ArrayList<CompareInterfacePractice>();
        personList.add(new CompareInterfacePractice("ace", 22));
        personList.add(new CompareInterfacePractice("xb", 21));
        personList.add(new CompareInterfacePractice("glm", 36));
        personList.add(new CompareInterfacePractice("sxy", 20));


        System.out.println("按照年龄");
        Collections.sort(personList);
        for (CompareInterfacePractice p : personList)
            System.out.println(p);
        System.out.println();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 第一次发现 this.可以直接获取  当前的 private的filed 的值，而 对象的话只能通过getXX 方法获取
    @Override
    public int compareTo(CompareInterfacePractice o) {
        return this.age - o.getAge();
    }

    @Override
    public String toString() {

        return "Person [name=" + name + ", age=" + age + "]";

    }
}
