public class MyThreadJoin2 extends Thread
{ 
	    MyThreadJoin2(String str){
	    	super(str);
	    }
	
        public void run()
        {
                System.out.println(Thread.currentThread().getName());
        }
        public static void main(String[] args)
        {
                MyThreadJoin2 t1=new MyThreadJoin2("first thread");
                MyThreadJoin2 t2=new MyThreadJoin2("second thread");
                t1.start();

                try{
                        t1.join(2000);      //Waiting for t1 to finish
                }catch(InterruptedException ie){
                	System.out.println(ie);
                }

                t2.start();
                
                try{
                    t2.join(2000);      //Waiting for t2 to finish
                }catch(InterruptedException ie){
                	System.out.println(ie);
                }
        }
}