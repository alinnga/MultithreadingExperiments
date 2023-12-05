package org.example.synchronization;

public class SyncInstanceMethodMain {
    public static void main(String[] args) {
//        SynchronizedSectionRunner ssr1 = new SynchronizedSectionRunner();
//        // эти потоки захватывают один монитор, поэтому они выполняются по очереди
//        Thread t1 = new Thread (ssr1::doSmth);
//        Thread t2 = new Thread (ssr1::doSmth);
//        t1.start();
//        t2.start();

        SynchronizedSection ssr1 = new SynchronizedSection();
        SynchronizedSection ssr2 = new SynchronizedSection();

        // Эти потоки захватывают разные мониторы, поэтому они одновременно заходят в критическую секцию,
        // но для разных объектов
        Thread t1 = new Thread (ssr1::doSmth);
        Thread t2 = new Thread (ssr2::doSmth);
        t1.start();
        t2.start();

    }
}
