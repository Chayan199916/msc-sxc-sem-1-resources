public class DaemonDemo2 extends Thread 
{ 
    public DaemonDemo2(String name1)
    { 
        super(name1); 
    } 
    public void run() 
    {  
        if(Thread.currentThread().isDaemon()) 
        {  
            System.out.println(getName() + " is Daemon thread");
        
        }  
        else
        {  
            System.out.println(getName() + " is User thread");  
        }
        System.out.println(getName()+" priority "+Thread.currentThread().getPriority());
    }  
    public static void main(String[] args) 
    {  
        DaemonDemo2 D1 = new DaemonDemo2("D1"); 
        DaemonDemo2 D2 = new DaemonDemo2("D2"); 
        DaemonDemo2 D3 = new DaemonDemo2("D3"); 

        D1.setDaemon(true);   
        D1.start();  
        D2.start(); 
        D3.setDaemon(true);  
        D3.start();         
    }  
}
    