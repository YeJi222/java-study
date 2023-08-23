package chatting.gui;

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
	private static final String SERVER_IP = "0.0.0.0"; // 모든 ip 연결 가능 
	
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
			pw.println("join:" + nickname); // 서버에 내용 보내줌 
			
			String ack = br.readLine(); // 서버로부터 받은 내용 수신 
			if("join:ok".equals(ack)) { // 서버에서 join:ok 메시지를 받으면 아래 내용 콘솔로 찍어주기 
				System.out.println("'" + nickname + "'님이 입장하였습니다. 즐거운 채팅 되세요");
			}
			
			// 6. ChatClientReceivedThread 시작 
			// 클라이언트마다 socket Thread 실행시켜 다중 채팅 가능하도록 
			new ChatClientThread(socket).start(); 
			
			// 7. 키보드 입력 처리 
			while(true) {
				if(!scanner.hasNextLine()) { // 읽을 값이 없으면(그냥 실수로 엔터쳤을 때)
					continue;
				}
				
				System.out.print(">> ");
				String input = scanner.nextLine();
				
				if("quit".equals(input)) {
					// 8. quit 프로토콜 처리 
					pw.println("quit"); // 클라이언트에게 quit 데이터 전송(서버는 이걸 받아서 doQuit 메소드 실행)
					break;
				} else {
					// 9. 메시지 처리 
					// quit이 아닌 다른 메시지가 입력되었을 때, 채팅 메시지로 인식하고 서버에 메시지 내용 보내줌 
					// 서버는 이 메시지를 받아서 doMessage 메소드 실행 
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
