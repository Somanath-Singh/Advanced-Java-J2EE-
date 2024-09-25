//inter thread communicatiion means-wait(),notify(),notifyAll().
//problem occur during interThread communication 

/*package pack4;


class TotalEarnings extends Thread
{
	int total=0;
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			total=total+100;
		}
	}
}

public class InterThreadCommunication {

	public static void main(String[] args) {
		TotalEarnings te=new TotalEarnings();
		te.start();
		System.out.println("total earnings:"+te.total);
	}

}
*/
//resolve the problem using interThraedCommunication

package pack4;


class TotalEarnings extends Thread
{
	int total=0;
	public void run()
	{
		synchronized(this)
	   {
		for(int i=1;i<=10;i++)
		{
			total=total+100;
		}
		this.notify();
	  }
	}
}

public class InterThreadCommunication {

	public static void main(String[] args) {
		TotalEarnings te=new TotalEarnings();
		te.start();
		synchronized(te)
		{
			try
			{
			te.wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("total earnings:"+te.total);
			
		}
		
	}

}