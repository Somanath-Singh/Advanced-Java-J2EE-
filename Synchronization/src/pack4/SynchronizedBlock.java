package pack4;


class BookTheaterSeat2
{
	int total_seat=10;
	 void bookSeat2(int seat)
	{
		//synchronized block(only execute perticular block) to handle multiple thread  execute one after another
		 synchronized(this)
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
		 }// synchronized
	}
}


	 public class SynchronizedBlock  extends Thread {
		
		//create a reference object of BookTheaterSeat class to call bookseat method
			static BookTheaterSeat2 b;
			int seats;
			public void run()
			{
				b.bookSeat2(seats);
			}

		public static void main(String[] args) {
			b=new BookTheaterSeat2();
			SynchronizedBlock m1=new SynchronizedBlock();
			m1.seats=7;
			m1.start();
			
			SynchronizedBlock m2=new  SynchronizedBlock();
			m2.seats=6;
			m2.start();
			
		}

	}