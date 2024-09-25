package pack3;

public class ThreadnterruptedIsinterrupted implements Runnable {
	public void run()
	{
		System.out.println("A:"+Thread.interrupted());
		System.out.println("B:"+Thread.interrupted());
		try
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println(i);
				Thread.sleep(1000);
			}
			System.out.println("C:"+Thread.interrupted());
		}
		catch(Exception e)
		{
			System.out.println("Thread intruupted:"+e);
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ThreadnterruptedIsinterrupted tii=new ThreadnterruptedIsinterrupted();
		Thread th=new Thread(tii);
		th.start();
		th.interrupt();
		System.out.println("2.Child thread:"+th.isInterrupted());
		//System.out.println("2.Child thread:"+th.isInterrupted());
       
	}

}
/*
 1.Child thread:true //thread is interrupted so return true(isIntreuupted() method is called)
A:true  //thread is interrupted so return true after it changes  true to false (intreuupted() method is called)
B:false   //so next o/p is false (intreuupted() change true to false not false to true )  (intreuupted() method is called)
1
2
3
4
5
C:false  //so it returns false  (intreuupted() method is called)
*/
