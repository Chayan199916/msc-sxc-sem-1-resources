// Java program to illustrate yield() method 
// in Java 
import java.lang.*; 

// MyThread extending Thread 
class MyThreadYield extends Thread 
{ 
	public void run() 
	{ 
		for (int i=0; i<5 ; i++) 
			System.out.println(Thread.currentThread().getName() 
								+ " in control"); 
	} 
} 

// Driver Class 
public class yieldDemo 
{ 
	public static void main(String[]args) 
	{ 
		MyThreadYield t = new MyThreadYield(); 
		t.start(); 

		for (int i=0; i<5; i++) 
		{ 
			// Control passes to child thread 
			Thread.yield(); 

			// After execution of child Thread 
			// main thread takes over 
			System.out.println(Thread.currentThread().getName() 
								+ " in control"); 
		} 
	} 
} 
