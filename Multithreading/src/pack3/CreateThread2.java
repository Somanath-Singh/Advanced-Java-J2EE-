package pack3;

//1.implements the runnable interface
public class CreateThread2 implements Runnable{

	//2.override the run method
	public void run() {
		System.out.println("thread task execute");
	}

	public static void main(String[] args) {
		//3.create the object of class
		CreateThread2 ct1=new CreateThread2();
		//4.create the object of threade class and pas the parameter in the constructor
		Thread th=new Thread(ct1);
		//5.invoke the start method
		th.start();
	}
}
