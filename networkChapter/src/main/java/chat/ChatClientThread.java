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
				String message = br.readLine();
				if(message == null) {
					break;
				}
				
				System.out.println(message);
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
