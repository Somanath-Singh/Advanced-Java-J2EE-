//error occured without use of static synchronized

/*package pack4;


class BookTheaterSeat3
{
	int total_seat=20;
	 void bookSeat3(int seat)
	{
		if(total_seat>=seat)
		{
			System.out.println(seat+"Seat booked successfully:");
			total_seat=total_seat-seat;
			System.out.println("Seat left:"+total_seat);
		}
		else
		{
			System.out.println("seat cannot be booked");
			System.out.println("seat left:"+total_seat);
		}
	}
}


class MyThread1 extends Thread
{
	static BookTheaterSeat3 b;
	int seats;
	MyThread1(BookTheaterSeat3 b,int seats)
	{
		this.b=b;
		this.seats=seats;
	}
	public void run()
	{
		b.bookSeat3(seats);
	}
}

class MyThread2 extends Thread
{
	static BookTheaterSeat3 b;
	int seats;
	MyThread2(BookTheaterSeat3 b,int seats)
	{
		this.b=b;
		this.seats=seats;
	}
	public void run()
	{
		b.bookSeat3(seats);
	}
}

public class StaticSynchronized extends Thread
{
			public static void main(String[] args) {
				
				//create a reference object of BookTheaterSeat class to call bookseat method
				BookTheaterSeat3 b1=new BookTheaterSeat3();
				
				MyThread1 m1=new MyThread1(b1,7);
				m1.start();
				MyThread2 m2=new MyThread2(b1,6);
				m2.start();
				
                BookTheaterSeat3 b2=new BookTheaterSeat3();
				
				MyThread1 m3=new MyThread1(b2,7);
				m3.start();
				MyThread2 m4=new MyThread2(b2,6);
				m4.start();
				
				
			}

		}
		*/

//use of static synchronized to handle data inconsistency
package pack4;


class BookTheaterSeat3
{
	static int total_seat=20;
	synchronized static  void bookSeat3(int seat)
	{
		if(total_seat>=seat)
		{
			System.out.println(seat+"Seat booked successfully:");
			total_seat=total_seat-seat;
			System.out.println("Seat left:"+total_seat);
		}
		else
		{
			System.out.println("seat cannot be booked");
			System.out.println("seat left:"+total_seat);
		}
	}
}


class MyThread1 extends Thread
{
	static BookTheaterSeat3 b;
	int seats;
	MyThread1(BookTheaterSeat3 b1,int seats)
	{
		b1=b;
		this.seats=seats;
	}
	public void run()
	{
		b.bookSeat3(seats);
	}

}

class MyThread2 extends Thread
{
	static BookTheaterSeat3 b;
	int seats;
	MyThread2(BookTheaterSeat3 b1,int seats)
	{
		b1=b;
		this.seats=seats;
	}
	public void run()
	{
		b.bookSeat3(seats);
	}
	
}

public class StaticSynchronized extends Thread
{
			public static void main(String[] args) {
				
				//create a reference object of BookTheaterSeat class to call bookseat method
				BookTheaterSeat3 b1=new BookTheaterSeat3();
				
				MyThread1 m1=new MyThread1(b1,7);
				m1.start();
				MyThread2 m2=new MyThread2(b1,6);
				m2.start();
	
                BookTheaterSeat3 b2=new BookTheaterSeat3();
				
				MyThread1 m3=new MyThread1(b2,7);
				m3.start();
				MyThread2 m4=new MyThread2(b2,6);
				m4.start();
				
			}

		}

