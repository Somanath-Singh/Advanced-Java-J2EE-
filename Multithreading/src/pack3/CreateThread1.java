package pack3;

//1.extends the thread class
public class CreateThread1 extends Thread {
	  //2.override the run method
	public void run()
	{
		System.out.println("thread task execute");
		System.out.println("1"+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
	//3.create the object of the class
		CreateThread1 ct=new CreateThread1();
		//4.start the thread
		ct.start();
		
		System.out.println("2"+ct.getName());
		System.out.println("3"+Thread.currentThread().getName());
	}

}
