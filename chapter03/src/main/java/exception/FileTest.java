package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello3.txt");
			int data = fis.read();
			
			System.out.println((char)data);
		} catch (FileNotFoundException e) {
			System.out.println("error: " + e);
		} catch(IOException e) {
			System.out.println("error: " + e);
		} finally { // 자원정리 
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
