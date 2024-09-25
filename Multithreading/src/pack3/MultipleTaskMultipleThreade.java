package pack3;

//performing multipul task from multiple threade

//thread1
class Mythread1 extends Thread
{
	public void run() {
		System.out.println("thread task execute 1");
	}
}
//thread2
class Mythread2  extends Thread
{
	public void run() {
		System.out.println("thread task execute 2");
	}
}
public class MultipleTaskMultipleThreade {

	public static void main(String[] args) {
		Mythread1 m=new Mythread1();
		m.start();
		Mythread2 m1=new Mythread2();
		m1.start();
	}

}
