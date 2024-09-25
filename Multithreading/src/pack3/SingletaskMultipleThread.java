package pack3;

//performing single task from multiple threade
public class SingletaskMultipleThread  extends Thread{

	public void run() {
		System.out.println("thread task execute");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SingletaskMultipleThread smt=new SingletaskMultipleThread();
		 smt.start();
		 SingletaskMultipleThread smt1=new SingletaskMultipleThread();
		 smt1.start();

	}

}
