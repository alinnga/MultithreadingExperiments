package org.example.synchronization;

public class Reentrancy {

    public synchronized void mainMethod(){
        System.out.println(Thread.currentThread().getName()+": Start main method");
        for(int i = 0; i<5; i++){
            innerMethod();
        }
        System.out.println(Thread.currentThread().getName()+": End main method");
    }

    public synchronized void innerMethod(){
        System.out.println(Thread.currentThread().getName()+": Start inner method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+": End inner method");
    }
}
