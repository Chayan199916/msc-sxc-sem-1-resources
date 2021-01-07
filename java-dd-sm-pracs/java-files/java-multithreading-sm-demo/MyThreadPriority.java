class MyThreadPriority extends Thread 
{ 
	public void run() 
	{ 
		System.out.println("Thread Running..."); 
	} 

	public static void main(String[]args) 
	{ 
		MyThreadPriority p1 = new MyThreadPriority(); 
		MyThreadPriority p2 = new MyThreadPriority(); 
		MyThreadPriority p3 = new MyThreadPriority(); 
		p1.start();
		int pp2=p2.getPriority();
		System.out.println("P1 thread priority : " + p1.getPriority()); 
		System.out.println("P2 thread priority : " + pp2); 
		System.out.println("P3 thread priority : " + (p3.getPriority())-1); 
		
	} 
}