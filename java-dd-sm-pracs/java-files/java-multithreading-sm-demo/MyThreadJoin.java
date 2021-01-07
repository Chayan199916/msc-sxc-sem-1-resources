public class MyThreadJoin extends Thread
{ 
	    MyThreadJoin(String str){
	    	super(str);
	    }
	
        public void run()
        {
                System.out.println(Thread.currentThread().getName());
        }
        public static void main(String[] args)
        {
                MyThreadJoin t1=new MyThreadJoin("first thread");
                MyThreadJoin t2=new MyThreadJoin("second thread");
                t1.start();

                try{
                        t1.join(1500);      //Waiting for t1 to finish
                }catch(InterruptedException ie){
                	System.out.println(ie);
                }

                t2.start();
                
                try{
                    t2.join(1500);      //Waiting for t2 to finish
                }catch(InterruptedException ie){
                	System.out.println(ie);
                }
        }
}