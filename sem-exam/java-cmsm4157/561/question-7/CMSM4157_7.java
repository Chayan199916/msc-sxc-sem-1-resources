
/**
 * Write a Java program to create three threads using Runnable interface. Execute the threads from the
main program by changing their default priorities. Implement the uses of sleep( ) and stop( ) also. 
 */

import java.lang.*;

class CMSM4157_7 {

    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        C obj3 = new C();

        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);
        Thread thread3 = new Thread(obj3);

        System.out.println("Displaying default priorities : ");
        // Default 5
        System.out.println("thread 1 priority : " + thread1.getPriority());
        // Default 5
        System.out.println("thread 3 priority : " + thread3.getPriority());

        thread1.setPriority(2);
        thread2.setPriority(5);
        thread3.setPriority(8);

        System.out.println("Displaying modified priorities : ");

        System.out.println("thread 1 thread priority : " + thread1.getPriority());
        System.out.println("thread 2 thread priority : " + thread2.getPriority());
        System.out.println("thread 3 thread priority : " + thread3.getPriority());

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());

        /**
         * Thread.stop() is deprecated we should use Thread.join() instead.
         */
        thread3.stop();
        System.out.println("thread 3 is stopped");
        thread2.stop();
        System.out.println("thread 2 is stopped");
        thread1.stop();
        System.out.println("thread 1 is stopped");

        System.out.println("Main thread finishes execution.");

    }
}

class A implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside run method of A");
        try {
            Thread.sleep(10); // sleep to implement delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside run method of B");
        try {
            Thread.sleep(10); // sleep to implement delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class C implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside run method of C");
        try {
            Thread.sleep(10); // sleep to implement delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}