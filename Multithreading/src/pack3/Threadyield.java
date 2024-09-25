package pack3;

public class Threadyield extends Thread {
	public void run()
	{
		Thread.yield();
		for(int i=1;i<=8;i++)
		{
			System.out.println(i+" "+Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		Threadyield ty=new Threadyield();
		ty.start();
		//if you want to make main thread stop and give a chance to child thread
	//	Thread.yield();
		for(int i=1;i<=8;i++)
		{
			System.out.println(i+" "+Thread.currentThread().getName());
		}

	}

}
