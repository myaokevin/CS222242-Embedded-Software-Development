package system;

import java.util.ArrayList;

public class CareHouse {
	private String name;
	private int id;
	private Location location;
	private ArrayList<ContactDetail> contactDetails;
	private int numOfChairs;
	private ArrayList<CareTaker> careTakers;
	private ArrayList<Patient> patients;
	private Hospital relatedHospital;
	public CareHouse(String name,int id,Location location,ContactDetail contactDetail,Hospital relatedHospital) {
		this.name = name;
		this.id = id;
		this.location = location;
		this.relatedHospital = relatedHospital;
		this.contactDetails.add(contactDetail);
		
	}
	protected String getName() {
		return name;
	}
	protected Location getLocation() {
		return location;
	}
	protected ArrayList<ContactDetail> getContactDetails() {
		return contactDetails;
	}
	protected int getNumOfChairs() {
		return numOfChairs;
	}
	protected CareTaker findCareTakers(CareTaker c) {
		// find by NIC
		return c;
	}
	protected Patient findPatient(Patient p) {
		//find by NIC
		return p;
	}
	protected Hospital getRelatedHospital() {
		return relatedHospital;
	}
	
}
