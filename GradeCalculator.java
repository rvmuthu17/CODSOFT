package rvmuthu;

import java.util.*;
public class GradeCalculator {
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int numOfSub = 0 , totalMarks = 0 , maxMark = 0 ;

		try {
			System.out.print("Enter The Total Subjects = ");
			numOfSub= scanner.nextInt();
		}catch(Exception e) {
			System.out.println("Please Enter Numbers Only!.....");
			return;
		}

		if(numOfSub <= 0) {
			System.out.println("Please Enter a Valid Number of The Subject!...");
			return;
		}

		System.out.print("Out of Mark is 100 ! you can change Yes or No = ");
		char choose = scanner.next().charAt(0);

		if(choose == 'y' || choose == 'Y') {
			System.out.print("Enter Your Max Mark = ");
			try {
				maxMark = scanner.nextInt();
			}catch(Exception e) {
				System.out.println("Please Enter Numbers Only!..");
				return;
			}
		}else if(choose == 'n' || choose == 'N') {
			maxMark = 100;
		}else {
			System.out.println("Please Enter Yes or No");
			return;
		}



		for(int i=0; i< numOfSub;i++) {
			int mark = 0;
			System.out.print("Enter Marks Obtained in Subject "+(i+1)+"(out of "+maxMark+" = )");
			mark = scanner.nextInt();
			System.out.println();
			if(mark < 0 || mark > maxMark) {
				System.out.println("marks should be in the range of 0 to 100..");
				i--;
			}else {
				totalMarks += mark;
			}
		}

		double percentage = (double) totalMarks / (numOfSub * maxMark)*100;
		System.out.println("Total Marks = "+totalMarks);
		System.out.println("Avrage Percentage = "+percentage +"%");

		String grade;

		if(percentage >= 90) {
			grade = "A+";
		}else if(percentage >= 80) {
			grade = "A";
		}else if(percentage >= 70) {
			grade = "B";
		}else if(percentage >= 60) {
			grade = "C";
		}else if(percentage >= 50) {
			grade = "D";
		}else if(percentage >= 40) {
			grade = "E";
		}else {
			grade = "Fail";
		}
		System.out.println("Grade = "+ grade);
	}
}

