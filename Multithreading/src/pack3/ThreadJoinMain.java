package pack3;

//make main thread 1st execute child thread wait 

public class ThreadJoinMain  extends Thread  {
//create a instance of mainThread
	static Thread mainThread;
	public void run()
	{
		try {
			mainThread.join();
			for(int i=1;i<=8;i++)
			{
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
		//create reference of main thread to use join method for child thread
		 mainThread=Thread.currentThread();
		ThreadJoinMain tj=new ThreadJoinMain();
		tj.start();
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
