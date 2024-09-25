package pack3;

class Medical extends Thread
{
	public void run()
	{
		try {
			System.out.println("Medical start");
			Thread.sleep(3000);
			System.out.println("Medical End");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
class TestDrive extends Thread
{
	public void run()
	{
		try {
			System.out.println("testdrive start ");
			Thread.sleep(5000);
			System.out.println("testdrive End");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
class OffiserSign extends Thread
{
	public void run()
	{
		try {
			System.out.println("officersSign start ");
			Thread.sleep(5000);
			System.out.println("officersSign End");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
public class ThreadJoinExImp {

	public static void main(String[] args) throws InterruptedException
	{
		
		Medical m=new Medical();
		m.start();
		m.join();
		
		TestDrive t=new TestDrive();
		t.start();
		t.join();
		
		OffiserSign o=new OffiserSign();
		o.start();
	
	}

}
