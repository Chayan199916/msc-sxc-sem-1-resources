// Java program to illustrate the 
// behaviour of notify() method 
class WaitNotify1 extends Thread { 
public void run() 
	{ 
		synchronized(this) 
		{ 
			System.out.println 
			(Thread.currentThread().getName() + "...starts"); 
			try { 
				this.wait(); 
			} 
			catch (InterruptedException e) { 
				e.printStackTrace(); 
			} 
			System.out.println 
			(Thread.currentThread().getName() + "...notified"); 
		} 
	} 
} 

class WaitNotify2 extends Thread { 
	WaitNotify1 obj1; 
	WaitNotify2(WaitNotify1 obj1) 
	{ 
		this.obj1 = obj1; 
	} 
public void run() 
	{ 
		synchronized(this.obj1) 
		{ 
			System.out.println 
			(Thread.currentThread().getName() + "...starts"); 

			try { 
				this.obj1.wait(); 
			} 
			catch (InterruptedException e) { 
				e.printStackTrace(); 
			} 
			System.out.println 
			(Thread.currentThread().getName() + "...notified"); 
		} 
	} 
} 

class WaitNotify3 extends Thread { 
	WaitNotify1 obj1; 
	WaitNotify3(WaitNotify1 obj1) 
	{ 
		this.obj1 = obj1; 
	} 
public void run() 
	{ 
		synchronized(this.obj1) 
		{ 
			System.out.println 
			(Thread.currentThread().getName() + "...starts"); 
			this.obj1.notify(); 
			System.out.println 
			(Thread.currentThread().getName() + "...notified"); 
		} 
	} 
} 

class WaitNotifyMain { 
public static void main(String[] args) throws InterruptedException 
	{ 

		WaitNotify1 obj1 = new WaitNotify1(); 
		WaitNotify2 obj2 = new WaitNotify2(obj1); 
		WaitNotify3 obj3 = new WaitNotify3(obj1); 
		Thread t1 = new Thread(obj1, "Thread-1"); 
		Thread t2 = new Thread(obj2, "Thread-2"); 
		Thread t3 = new Thread(obj3, "Thread-3"); 
		t1.start(); 
		t2.start(); 
		Thread.sleep(100); 
		t3.start(); 
	} 
} 
