package database;

public class Post {
	private String postText;
	private String postDate;
	private String postTime;
	private float lat;
	private float lang;
	private int houseNo;
	private int flatNo;
	private int floorNo;
	private int size;
	private int noBedRoom;
	private int noBathRoom;
	private int price;
	private String flatPic;
	private String facing;
	private int roadNo;
	private String blockNo;
	private String areaName;
	private String district;
	
	//constructor
	public Post(String postText, String postDate, String postTime, float lat, float lang, int houseNo, int flatNo,
			int floorNo, int size, int noBedRoom, int noBathRoom, int price, String flatPic, String facing, int roadNo,
			String blockNo, String areaName, String district) {
		super();
		this.postText = postText;
		this.postDate = postDate;
		this.postTime = postTime;
		this.lat = lat;
		this.lang = lang;
		this.houseNo = houseNo;
		this.flatNo = flatNo;
		this.floorNo = floorNo;
		this.size = size;
		this.noBedRoom = noBedRoom;
		this.noBathRoom = noBathRoom;
		this.price = price;
		this.flatPic = flatPic;
		this.facing = facing;
		this.roadNo = roadNo;
		this.blockNo = blockNo;
		this.areaName = areaName;
		this.district = district;
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

	public float getLat() {
		return lat;
	}

	public float getLang() {
		return lang;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public int getSize() {
		return size;
	}

	public int getNoBedRoom() {
		return noBedRoom;
	}

	public int getNoBathRoom() {
		return noBathRoom;
	}

	public int getPrice() {
		return price;
	}

	public String getFlatPic() {
		return flatPic;
	}

	public String getFacing() {
		return facing;
	}

	public int getRoadNo() {
		return roadNo;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public String getAreaName() {
		return areaName;
	}

	public String getDistrict() {
		return district;
	}	
	
}
