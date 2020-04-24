package database;

public class Post {
	private String postText;
	private String postDate;
	private String postTime;
	private float lat;
	private float lang;	
	
	//constructor
	public Post(String postText, String postDate, String postTime, float lat, float lang) {
		super();
		this.postText = postText;
		this.postDate = postDate;
		this.postTime = postTime;
		this.lat = lat;
		this.lang = lang;
	}

	public String getPostText() {
		return postText;
	}

	public String getPostDate() {
		return postDate;
	}

	public String getPostTime() {
		return postTime;
	}

	public float getxCoordinate() {
		return lat;
	}

	public float getyCoordinate() {
		return lang;
	}

	
	
}
