package org.example.synchronization;

public class ReentrancyMain {
    public static void main(String[] args) {
        Reentrancy reentrancy = new Reentrancy();
        Thread t1 = new Thread(reentrancy::mainMethod);
        Thread t2 = new Thread(reentrancy::innerMethod);
        t1.start();
        t2.start();

//        ReentrancyExample reentrancyExample1 = new ReentrancyExample();
//        ReentrancyExample reentrancyExample2 = new ReentrancyExample();
//        Thread t1 = new Thread(reentrancyExample1::mainMethod);
//        Thread t2 = new Thread(reentrancyExample2::innerMethod);
//        t1.start();
//        t2.start();
    }
}
