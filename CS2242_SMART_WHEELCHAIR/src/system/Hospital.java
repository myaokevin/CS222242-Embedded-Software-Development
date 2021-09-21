package system;

import java.util.ArrayList;

public class Hospital {
	private String name;
	private Location location;
	private ArrayList<ContactDetail> contactDetails;
	private ArrayList<CareHouse> careHouses;
	private int numOfPatients;
	public Hospital(String name,Location location,ContactDetail contactDetail){
		this.name = name;
		this.location = location;
		this.contactDetails.add(contactDetail);
	}
	protected String getName() {
		return this.name;
	}

	protected Location getLocation() {
		return this.location;
	}
	protected ArrayList<CareHouse> getCareHouseList() {
		return this.careHouses;
	}
	protected ArrayList<ContactDetail> getContactDetails() {
		return this.contactDetails;
	}
	protected int getNumOfPatients() {
		return this.numOfPatients;
	}
	
	protected void addContact(ContactDetail contactDetail) {
		this.contactDetails.add(contactDetail);
	}
	protected void removeContact(ContactDetail contactDetail) {
		this.contactDetails.remove(contactDetail);
	}
	protected void addCareHouse(CareHouse careHouse) {
		this.careHouses.add(careHouse );
	}
	protected void removeCareHouse(CareHouse careHouse) {
		this.careHouses.remove(careHouse );
	}
		
}
