class MyThreadPriority3 extends Thread 
{ 
	public void run() 
	{ 
		System.out.println("Thread Running..."); 
	} 

	public static void main(String[]args) 
	{ 
		MyThreadPriority3 p1 = new MyThreadPriority3();
		// Starting thread
		p1.start();
		// Setting priority
		p1.setPriority(2);
		// Getting priority
		int p = p1.getPriority();
	
		System.out.println("thread priority : " + p);  
		
	} 
}
