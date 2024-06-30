package ATM;

import java.util.*;

public  class Bank implements ATM_OPERATE {
	
	Scanner scanner = new Scanner(System.in);
	AtmOperation atm = new AtmOperation(); 
	Map<Double , String> map = new HashMap<>();

	@Override
	public void viewBalance() {
		
		System.out.println("\nYou Blances is Loading.....!!!");
		System.out.println("Current Balance is = "+atm.getBalance());
	}

	@Override
	public void withdrawAmt(double withdrawAmt) {
		
		if(withdrawAmt <= atm.getBalance()) {
			System.out.print("         Confirm Y/N : ");
			String s = scanner.next();
			if(s.equals("Y") || s.equals("y")) {
				System.out.println("Sucessfully Withdraw Amount is : "+withdrawAmt);
				map.put(withdrawAmt, "Withdraw Amount");
				atm.setBalance(atm.getBalance()-withdrawAmt);
			}else System.out.println("Your Transaction is canceled!...!");}
			
		else System.out.println("Insufficient Balance....!");
	}
	@Override
	public void depositAmt(double depositAmt) {
		atm.setDepositAmt(depositAmt);
		atm.setBalance(atm.getDepositAmt()+atm.getBalance());
		map.put(depositAmt, "Deposit Amount");
		System.out.println("Sucessfully Deposit Amount is : "+depositAmt);
	}
	@Override
	public void miniStatement() {
		System.out.println("Your Bank MiniStatement");
		System.out.println();
		
		if(map.isEmpty()) {
			System.out.println("No Transactions......!");
		}else {
			for(int i =0;i<map.size();i++) {
				System.out.println(map.toString());
			}
		}
	}
}
