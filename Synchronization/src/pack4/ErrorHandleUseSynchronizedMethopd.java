package pack4;

	class BookTheaterSeat1
	{
		int total_seat=10;
		//synchronized method to handle multiple thread THread execute one after another
		synchronized void bookSeat1(int seat)
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

	public class ErrorHandleUseSynchronizedMethopd  extends Thread {
		
		//create a reference object of BookTheaterSeat class to call bookseat method
			static BookTheaterSeat1 b;
			int seats;
			public void run()
			{
				b.bookSeat1(seats);
			}

		public static void main(String[] args) {
			b=new BookTheaterSeat1();
			 ErrorHandleUseSynchronizedMethopd m1=new  ErrorHandleUseSynchronizedMethopd();
			m1.seats=7;
			m1.start();
			
			 ErrorHandleUseSynchronizedMethopd m2=new  ErrorHandleUseSynchronizedMethopd();
			m2.seats=6;
			m2.start();
			
		}

	}
