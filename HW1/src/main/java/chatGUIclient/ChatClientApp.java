package chatGUIclient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	public static final String SERVER_IP = "127.0.0.1"; 
	public static final int PORT = 9999;

	public static void main(String[] args) {
		String name = null;
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			// 0. 키보드 연결 
			scanner = new Scanner(System.in);
						
			// 0-1. 대화명 입력받기 
			while( true ) {
				System.out.println("대화명을 입력하세요.");
				System.out.print("> ");
				name = scanner.nextLine(); // 닉네임 
				
				if (name.isEmpty() == false ) { // 빈 대화명이 아닐 때 
					break;
				}
				
				// 그냥 엔터 쳤을 때, 빈 대화명일 때 
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
						
			// 1. create socket 
			socket = new Socket();
			
			// 1-2. connect server
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			// System.out.println("Test!! nickname : " + name); // test 

			// 2. reader/writer 생성 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // auto-flush
			
			// 3. join protocol 진행 
			pw.println("join:" + name); // 서버에 내용 보내줌 
			
			String ack = br.readLine(); // 서버로부터 받은 내용 수신 
			if("join:ok".equals(ack)) { // 서버에서 join:ok 메시지를 받으면 아래 내용 콘솔로 찍어주기 
				new ChatWindow(name, socket).show();
			}
		} catch (ConnectException e) {
			log("서버[" + SERVER_IP + ":" + PORT + "]에 연결할 수 없습니다.");
		} catch (Exception e) {
			log("error: " + e);
		} finally {
			// 자원 정리 
			if(scanner != null) {
				scanner.close();
			}
		}	
	}
	
	public static void log(String msg) {
		System.out.println("[Chat Client] " + msg);
	}

}
