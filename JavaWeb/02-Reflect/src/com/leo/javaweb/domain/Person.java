package com.leo.javaweb.domain;

/**
 * Created by Leo on 2019/12/23.
 * Description :
 */
public class Person {

    private String name;
    private int age;
    public String email;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void run() {
        System.out.println(this.name + " run method invoke");
    }

    public void eat() {
        System.out.println("eat ... ");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
