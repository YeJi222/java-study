package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() { // 윈도우에 붙이기 
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				sendMessage();
			}
		});
		
		/*
		// Overriding 추론 
		buttonSend.addActionListener((ActionEvent e) -> {
			
		});
		*/

		// Textfield
		textField.setColumns(80); // 수평으로 
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
		textArea.setEditable(false);
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
		// ChatClientThread 생성하고 실행 
		
	}
	
	private void finish() {
		// quit 프로토콜 구현 
		// exit java(JVM) 
		System.out.println("대화창 종료");
		System.exit(0);
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메시지를 보내는 프로토콜 구현: " + message);
		
		textField.setText(""); // 버튼 누르고 내용 지우기 
		textField.requestFocus(); // 버튼을 누를 때, TextField에 포커싱 
		
		// ChatClientThread에서 서버로부터 받은 메시지가 있다고 치고 
		updateTextArea("마이콜: " + message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread{

		@Override
		public void run() {
			updateTextArea("마이콜: 안녕~");
		}
		
	}
}
