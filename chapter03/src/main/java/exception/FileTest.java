package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileTest {
	public static void main(String[] args) {
		try {
			FileInputStream fs = new FileInputStream("hello.txt");
		} catch (FileNotFoundException e) {
			System.out.println("error: " + e);
		}
	}
}
