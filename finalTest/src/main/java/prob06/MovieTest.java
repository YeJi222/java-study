package prob06;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int exit = 0;
		
		while(exit != 1) {
			System.out.println();
			System.out.println("== Ticketing System ==");
			System.out.println("1. Reserve");
			System.out.println("2. Cancel");
			System.out.println("3. Count");
			System.out.println("4. exit");
			
			System.out.print("> ");
			int num = sc.nextInt();
			
			if(num == 3) {
				System.out.println();
				System.out.println("== Count ==");
				System.out.println("1.The Lord of the Rings");
				System.out.println("2. The Matrix");
				System.out.println("3. Pride & Prejudice");
				
				System.out.print("> ");
				int countNum = sc.nextInt();
				System.out.println(countNum);
			} else if(num == 4) {
				exit = 1;
				System.out.println("종료합니다.");
			}
		}
		
		

	}

}
