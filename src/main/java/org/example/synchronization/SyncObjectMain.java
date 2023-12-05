package org.example.synchronization;

public class SyncObjectMain {
    public static void main(String[] args) {
//        SynchronizedSectionRunner ssr1 = new SynchronizedSectionRunner();
//        SynchronizedSectionRunner ssr2 = ssr1;
//        // эти потоки захватывают один монитор, поэтому кретическую секцию они выполняют по очереди
//        Thread t1 = new Thread (ssr1::doSmthSyncSection);
//        Thread t2 = new Thread (ssr2::doSmthSyncSection);
//        t1.start();
//        t2.start();

//        SynchronizedSectionRunner ssr1 = new SynchronizedSectionRunner();
//        SynchronizedSectionRunner ssr2 = new SynchronizedSectionRunner();
//        // эти потоки захватывают два разных монитора,
//        // т.к. объекты ssr1 и ssr2 разные, то и объекты user внутри них тоже разные
//        Thread t1 = new Thread(ssr1::doSmthSyncSection);
//        Thread t2 = new Thread(ssr2::doSmthSyncSection);
//        t1.start();
//        t2.start();

        SynchronizedSection ssr1 = new SynchronizedSection();
        SynchronizedSection ssr2 = ssr1;
        // эти потоки захватывают один монитор, поэтому кретическую секцию они выполняют по очереди
        Thread t1 = new Thread(ssr1::doSmthSyncSectionNotSyncInside);
        Thread t2 = new Thread(ssr2::doSmthSyncSectionNotSyncInside);
        t1.start();
        t2.start();
    }
}
