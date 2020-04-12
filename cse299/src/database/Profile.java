package database;

public class Profile {
	private String Nid;
	private String Name;
	private String ContactNo;
	private String Address;
	private String Image;
	private String Email;
	
	//---------Constructor
	public Profile(String nid, String name, String contactNo, String address, String image, String email) {
		Nid = nid;
		Name = name;
		ContactNo = contactNo;
		Address = address;
		Image = image;
		Email = email;
	}

	public String getNid() {
		return Nid;
	}
	
	public void setNid(String nid) {
		Nid = nid;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getContactNo() {
		return ContactNo;
	}
	
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getImage() {
		return Image;
	}
	
	public void setImage(String image) {
		Image = image;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}	
	
}
