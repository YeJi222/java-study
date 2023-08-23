package chatting.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
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

import chatting.gui.ChatWindow;

public class ChatFirstWindow {
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField nickNameField;
	private TextField roomNameField;
	private Label label;

	public ChatFirstWindow() {
		frame = new Frame("Chatting Program");
		pannel = new Panel();
		buttonSend = new Button("대화명 입력");
		nickNameField = new TextField();
		roomNameField = new TextField();
		label = new Label("Chatting Program");
		// textArea = new TextArea(30, 80);
	}

	public void show() { // 윈도우에 붙이기 
		// label
		label.setFont(new Font("Serif", Font.BOLD, 30));
		
		
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.BLACK);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				// ChatWindow 띄우기 
				sendRoomName();
			}
		});

		// nickName Textfield
		nickNameField.setColumns(20); // 가로 최대값 설정 
		nickNameField.setText("Nickname을 입력하세요");
		
		// roomName Textfield
		roomNameField.setColumns(20); // 가로 최대값 설정 
		roomNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) { // 엔터 눌렀을 때 
					// ChatWindow 띄우기 
					sendRoomName();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(label);
		pannel.add(nickNameField);
		pannel.add(roomNameField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.CENTER, pannel);

		// Frame
		Dimension dim = new Dimension(500, 700);
		frame.setPreferredSize(dim);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { // 윈도우가 닫혔을 때 
				finish();
			}
		});
		frame.setVisible(true); // frame을 화면에 나타나게 
		frame.pack();
		
		// IOStream 받아오기 
		// ChatClientThread 생성하고 실행 
		
	}
	
	private void sendRoomName() {
		String roomName = roomNameField.getText();
		System.out.println("대화명 : " + roomName);
		
		String nickname = nickNameField.getText();
		System.out.println("nickname : " + nickname);
		
		frame.setVisible(false);
		new ChatWindow(roomName, nickname).show();
	}
	
	private void finish() {
		// quit 프로토콜 구현 
		// exit java(JVM) 
		System.out.println("대화창 종료");
		System.exit(0);
	}
	
}
