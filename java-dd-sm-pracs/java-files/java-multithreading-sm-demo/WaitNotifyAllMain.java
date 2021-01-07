// Java program to illustrate the 
// behavior of notifyAll() method 
class WaitNotifyAll1 extends Thread { 
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

class WaitNotifyAll2 extends Thread { 
	WaitNotifyAll1 obj1; 
	WaitNotifyAll2(WaitNotifyAll1 obj1) 
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

class WaitNotifyAll3 extends Thread { 
	WaitNotifyAll1 obj1; 
	WaitNotifyAll3(WaitNotifyAll1 obj1) 
	{ 
		this.obj1 = obj1; 
	} 
	public void run() 
	{ 
		synchronized(this.obj1) 
		{ 
			System.out.println(Thread.currentThread().getName() + "...starts"); 
			this.obj1.notifyAll(); 
			System.out.println(Thread.currentThread().getName() + "...notified"); 
		} 
	} 
} 

class WaitNotifyAllMain { 
public static void main(String[] args) throws InterruptedException 
	{ 

		WaitNotifyAll1 obj1 = new WaitNotifyAll1(); 
		WaitNotifyAll2 obj2 = new WaitNotifyAll2(obj1); 
		WaitNotifyAll3 obj3 = new WaitNotifyAll3(obj1); 
		Thread t1 = new Thread(obj1, "Thread-1"); 
		Thread t2 = new Thread(obj2, "Thread-2"); 
		Thread t3 = new Thread(obj3, "Thread-3"); 
		t1.start(); 
		t2.start(); 
		Thread.sleep(1000); 
		t3.start(); 
	} 
} 
