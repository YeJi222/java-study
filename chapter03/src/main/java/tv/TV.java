package tv;

public class TV {
	// (1) 모든 필드는 Private 접근 제어
	private int channel; // 1 ~ 255
	private int volume; // 0 ~ 100
	private boolean power;
	
	// getter 작성 
	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}
	
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
		if(1 <= channel &&  channel <=  255) {
			this.channel = channel;
		} else {
			System.out.println("입력한 채널: " + channel + " (channel 1~255 유지해야 합니다.)\n");
		}
	}
	
	// (6) void channel( boolean up ) 메소드 오버로딩 (1~255 유지, 1씩 증감)
	public void channel(boolean up) {
		if(1 <= channel &&  channel <=  255) {
			if(up == true) {
				this.channel = channel + 1; 
			} else {
				this.channel = channel - 1; 
			}
		}
	}
	
	// (7) void volume( int volume ) 메소드 구현  ( 0 ~ 100 유지 )
	public void volume(int volume) {
		if(0 <= volume &&  volume <=  100) {
			this.volume = volume;
		} else {
			System.out.println("입력한 볼륨: " + volume + " (volume 0~100 유지해야 합니다.)\n");
		}
	}
	
	// (8) void volume( boolean up ) 메소드 오버로딩 (0 ~ 100 유지, 1씩 증감)
	public void volume(boolean up) {
		if(0 <= volume &&  volume <=  100) {
			if(up == true) {
				this.volume = volume + 1; 
			} else {
				this.volume = volume - 1; 
			}
		}
	}
	
	// (9) void status() 메소드 구현( TV 정보 출력) 
	public void status() { 
		System.out.println("TV[power=" + (power ? "ON" : "OFF") + ", channel=" + channel + ", volume=" + volume + "]");
	}
	
}
