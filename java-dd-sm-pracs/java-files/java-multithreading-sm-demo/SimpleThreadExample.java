class SimpleThread extends Thread {
    public SimpleThread(String str) {
        super(str);
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        System.out.println("DONE! " + getName());
    }
}

class SimpleThreadExample
{
	public static void main(String argv[])
	{
		SimpleThread t1=new SimpleThread("ThreadOne");
		SimpleThread t2=new SimpleThread("ThreadTwo");
		t1.start();
		t2.start();
	}
}