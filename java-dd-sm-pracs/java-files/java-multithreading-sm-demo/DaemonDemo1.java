public class DaemonDemo1 extends Thread 
{ 
    public DaemonDemo1(String name1)
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
    }  
    public static void main(String[] args) 
    {  
        DaemonDemo1 D1 = new DaemonDemo1("D1"); 
        DaemonDemo1 D2 = new DaemonDemo1("D2"); 
        DaemonDemo1 D3 = new DaemonDemo1("D3"); 

        D1.setDaemon(true);      
        D1.start();  
        D2.start(); 
        D3.setDaemon(true);  
        D3.start();         
    }  
}