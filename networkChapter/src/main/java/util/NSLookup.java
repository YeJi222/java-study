package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("> ");
			String line = sc.nextLine();
			
			if("exit".equals(line)) break;
			
			try {
				InetAddress[] inetAddress = InetAddress.getAllByName(line);
				for(int i = 0 ; i < inetAddress.length ; i++) {
					System.out.println(inetAddress[i].getHostName() 
							+ " : " 
							+ inetAddress[i].getHostAddress()
					);
				}
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}

}
