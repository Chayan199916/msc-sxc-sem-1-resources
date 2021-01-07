public class ThreadPriorityProperDemo extends Thread
{

	public static void main(String[] args) 
	{
    		ThreadPriorityProperDemo t=new ThreadPriorityProperDemo();
		//    t.setPriority(10);
    		System.out.println("Main Priority:"+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(2);
    		System.out.println("Main Priority:"+Thread.currentThread().getPriority());

//    		ThreadPriorityProperDemo t=new ThreadPriorityProperDemo();
    		System.out.println("Child Priority:"+t.getPriority());
    		System.out.println("-----------------------------------");
    		t.start();
    		for (int i = 0; i < 10; i++) {
        		System.out.println("Parent Thread:" + i);
    		}

	}
}
