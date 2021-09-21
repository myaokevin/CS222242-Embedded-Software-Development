package system;

public class CareTaker extends Person{
	private String role;
	private String userName;//login credentials
	
	public CareTaker(String name, int nic, String address, int age, String gender, CareHouse relatedCareHouse,ContactDetail contactDetail,String role,String userName) {
		super(name, nic, address, age, gender, relatedCareHouse, contactDetail);
		this.role =role;
		this.userName =userName;
	}

	protected String getRole() {
		return role;
	}

	protected String getUserName() {
		return userName;
	}
	
	protected void changeUserName(String userName) {
		this.userName = userName;
	}
	
}
