package prob5;

public class MyStack {
	private String[] buffer;
	private int bufferSize;
	private int topIdx;
	
	public MyStack(int bufferSize) {
		this.bufferSize = bufferSize * 2; // 2배 늘려주기 
		buffer = new String[this.bufferSize];
		this.topIdx = -1;
	}

	public void push(String string) {
		buffer[++topIdx] = string;
	}

	public boolean isEmpty() {
		if(topIdx == -1) return true;
		
		return false;
	}

	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException();
		}
		
		String popStr = buffer[topIdx];
		buffer[topIdx] = null;
		topIdx--;
		
		return popStr;
	}
}
