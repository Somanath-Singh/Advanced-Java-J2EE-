package pack3;

public class Threadname {

	public static void main(String[] args) {
		System.out.println("Helo");
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("Somanath");
		System.out.println("New thread name:"+Thread.currentThread().getName());
		//System.out.println(10/0);
	}

}

