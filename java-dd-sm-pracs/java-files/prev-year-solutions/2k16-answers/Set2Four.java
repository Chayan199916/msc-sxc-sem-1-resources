import java.lang.*;

class Set2Four {

    public static void main(String[] args) {
        Thread t1 = new A();
        Thread t2 = new B();
        Thread t3 = new C();

        // Default 5
        System.out.println("t1 thread priority : " + t1.getPriority());

        // Default 5

        System.out.println("t3 thread priority : " + t3.getPriority());

        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);

        // t3.setPriority(21); will throw
        // IllegalArgumentException

        // 2
        System.out.println("t1 thread priority : " + t1.getPriority());

        // 5
        System.out.println("t2 thread priority : " + t2.getPriority());

        // 8
        System.out.println("t3 thread priority : " + t3.getPriority());

        // Main thread

        // Displays the name of
        // currently executing Thread
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());

        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());

        // Main thread
        // Main thread priority is set to 10
        Thread.currentThread().setPriority(10);
        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class A extends Thread {
    @Override
    public void run() {
        System.out.println("Inside run method of A");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B extends Thread {
    @Override
    public void run() {
        System.out.println("Inside run method of B");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class C extends Thread {
    @Override
    public void run() {
        System.out.println("Inside run method of C");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}