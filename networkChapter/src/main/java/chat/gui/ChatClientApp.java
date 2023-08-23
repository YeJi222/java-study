package chat.gui;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.println("대화명을 입력하세요.");
			System.out.print("> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) { // 빈 대화명이 아닐 때 
				break;
			}
			
			// 그냥 엔터 쳤을 때, 빈 대화명일 때 
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		// 1. create socket 
		// 2. connect server
		// 3. join protocol 진행 
		
		String line = "JOIN:OK";
		if("JOIN:OK".equals(line)) {
			new ChatWindow(name).show();
		}

		new ChatWindow(name).show();
	}

}
