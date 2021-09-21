package system;

public class WheelChair {
	private int id;
	private Location defaultLocation;
	private Location currentLocation;
	private float distanceTravelled;
//	private boolean flipped;
	
	public WheelChair(int id, Location defaultLocation) {
		this.id = id;
		this.defaultLocation = defaultLocation;
	}

	protected Location getDefaultLocation() {
		return defaultLocation;
	}

	protected void setDefaultLocation(Location defaultLocation) {
		this.defaultLocation = defaultLocation;
	}

	protected Location getCurrentLocation() {
		return currentLocation;
	}

	protected void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	protected int getId() {
		return id;
	}

	protected float getDistanceTravelled() {
		return distanceTravelled;
	}
	
}
