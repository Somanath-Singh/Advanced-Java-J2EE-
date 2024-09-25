package pack4;

//this program gives the problem of data inconsistency so we use synchronization to control multiple thread
class BookTheaterSeat
{
	int total_seat=10;
	void bookSeat(int seat)
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

public class ErroeWithoutSynchronization extends Thread {
	
	//create a reference object of BookTheaterSeat class to call bookseat method
		static BookTheaterSeat b;
		int seats;
		public void run()
		{
			b.bookSeat(seats);
		}

	public static void main(String[] args) {
		b=new BookTheaterSeat();
		ErroeWithoutSynchronization m1=new ErroeWithoutSynchronization();
		m1.seats=7;
		m1.start();
		
		ErroeWithoutSynchronization m2=new ErroeWithoutSynchronization();
		m2.seats=6;
		m2.start();
		
	}

}
