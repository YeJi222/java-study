package prob5;

public class MainApp {

	public static void main(String[] args) throws MyStackException {
		try {
			MyStack stack = new MyStack(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
		} catch ( MyStackException ex) { // stack이 빈 상태인데 pop을 하는 경우, exception 발생시키기 
			System.out.println( ex );
		}

	}

}

