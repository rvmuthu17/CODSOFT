package rvmuthu;
import java.util.*;

public class Task1 {
	public static void main(String ags[]) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String name = "";
		
		game_Ui(scanner , name );
		loop(scanner ,name, random);
	}
	public static void game_Ui(Scanner scanner , String name) {
		System.out.println("---------Welcome To The Number Prediction Game---------");
		System.out.println("");
		System.out.println("*******************************************************");
		System.out.print  ("*               Enter Your Name =  ");
		name = scanner.nextLine();
		System.out.println("*******************************************************");
		System.out.println("*       Hi "+name+" Please Read The Instructions! ");
		System.out.println("*       1. You Guess a Number From 1 To 100");
		System.out.println("*       2. You Only Have Five chances");
		System.out.println("*  .......Lets start..........All The Best........");
		System.out.println("*******************************************************");
		System.out.println();
	}
	public static void loop(Scanner scanner , String name , Random random) {
		int end          = 5;
		boolean game     = true;
		char play        = 0;
		int userNum      = 0;
		int randomNum    = random.nextInt(100)+1;
		int randomAssign = random.nextInt( 10)+1;

		while(game) {
			if(end >= 1) {
				System.out.print("Enter The Number = ");
				try {
					userNum   = scanner.nextInt();
					if(userNum > 0 && userNum <= 100) {
						if(userNum == randomNum) {
							System.out.println("****************************************");
							System.out.println("            Amazing "+name);
							System.out.println("............You Are The winner.............");
							System.out.println("****************************************");
							System.out.println();
							System.out.print("Play Again! Enter (Yes) or (No) = ");
							play = scanner.next().charAt(0);
							if(play == 'y' || play == 'Y') {
								end = 5;
								randomNum    = random.nextInt(100)+1;
								randomAssign = random.nextInt( 10)+1;
								System.out.println("****************************************");
								System.out.println(">>>>>>>>>>>>>>> Lets Go <<<<<<<<<<<<<<<<");
								System.out.println("****************************************");
								loop(scanner, name, random);
								break;
							}else if(play == 'n' || play == 'N'){
								game = false;
								System.out.println(".......Have a Nice Day........");
								break;
							}else System.out.println("Please Enter Yes (or) No Only!...");
						}else if((randomNum-userNum) >= -randomAssign && (randomNum-userNum) <= randomAssign)
							System.out.println("Yeah! Your Now Closely......Come On "+name);
						else{
							if(randomNum < userNum) System.out.println     ("..........You're Guessing High...........");
							else if(randomNum > userNum) System.out.println("...........You're Guessing Low...........");
						}
						if(end != 1) System.out.println("Only "+(end-1)+" Chance");
					}else {
						if((end-1)!= 0) {
							System.out.println("Please Enter The Number from 1 To 100");
							System.out.println("Warning!!.... You Have Only "+(end-1)+" Chance");
						}
					}
					end--;
				}catch(Exception e) {
					System.out.println("****************************************");
					System.out.println("    Please Enter The Number Only!!!!");
					if((end-1)!= 0) System.out.println("Warning!......You Have Only "+(end-1)+" Chance");
					play = scanner.next().charAt(0);
					if(play == 'y' || play == 'Y') {
						randomNum = random.nextInt(100)+1;
						System.out.println("****************************************");
						System.out.println(">>>>>>>>>>>>>>> Lets Go <<<<<<<<<<<<<<<<");
						System.out.println("****************************************");
						end = 5;
					}else if(play == 'n' || play == 'N') {
						System.out.println(".......Have a Nice Day.......");
						game = false;
						end = 0;
						break;
					}
					end--;
				}
			}
			else {
				if((end) >= 0) {
					System.out.println("****************************************");
					System.out.println("...............Game Over................");
					System.out.println("          The Number is = "+randomNum);
					System.out.println("****************************************");
				}
				System.out.println();
				System.out.print("Play Again! Enter (Yes) or (No) = ");
				end--;
				play = scanner.next().charAt(0);
				if(play == 'y' || play == 'Y') {
					randomNum = random.nextInt(100)+1;
					System.out.println("****************************************");
					System.out.println(">>>>>>>>>>>>>>> Lets Go <<<<<<<<<<<<<<<<");
					System.out.println("****************************************");
					end = 5;
				}else if(play == 'n' || play == 'N') {
					System.out.println(".......Have a Nice Day.......");
					end = 0;
					game = false;
					break;
				}else System.out.println("Please Enter Yes (or) No Only!...");
			}
		}
	}
}