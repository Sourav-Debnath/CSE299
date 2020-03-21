package database;

public class Post {
	private String postText;
	private String postDate;
	private String postTime;
	private String postCoordinate;
	
	//constructor
	public Post(String postText,String postDate,String postTime,String postCoordinate) {
		this.postText=postText;
		this.postDate=postDate;
		this.postTime=postTime;
		this.postCoordinate=postCoordinate;
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

	public String getPostCoordinate() {
		return postCoordinate;
	}	
	
}
