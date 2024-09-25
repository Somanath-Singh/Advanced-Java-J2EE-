package com.atm;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterface {

	//create the object of ATM class
	ATM atm=new ATM();
	//create the hashmap
	Map<Double,String> ministmt=new HashMap();
	@Override
	public void viewBalance() {
		System.out.println("Aailabe Balance is   :      "+atm.getBalance());
		
	}

	@Override
	public void withdrawAmout(double withdrawAmount) {
		
		if(withdrawAmount<=atm.getBalance()) {
			ministmt.put(withdrawAmount," Amount Withdrown");
			System.out.println("Collect the cash  "+withdrawAmount);
			atm.setBalance(atm.getBalance()-withdrawAmount);
			viewBalance();
		}
		else {
			System.out.println("Insufficient Balance in your Account!!");
		}
		
	}

	@Override
	public void depositeAmount(double depositeAmount) {
		ministmt.put(depositeAmount," Amount Deposited");
		System.out.println(depositeAmount +"  Deposited Successfully  !! ");
		atm.setBalance(atm.getBalance()+depositeAmount);
		viewBalance();
	}

	@Override
	public void viewMiniStatement() {
		for(Map.Entry<Double,String> m:ministmt.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
	}

}
