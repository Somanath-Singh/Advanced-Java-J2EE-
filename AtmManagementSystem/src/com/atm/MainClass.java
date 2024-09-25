package com.atm;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		//create the object of AtmOperationInterface interface using the reference of AtmOperationImpl class
		AtmOperationInterface op=new AtmOperationImpl();
		
		int atmnumber=12345;
		int atmpin=123;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to ATM machine");
        System.out.println("Enter Your Atm no  :");
        int atmNumber=sc.nextInt();
        System.out.println("EnterAtm pin  :");
        int atmPin=sc.nextInt();
        //condition for validate
        if((atmnumber==atmNumber) && (atmpin==atmPin)) {
        	System.out.println("-----------------------------------------------Validation Done---------------------------------------------");
        	
        	//menu
        	while(true) {
        		System.out.println("1.View Available Balance \n 2.Withdraw Amount \n 3.Deposite amount \n 4.View Mini Statement \n 5.Exit");
        		System.out.println("Enter your choice    :");
        		int ch=sc.nextInt();
        		System.out.println("------------------------------------------------------------------------------------------------------------------");
        		
        		if(ch==1) {
        			op.viewBalance();
        			System.out.println("------------------------------------------------------------------------------------------------------------------");
        		}
        		else if(ch==2){
        			System.out.println("Enter Amount to Withdraw   :");
        			double withdrawAmount=sc.nextDouble();
        			op.withdrawAmout(withdrawAmount);
        			System.out.println("------------------------------------------------------------------------------------------------------------------");
        		}
        		else if(ch==3) {
        			System.out.println("Enter Amount to Deposite   : ");
        			int depositAmount=sc.nextInt();//5000
        			op.depositeAmount(depositAmount);
        			System.out.println("------------------------------------------------------------------------------------------------------------------");
        		}
        		else if(ch==4) {
        			op.viewMiniStatement();
        			System.out.println("------------------------------------------------------------------------------------------------------------------");
        		}
        		else if(ch==5) {
        			System.out.println("Collect your ATM card\n Thank you for using our ATM service.");
        			System.exit(0);
        			System.out.println("------------------------------------------------------------------------------------------------------------------");
        		}
        		else {
        			System.out.println("Please enter correct choice.");
        		}
        	}
        }
        else {
        	System.out.println("---------------------------------------Incorrect Atm Number or Pin!!---------------------------------");
        	System.out.println("---------------------------------------Please enter valid ATM pin and number.----------------------------------");
        	System.out.println("-----------------------------------------Thank You-------------------------------------------------");
        	System.exit(0);
        }
	}

}
