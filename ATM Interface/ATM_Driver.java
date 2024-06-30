package ATM;

import java.util.Scanner;

public class ATM_Driver {
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		Bank bank  = new Bank();

		int atmPin    = 1234, newPin = 0, confPin = 0;
		int choice    = 0;
		boolean start = true;
		double withdrawAmt, depositAmt;

		System.out.println(">>>>>>>>>>>>>>>> Welcome To Mariamman Indian Bank ATM <<<<<<<<<<<<<<<<<<\n");

		while(start) {
			System.out.println("************************************************************************");
			System.out.println("       1.     CheckBalance\n       2.     DepositAmount\n       3.     WithdrawAmount\n       "
					+ "4.     MiniStatement\n       5.     AtmPinForgot\n       6.     Exit");
			System.out.println("************************************************************************");
			System.out.print("Enter The Option = ");

			choice = scanner.nextInt();
			if(choice <= 6 && choice >= 1) {
				switch(choice) {
				case 1:
					if(pin(scanner, atmPin) == 1) bank.viewBalance();
					break;
				case 2:
					if(pin(scanner, atmPin) == 1) {
						System.out.print("Enter The Deposit Amount = ");
						depositAmt =  scanner.nextDouble();
						if(depositAmt % 100 == 0) bank.depositAmt(depositAmt);
						else System.out.println(".....please Enter The Amount Multiple Of 100.....");
					}
					break;
				case 3:
					if(pin(scanner, atmPin) == 1) {
						System.out.print("Enter The WithdrawAmount = ");
						withdrawAmt = scanner.nextDouble();
						if(withdrawAmt % 100 == 0) bank.withdrawAmt(withdrawAmt);
						else System.out.println(".....please Enter The Amount Multiple Of 100.....");
					}
					break;
				case 4:
					if(pin(scanner, atmPin) == 1) bank.miniStatement();
					break;
				case 5:
					System.out.print("Enter Your New Pin = ");
					newPin = scanner.nextInt();
					System.out.print("Again Enter The New Pin = ");
					confPin = scanner.nextInt();
					if(newPin == confPin) {
						atmPin = newPin;
						System.out.println("Successfully Pin Number Changed...!");
					}else {
						System.out.println("Pin Number Not Changed...Something went wrong...");
					}
					break;
				case 6: start = false; break;
				}
			}else System.out.println("Please Enter The Number  from 1 To 6");
		}
	}
	public static int pin(Scanner scanner  , int atmPin) {
		System.out.print("Enter You ATM Pin No = ");
		int userPin = scanner.nextInt();
		if(userPin == atmPin)  return 1;
		else System.out.println("Wrong Pin Number.........!"); return 0;
	}
}
