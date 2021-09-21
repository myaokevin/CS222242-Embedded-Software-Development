package system;

import java.util.ArrayList;

public class Person {
	private String name;
	private int nic;
	private String address;
	private int age;
	private String gender;
	private CareHouse relatedCareHouse;
	private ArrayList<ContactDetail> contactDetails;
	public Person(String name,int nic,String address,int age, String gender,CareHouse relatedCareHouse,ContactDetail contactDetail) {
		this.name = name;
		this.nic = nic;
		this.address =address;
		this.age =age;
		this.gender = gender;
		this.relatedCareHouse =relatedCareHouse;
		this.contactDetails.add(contactDetail);
	}
	protected String getName() {
		return name;
	}
	protected int getNic() {
		return nic;
	}
	protected String getAddress() {
		return address;
	}
	protected int getAge() {
		return age;
	}
	protected String getGender() {
		return gender;
	}
	protected CareHouse getRelatedCareHouse() {
		return relatedCareHouse;
	}
	protected ArrayList<ContactDetail> getContactDetails() {
		return contactDetails;
	}
	protected void changeAddress(String address) {
		this.address = address;
	}
	protected void changeRelatedCareHouse(CareHouse relatedCareHouse) {
		this.relatedCareHouse = relatedCareHouse;
	}
	protected void addContactDetails(ContactDetail contactDetail) {
		this.contactDetails.add(contactDetail);
	}
	protected void removeContactDetails(ContactDetail contactDetail) {
		this.contactDetails.remove(contactDetail);
	}
	
	
}
