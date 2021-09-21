package system;

public class Patient {
	private MedicalReport medicalReport;
	private WheelChair wheelChair;
	private CareTaker careTaker;
	public  Patient( WheelChair wheelChair) {
		this.wheelChair = wheelChair;
		
	}
	protected MedicalReport getMedicalReport() {
		return medicalReport;
	}
	protected WheelChair getWheelChair() {
		return wheelChair;
	}
	protected CareTaker getCareTaker() {
		return careTaker;
	}
	protected void changeCareTaker(CareTaker careTaker) {
		this.careTaker = careTaker;
	}
	protected void changeWheelChair(WheelChair wheelChair) {
		this.wheelChair = wheelChair;
	}
}