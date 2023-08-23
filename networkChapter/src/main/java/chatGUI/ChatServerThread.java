package chatGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	
	private String nickname; // 연결된 클라이언트의 닉네임 저장 
	private Socket socket; // 통신을 위한 스트림 얻어 오기 위해 Socket 객체 저장 
	// 데이터 통신 스레드들에서 이 PrintWriter 리스트를 공유해야 하기 때문에 
	// 스레드에 List 객체를 참조하는 변수 추가  
	private List<PrintWriter> listWriters; 

	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) { // 생성자 
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		
		// System.out.println("test");
		
		try {
			// 1. Remote Host Information(연결된 클라이언트의 IP와 포트 정보 얻기) 
			// log : Connected by client[클라이언트 IP:클라이언트 포트번호]
			InetSocketAddress remoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			ChatServer.log("Connected by client[" 
					+ remoteSocketAddress.getAddress().getHostAddress() + ":" 
					+ remoteSocketAddress.getPort() + "]");
			
			// 2. 스트림 얻기 
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // auto-flush
			
			// 요청 처리 
			while(true) {
				String request = br.readLine(); // 클라이언트로부터 데이터 수신 
				
				if(request == null) { // 클라이언트에서 종료하면 수신받지 못함 
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}
				
				// 4. 프로토콜 분석 
				// chat 프로토콜 형식 = 요청명령:파라미터1:파라미터2:... \r\n
				// \r\n : 각 요청을 구분하는 경계 
				// 요청은 ':'을 기준으로 요청명령과 파라미터로 분리 
				String[] tokens = request.split(":");
				
				// tokens[0] : 요청명령 ex. join, message, quit
				// tokens[1] : 내용(파라미터)
				// pw :PrintWriter 변수 
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if("quit".equals(tokens[0])) {
					doQuit(pw);
				} else {
					ChatServer.log("에러: 알 수 없는 요청(" + tokens[0] + ")");
				}
			}
			
		} catch (SocketException e) {
			doQuit(pw); // 에러나면 doQuit 실행해서 종료된 클라이언트의 PrintWriter 변수 리스트에서 remove 
			ChatServer.log("abnormal closed by client");
		} catch (IOException e) {
			doQuit(pw); // 에러나면 doQuit 실행해서 종료된 클라이언트의 PrintWriter 변수 리스트에서 remove 
			ChatServer.log("error: " + e);
		} finally {
			// 자원 정리 
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				ChatServer.log("error: " + e);
			}
		}
	}
	
	// 프로토콜 = join:nickname\r\n 
	private void doJoin(String nickName, PrintWriter writer) {
		this.nickname = nickName;
		
		String data = "'" + nickName + "'님이 참여하였습니다.";
		broadcast(data); // 서버에 연결된 모든 클라이언트에 메시지를 보내는 (브로드캐스트) 메소드 
		
		/* writer pool(PrintWriter 리스트)에 저장 */
		addWriter(writer);
		
		// ack를 보내 방 참여가 성공했다는 것을 클라이언트에게 알려주기 
		writer.println("join:ok");
	}

	private void addWriter(PrintWriter writer) {
		// synchronized : 여러 스레드가 하나의 공유 객체에 접근할 때, 동기화를 보장 
		// 동기 : 요청을 보냈을 때, 응답이 돌아와야 다음 동작 수행 가능(순차적 수행) 
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
	
	// 서버에 연결된 모든 클라이언트에 메시지를 보내는 (브로드캐스트) 메소드 
	private void broadcast(String data) {
		// 스레드간 공유 객체인 listWriters에 접근하기 때문에 동기화 처리 필요 
		synchronized(listWriters) {
			for(PrintWriter writer : listWriters) {
				writer.println(data); // 클라이언트에 data 보내주기 
			}
		}
	}
	
	private void doMessage(String message) {
		broadcast(nickname + ":" + message);
	}

	private void doQuit(PrintWriter writer) {
		removeWriter(writer); // 리스트에서 pw 변수 remove 
		
		if(nickname != null) {
			String data = "'" + nickname + "'님이 퇴장 하였습니다.";
			broadcast(data);
		}
	}

	private void removeWriter(PrintWriter writer) {
		synchronized(listWriters) {
			listWriters.remove(writer); // 리스트에서 pw 변수 remove 
		}
	}
}
