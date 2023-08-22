package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress; // ip주소를 다루기 위한 클래스 
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 9999;

	public static void main(String[] args) {
		// PrintWriter를 담을 수 있는 List 생성 - 공유 객체 
		List<PrintWriter> listWriters = new ArrayList<PrintWriter>(); 
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버 소켓 생성 
			serverSocket = new ServerSocket();
			
			// 2. 바인딩 
			String hostAddress = InetAddress.getLocalHost().getHostAddress(); // 로컬호스트 ip주소 반환
			// System.out.println(hostAddress); // test
			
			hostAddress = "0.0.0.0";
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT), 10); // addrlen : 주소 정보를 담은 변수의 길이 
			log("연결 기다림 " + hostAddress + ":" + PORT);
			
			// 3. 요청 대기 
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}
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
