package com.example.demo.student;

public interface TestInter {

    default String doSomething() {
        eatPopcorn();
        return cosInnego();
    }

    String cosInnego();

    static void eatPopcorn() {
        System.out.println("omomomo");
    }
}
