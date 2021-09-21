package system;

public class MedicalReport {
	private String pulseRate,bloodOxygenLevel,temperature,sugarLevel,skinMoisture;
	public MedicalReport(String pulseRate,String bloodOxygenLevel,String temperature,String sugarLevel,String skinMoisture) {
		this.bloodOxygenLevel =bloodOxygenLevel;
		this.pulseRate = pulseRate;
		this.temperature = temperature;
		this.sugarLevel = sugarLevel;
		this.skinMoisture = skinMoisture;
	}
	// sensors data 
	protected String getPulseRate() {
		return pulseRate;
	}
	protected String getBloodoxygenLevel() {
		return bloodOxygenLevel;
	}
	protected String getTemperature() {
		return temperature;
	}
	protected String getSugarLevel() {
		return sugarLevel;
	}
	protected String getSkinMoisture() {
		return skinMoisture;
	}
	protected void setPulseRate(String pulseRate) {
		this.pulseRate = pulseRate;
	}
	protected void setBloodoxygenLevel(String bloodoxygenLevel) {
		this.bloodOxygenLevel = bloodoxygenLevel;
	}
	protected void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	protected void setSugarLevel(String sugarLevel) {
		this.sugarLevel = sugarLevel;
	}
	protected void setSkinMoisture(String skinMoisture) {
		this.skinMoisture = skinMoisture;
	}
	
	
}
