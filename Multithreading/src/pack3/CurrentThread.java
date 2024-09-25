package pack3;

public class CurrentThread extends Thread {
	public void run() {
		System.out.println("thread task execute:"+Thread.currentThread().getName());
		
	}

	public static void main(String[] args) {
		CurrentThread ct=new CurrentThread();
		ct.start();
		System.out.println("check thread is alive or not for thread:"+ct.isAlive());
		
		CurrentThread ct1=new CurrentThread();
		//change the thread-1 name by user giving name
		ct1.setName("Somanath");
		ct1.start();
		System.out.println("Hello is printed by:"+Thread.currentThread().getName());
		System.out.println("check thread is alive or not for main:"+Thread.currentThread().isAlive());

	}

}
