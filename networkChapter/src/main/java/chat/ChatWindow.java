package chat;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Scanner;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private Socket socket;
	private String name;
	
	private BufferedReader br;
	private PrintWriter pw;

	public ChatWindow(String name, Socket socket) {
		this.socket = socket;
		this.name = name;
		
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(40, 50);
	}

	public void show() { // 윈도우에 붙이기 
		// Button
		buttonSend.setBackground(Color.GRAY);
//		buttonSend.setForeground(Color.WHITE);
		buttonSend.setForeground(Color.BLACK);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(50); // 수평으로 
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) { // 엔터 눌렀을 때 
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel); // 밑으로 붙이기

		// TextArea
		textArea.setEditable(false); // textarea 편집 불가능 
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { // 윈도우가 닫혔을 때 
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		// IOStream 받아오기 
		try {
			// 4. reader/writer 생성 
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // auto-flush
			
			// ChatClientThread 생성하고 실행 
			// 클라이언트마다 socket Thread 실행시켜 다중 채팅 가능하도록 
			new ChatClientThread().start(); 			
		} catch (IOException e) {
			ChatClientApp.log("error: " + e);
		}
	}
	
	private void finish() {
		// 자원 정리 
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
			
			// quit 프로토콜 구현 
			// exit java(JVM) 
			System.out.println("채팅창 종료");
			System.exit(0);
		} catch (IOException e) {
			ChatClientApp.log("error : " + e);
		}
	}
	
	private void sendMessage() {
		String message = textField.getText();
		if(message != null) {
			pw.println("message:" + message);
			System.out.println("메시지 내용 : " + message);
			
			textField.setText(""); // 버튼 누르고 내용 지우기 
			textField.requestFocus(); // 버튼을 누를 때, TextField에 포커싱 
		}
	}
	
	private void updateTextArea(String message) {		
		if(message.contains(":")) { // 채팅 메시지인 경우 
			String[] tokens = message.split(":");
			
			String nickname = tokens[0];
			String content = tokens[1];
			
			if(nickname.equals(name)) {
				message = "[나] " + content;
				
				message = "\t\t   " + message;
			} else {
				message = "[" + nickname + "] " + content;
			}
			
			textArea.append(message);
			textArea.append("\n");
		} else {
			textArea.append(message);
			textArea.append("\n\n");
		}
	}
	
//	private void updateAlert(String message) {
//		textArea.append(message);
//		textArea.append("\n");
//	}
	
	// ChatClientThread.java 분리시키지 않고 private class로 ChatWindow 클래스 내에 선언 
	// socket을 해당 class내에 선언했으므로, 파라미터로 넘겨주지 않아도 ok 
	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			// 키보드 입력 처리 
			while(true) {
				try {
					while(true) {
						String message = br.readLine(); // 서버로부터 데이터 수신 
						if(message == null) { // 서버로부터 데이터를 받지 못하면 break 
							break;
						}
						
						Thread.sleep(1); // 메시지 delay 출력 막기 위해 
						// System.out.println("message - " + message); // 서버로 부터 받은 데이터를 터미널 콘솔로 찍어주기 
						updateTextArea(message);
					}
				} catch (InterruptedException e) { // sleep 관련 exception 
					ChatClientApp.log("error: " + e);
				} catch (SocketException e) {
					ChatClientApp.log("error: " + e);
				} catch (IOException e) {
					ChatClientApp.log("다음 이유로 프로그램을 종료합니다 : " + e);
				} finally {
					finish(); // 시스템 종료 
				}
			}
		}
		
	}
}
