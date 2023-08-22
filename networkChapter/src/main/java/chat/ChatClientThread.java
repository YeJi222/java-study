package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private Socket socket;
	private BufferedReader br;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while(true) {
				String message = br.readLine(); // 서버로부터 데이터 수신 
				if(message == null) { // 서버로부터 데이터를 받지 못하면 break 
					break;
				}
				
				System.out.println(message); // 서버로 부터 받은 데이터를 터미널 콘솔로 찍어주기 
			}
		} catch (SocketException e) {
			ChatClient.log("error: " + e);
		} catch (IOException e) {
			ChatClient.log("다음 이유로 프로그램을 종료합니다 : " + e);
		} finally {
			System.exit(0);
		}
	}

	

}
