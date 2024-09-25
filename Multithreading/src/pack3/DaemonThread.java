package pack3;

public class DaemonThread extends Thread {
	public void run()
	{
		if(Thread.currentThread().isDaemon())
		{
		System.out.println("Daemon Thread");
		}
		else
		{
			System.out.println("Not Daemon Thread");
		}
	//	System.out.println(Thread.currentThread().isDaemon());
	}

	public static void main(String[] args) {
		//we cannot make main method as daemon thread
		//Thread.currentThread().setDaemon(true);
		System.out.println("main Thread");
		DaemonThread dt=new DaemonThread();
		dt.setDaemon(true);
		dt.start();

	}

}
