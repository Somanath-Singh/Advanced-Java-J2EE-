package pack3;

public class ThreadPriorities extends Thread {

	public void run()
	{
		System.out.println("child thread");
		System.out.println("child thread priority:"+Thread.currentThread().getPriority());
	}
	public static void main(String[] args) {
		System.out.println("main thread old priority:"+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main thread new priority:"+Thread.currentThread().getPriority());
		ThreadPriorities tp=new ThreadPriorities();
		//if i don't set the priority of child thread bydefault priority is 6
		tp.setPriority(3);
		tp.start();

	}

}
