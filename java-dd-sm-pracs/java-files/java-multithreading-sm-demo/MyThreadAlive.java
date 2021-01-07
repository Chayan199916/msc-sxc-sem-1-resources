public class MyThreadAlive extends Thread
{
	public void run()
	{
		System.out.println("r1 ");
		try {
        		Thread.sleep(1000);
    		}
    	catch(InterruptedException ie) 
    	{ 
    		// do something
		System.out.println("\nExecution Interruped ....");
    	}
       	System.out.println("r2 ");
  	}
	public static void main(String[] args)
	{
		MyThreadAlive t1=new MyThreadAlive();
		MyThreadAlive t2=new MyThreadAlive();
		t1.start();
		t2.start();
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
	}
}