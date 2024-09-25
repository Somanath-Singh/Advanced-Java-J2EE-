package pack3;
//make main thread wait execute child thread execute b1st
public class ThreadJoin extends Thread {
	public void run()
	{
		try {
			for(int i=1;i<=8;i++)
			{
				//Thread.currentThread().join();
				System.out.println("child thread"+i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)throws InterruptedException
	{
		ThreadJoin tj=new ThreadJoin();
		tj.start();
		tj.join();
		//Thread.currentThread().join();
		try {
			for(int i=1;i<=8;i++)
			{
				System.out.println(i+" "+"main thread");
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
