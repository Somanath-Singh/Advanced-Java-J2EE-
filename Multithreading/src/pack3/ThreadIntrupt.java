package pack3;

public class ThreadIntrupt implements Runnable {
	public void run()
	{
		try {
			for(int i=1;i<=5;i++)
			{
				System.out.println(i);
				if(i==3)
				{
					//if we comment out sleep() method then interrupt() method does not work
					Thread.sleep(1000);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Thread intrupt by calling intrupt method.");
		}
	}

	public static void main(String[] args) {
		ThreadIntrupt ti=new ThreadIntrupt();
		Thread th=new Thread(ti);
		th.start();
		th.interrupt();

	}

}
