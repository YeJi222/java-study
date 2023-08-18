package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			log("starts...[port:" + PORT + "]");
			
			Socket socket = serverSocket.accept();
			
			try {
				InetSocketAddress remoteInetSocketAddress 
					= (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
				int remotePort = remoteInetSocketAddress.getPort();
				log("connected by client[" + remoteHostAddress 
						+ ":" + remotePort + "]");
				
				// 4. IO Stream 받아오기 
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
				
				PrintWriter pw = 
						new PrintWriter(new OutputStreamWriter(os, "utf-8"), true); // auto-flush
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
				pw.print("안녕");
				pw.flush();
				
				while(true) {
					Socket socket = serverSocket.accept();
					new EchoRequestHandler(socket).start();
					
				}
			} catch (SocketException e) {
				System.out.println("");
			} catch (IOException e) {
				System.out.println("[server] error:" + e);
			} finally {
				try {
					if(serverSocket != null && !serverSocket.isClosed()) {
						serverSocket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}

}
