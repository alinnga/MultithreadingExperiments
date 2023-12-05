package org.example.synchronization;

public class SynchronizedSection {
    int value = 5;
    final User user = new User(1, "Kate");

    public synchronized int doSmth() {
        user.setName("Oleg");
        System.out.println(Thread.currentThread().getName() + ": Username has changed to " + user.getName());
        value = 10;
        System.out.println(Thread.currentThread().getName() + ": Value has changed to " + value);
        return 9;
    }

    public static synchronized int doSmthStatic() {
        System.out.println(Thread.currentThread().getName() + ": Start sync method");
        System.out.println(Thread.currentThread().getName() + ": End sync method");
        return 9;
    }

    public int doSmthSyncSection() {
        System.out.println(Thread.currentThread().getName() + ": accessed the method before synchronized block");
        synchronized (user) {
            user.setName("Oleg");
            System.out.println(Thread.currentThread().getName() + ": Username has changed to " + user.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            innerSyncMethod();
            System.out.println(Thread.currentThread().getName() + ": end of the method");
            return 9;
        }

    }

    public void innerSyncMethod() {
        System.out.println(Thread.currentThread().getName() + ": accessed the inner method before synchronized block");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": Inner method");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": end of the inner method");
        }
    }

    public int doSmthSyncSectionNotSyncInside() {
        System.out.println(Thread.currentThread().getName() + ": accessed the method before synchronized block");
        synchronized (user) {
            user.setName("Oleg");
            System.out.println(Thread.currentThread().getName() + ": Username has changed to " + user.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            innerNotSyncMethod();
            System.out.println(Thread.currentThread().getName() + ": end of the method");
            return 9;
        }

    }

    public void innerNotSyncMethod() {
        System.out.println(Thread.currentThread().getName() + ": accessed the inner method before synchronized block");
        System.out.println(Thread.currentThread().getName() + ": Inner method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": end of the inner method");
    }
}
