/**
 * 
 */

/**
 * @author Mauro
 *
 */
public class OutputWriter {
	
	/**
	 * 
	 */
	private int vehicle;
	/**
	 * 
	 */
	private int origin;
	/**
	 * 
	 */
	private int destination;
	/**
	 * 
	 */
	private float distance;
	/**
	 * 
	 */
	private float rel;
	/**
	 * 
	 */
	private float deadline;
	/**
	 * 
	 */
	private float servTime;
	/**
	 * 
	 */
	private int demDest;
	/**
	 * 
	 */
	private float arrivalTimeDestination;
	/**
	 * 
	 */
	private float arrivalBatteryDestination;
	/**
	 * 
	 */
	private float arrivalLoadDestination;
	/**
	 * 
	 */
	private float rechargingTime;
	/**
	 * 
	 */
	private int plugUsed;
	/**
	 * 
	 */
	private float startRechargingTime;
	/**
	 * 
	 */
	public OutputWriter() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param vehicle
	 * @param origin
	 * @param destination
	 * @param distance
	 * @param rel
	 * @param deadline
	 * @param servTime
	 * @param demDest
	 * @param arrivalTimeDestination
	 * @param arrivalBatteryDestination
	 * @param arrivalLoadDestination
	 * @param rechargingTime
	 * @param plugUsed
	 * @param startRechargingTime
	 */
	public OutputWriter(int vehicle, int origin, int destination, float distance, float rel, float deadline,
			float servTime, int demDest, float arrivalTimeDestination, float arrivalBatteryDestination,
			float arrivalLoadDestination, float rechargingTime, int plugUsed, float startRechargingTime) {
		super();
		this.vehicle = vehicle;
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
		this.rel = rel;
		this.deadline = deadline;
		this.servTime = servTime;
		this.demDest = demDest;
		this.arrivalTimeDestination = arrivalTimeDestination;
		this.arrivalBatteryDestination = arrivalBatteryDestination;
		this.arrivalLoadDestination = arrivalLoadDestination;
		this.rechargingTime = rechargingTime;
		this.plugUsed = plugUsed;
		this.startRechargingTime = startRechargingTime;
	}
	/**
	 * @return the vehicle
	 */
	public int getVehicle() {
		return vehicle;
	}
	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}
	/**
	 * @return the origin
	 */
	public int getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	/**
	 * @return the destination
	 */
	public int getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(int destination) {
		this.destination = destination;
	}
	/**
	 * @return the distance
	 */
	public float getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(float distance) {
		this.distance = distance;
	}
	/**
	 * @return the rel
	 */
	public float getRel() {
		return rel;
	}
	/**
	 * @param rel the rel to set
	 */
	public void setRel(float rel) {
		this.rel = rel;
	}
	/**
	 * @return the deadline
	 */
	public float getDeadline() {
		return deadline;
	}
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(float deadline) {
		this.deadline = deadline;
	}
	/**
	 * @return the servTime
	 */
	public float getServTime() {
		return servTime;
	}
	/**
	 * @param servTime the servTime to set
	 */
	public void setServTime(float servTime) {
		this.servTime = servTime;
	}
	/**
	 * @return the demDest
	 */
	public int getDemDest() {
		return demDest;
	}
	/**
	 * @param demDest the demDest to set
	 */
	public void setDemDest(int demDest) {
		this.demDest = demDest;
	}
	/**
	 * @return the arrivalTimeDestination
	 */
	public float getArrivalTimeDestination() {
		return arrivalTimeDestination;
	}
	/**
	 * @param arrivalTimeDestination the arrivalTimeDestination to set
	 */
	public void setArrivalTimeDestination(float arrivalTimeDestination) {
		this.arrivalTimeDestination = arrivalTimeDestination;
	}
	/**
	 * @return the arrivalBatteryDestination
	 */
	public float getArrivalBatteryDestination() {
		return arrivalBatteryDestination;
	}
	/**
	 * @param arrivalBatteryDestination the arrivalBatteryDestination to set
	 */
	public void setArrivalBatteryDestination(float arrivalBatteryDestination) {
		this.arrivalBatteryDestination = arrivalBatteryDestination;
	}
	/**
	 * @return the arrivalLoadDestination
	 */
	public float getArrivalLoadDestination() {
		return arrivalLoadDestination;
	}
	/**
	 * @param arrivalLoadDestination the arrivalLoadDestination to set
	 */
	public void setArrivalLoadDestination(float arrivalLoadDestination) {
		this.arrivalLoadDestination = arrivalLoadDestination;
	}
	/**
	 * @return the rechargingTime
	 */
	public float getRechargingTime() {
		return rechargingTime;
	}
	/**
	 * @param rechargingTime the rechargingTime to set
	 */
	public void setRechargingTime(float rechargingTime) {
		this.rechargingTime = rechargingTime;
	}
	/**
	 * @return the plugUsed
	 */
	public int getPlugUsed() {
		return plugUsed;
	}
	/**
	 * @param plugUsed the plugUsed to set
	 */
	public void setPlugUsed(int plugUsed) {
		this.plugUsed = plugUsed;
	}
	/**
	 * @return the startRechargingTime
	 */
	public float getStartRechargingTime() {
		return startRechargingTime;
	}
	/**
	 * @param startRechargingTime the startRechargingTime to set
	 */
	public void setStartRechargingTime(float startRechargingTime) {
		this.startRechargingTime = startRechargingTime;
	}
	

}
