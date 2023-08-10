package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private int track;
	
	public Song(String title, String album, String composer, String artist, int track, int year) {
		this.title = title;
		this.album = album;
		this.composer = composer;
		this.artist = artist;
		this.track = track;
		this.year = year;
	}
	
	public Song(String title, String artist) { // 오버로딩 
		/* 코드 중복 - 비효율적 
		this.title = title;
		this.artist = artist;
		*/
		
		this(title, null, null, artist, 0, 0); // this 사용해서 기존의 생성자를 호출(코드 중복 막기 위해서 - 코드 재사용)
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	
	public void show() {
		System.out.println(artist + " " + title + "(" + album + ", " + year + ", " 
				+ track + "번 track, " + composer + " 작곡)");
	}
}
