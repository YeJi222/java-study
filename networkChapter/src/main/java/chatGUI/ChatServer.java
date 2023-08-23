package chatGUI;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress; // ip주소를 다루기 위한 클래스 
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 9998;

	public static void main(String[] args) {
		// PrintWriter를 담을 수 있는 List 생성 - 공유 객체 
		List<PrintWriter> listWriters = new ArrayList<PrintWriter>(); 
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버 소켓 생성 
			serverSocket = new ServerSocket();
			
			// 1-1. FIN-WAIT -> TIME_WAIT 상태에서도 소켓 포트 할당이 가능하도록 하기 위해 ... 
			// 클라이언트가 많아지면 문제가 발생할 수 있는데 이를 막기 위함 
			serverSocket.setReuseAddress(true); // time-wait 상황에서도 서버 재실행 가능하게 
			
			// 2. 바인딩 
			String hostAddress = InetAddress.getLocalHost().getHostAddress(); // 로컬호스트 ip주소 반환
			// System.out.println(hostAddress); // test
			
			// hostAddress = "0.0.0.0"; // 모든 ip 주소 받기 가능 
			// bind 메소드에서 인자 '50' 의미 -> 큐 
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 50); 
			log("연결 기다림 [" + hostAddress + ":" + PORT + "]");
			
			// 3. 요청 대기 
			while(true) {
				Socket socket = serverSocket.accept(); // 클라이언트의 연결 요청 대기 
				// Server Thread 실행 - 클라이언트가 연결 될 때마다 서버 Thread 생성 및 실행
				// 동시 작업(다중 채팅)이 가능하도록 Thread 실행한다 
				new ChatServerThread(socket, listWriters).start(); 
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 자원 정리 
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				log("error: " + e);
			}
		}
	}

	static void log(String msg) {
		System.out.println("[Chat Server] " + msg);
	}

}
