package database;

public class Post {
	private String postText;
	private String postDate;
	private String postTime;
	private float xCoordinate;
	private float yCoordinate;	
	
	//constructor
	public Post(String postText, String postDate, String postTime, float xCoordinate, float yCoordinate) {
		super();
		this.postText = postText;
		this.postDate = postDate;
		this.postTime = postTime;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
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
		return xCoordinate;
	}

	public float getyCoordinate() {
		return yCoordinate;
	}
		
}
