package com.example.wangweijun.text_process2;

public class Person {
    private String name;
    private int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    //重写equals方法，用于判断连个Person对象是否相同
    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        System.out.println("equals 方法被调用了,证明contains方法底层调用的是equals");
        return this.name.equals(p.name) && this.age == p.age;
    }
}
