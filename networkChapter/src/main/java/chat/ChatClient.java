package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	// private static final String SERVER_IP = "127.0.0.1";
	private static final String SERVER_IP = "0.0.0.0";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			// 1. 키보드 연결 
			scanner = new Scanner(System.in);
			
			// 2. socket 생성 
			socket = new Socket(); 
			
			// 3. 연결 
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			// 4. reader/writer 생성 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // auto-flush
			
			// 5. join 프로토콜 
			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname); // 서버에 보내줌 
			
			String ack = br.readLine();
			if("join:ok".equals(ack)) {
				System.out.println("'" + nickname + "'님이 입장하였습니다. 즐거운 채팅 되세요");
			}
			
			// 6. ChatClientReceivedThread 시작 
			new ChatClientThread(socket).start();
			
			// 7. 키보드 입력 처리 
			while(true) {
				if(!scanner.hasNextLine()) { // 읽을 값이 없으면(그냥 엔터쳤을 때)
					continue;
				}
				
				System.out.print(">> ");
				String input = scanner.nextLine();
				
				if("quit".equals(input)) {
					// 8. quit 프로토콜 처리 
					pw.println("QUIT");
					break;
				} else {
					// 9. 메시지 처리 
					pw.println("message:" + input);
				}
			}
			
		} catch (ConnectException e) {
			log("서버[" + SERVER_IP + ":" + ChatServer.PORT + "]에 연결할 수 없습니다.");
		} catch (Exception e) {
			log("다음 이유로 프로그램을 종료합니다 : " + e);
		} finally {
			// 10. 자원 정리 
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				log("다음 이유로 프로그램을 종료합니다 : " + e);
			}
		}
		
	}

	public static void log(String msg) {
		System.out.println("[Chat Client] " + msg);
	}

}
