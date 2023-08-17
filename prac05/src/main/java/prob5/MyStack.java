package prob5;

public class MyStack {
	private String[] buffer;
	private int bufferSize;
	private int topIdx;
	
	public MyStack(int bufferSize) {
		this.bufferSize = bufferSize;
		buffer = new String[this.bufferSize];
		this.topIdx = -1;
	}

	public void push(String string) {
		if(topIdx == buffer.length - 1) {
			resize();
		}
		
		buffer[++topIdx] = string;
	}

	private void resize() {
		String[] temp = new String[buffer.length * 2]; // 사이즈 2배 늘려주기 
		for(int i = 0 ; i <= topIdx ; i++) {
			temp[i] = buffer[i];
		}
		
		buffer = temp;
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
