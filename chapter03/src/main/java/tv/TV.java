package tv;

public class TV {
	// (1) 모든 필드는 Private 접근 제어
	private int channel; // 1 ~ 255
	private int volume; // 0 ~ 100
	private boolean power;
	
	// (2) channel, volume, power의 초기값을 설정하는 생성자 작성
	public TV(int channel, int volume, boolean power) { 
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	// (3) 기본 생성자 오버로딩 
	public TV() { 
		
	}

	// (4) void power( boolean on ) 메소드 구현
	public void power(boolean on) {
		power = on;
	}
	
	// (5) void channel( int channel ) 메소드 구현 (1~255 유지) 
	public void channel(int channel) {
		this.channel = channel;
	}
	
	// (6) void channel( boolean up ) 메소드 오버로딩 (1~255 유지, 1씩 증감)
	public void channel(boolean up) {
		this.channel = channel + 1; // 내 생각 
	}
	
	// (7) void volume( int volume ) 메소드 구현  ( 0 ~ 100 유지 )
	public void volume(int volume) {
		this.volume = volume;
	}
	
	// (8) void volume( boolean up ) 메소드 오버로딩 (0 ~ 100 유지, 1씩 증감)
	public void volume(boolean up) {
		this.volume = volume + 1; // 내 생각 
	}
	
	// (9) void status() 메소드 구현( TV 정보 출력) 
	public void status() { 
		System.out.println("TV[power=" + (power ? "ON" : "off") + ", channel=" + channel + ", volume=" + volume + "]");
	}
	
}
