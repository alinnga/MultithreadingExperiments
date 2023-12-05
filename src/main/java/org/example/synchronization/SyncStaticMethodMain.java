package org.example.synchronization;

public class SyncStaticMethodMain {
    public static void main(String[] args) {
        // эти потоки захватывают один монитор, поэтому они выполняются по очереди
        Thread t1 = new Thread (SynchronizedSection::doSmthStatic);
        Thread t2 = new Thread (SynchronizedSection::doSmthStatic);
        t1.start();
        t2.start();
    }
}
