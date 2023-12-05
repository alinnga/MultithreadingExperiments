package org.example.synchronization;

public class ThreadNotInterruptMain {
    public static void main(String[] args) {
        SynchronizedSection synchronizedSection = new SynchronizedSection();
        Thread t1 = new Thread(synchronizedSection::doSmthSyncSection);
        Thread t2 = new Thread(synchronizedSection::doSmthSyncSection);
        t1.start();
        t2.start();

        // этот поток прерывается только после захвата монитора,
        // хотя статус был поставлен сразу же, еще во время ожидания, пока поток 1 освободит монитор
        t2.interrupt();
    }
}
