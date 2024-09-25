package pack3;

public class ThreadSleep extends Thread {
	public void run()
	{
		//one way
	/*	try {
			for(int i=1;i<=8;i++)
			{
				Thread.sleep(1000);
				System.out.println(i);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		//2nd way
		for(int i=1;i<=8;i++)
		{
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(i);
			System.out.println(i+" "+Thread.currentThread().getName());
		}
		
	}

	public static void main(String[] args) {
		ThreadSleep ts=new ThreadSleep();
		ts.start();
		ThreadSleep ts1=new ThreadSleep();
		ts1.start();

	}

}
