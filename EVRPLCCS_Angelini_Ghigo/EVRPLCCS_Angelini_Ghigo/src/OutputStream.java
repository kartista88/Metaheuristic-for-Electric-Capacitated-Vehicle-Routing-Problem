/**
 * 
 */

/**
 * @author Mauro
 *
 */
public class OutputStream {
	
	/**
	 * 
	 */
	private int customerId;
	/**
	 * 
	 */
	private float arrivalTime;
	/**
	 * 
	 */
	private int vehicleId;
	/**
	 * 
	 */
	private float arrivalBattery;
	/**
	 * 
	 */
	private float arrivalCapacity;
	/**
	 * 
	 */
	private float rechargingTime;
	/**
	 * 
	 */
	private float startRechargingTime;
	/**
	 * 
	 */
	public OutputStream() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param customerId
	 * @param arrivalTime
	 * @param vehicleId
	 * @param arrivalBattery
	 * @param arrivalCapacity
	 * @param rechargingTime
	 * @param startRechargingTime
	 */
	public OutputStream(int customerId, float arrivalTime, int vehicleId, float arrivalBattery, float arrivalCapacity,
			float rechargingTime, float startRechargingTime) {
		super();
		this.customerId = customerId;
		this.arrivalTime = arrivalTime;
		this.vehicleId = vehicleId;
		this.arrivalBattery = arrivalBattery;
		this.arrivalCapacity = arrivalCapacity;
		this.rechargingTime = rechargingTime;
		this.startRechargingTime = startRechargingTime;
	}
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the arrivalTime
	 */
	public float getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(float arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * @return the vehicleId
	 */
	public int getVehicleId() {
		return vehicleId;
	}
	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	/**
	 * @return the arrivalBattery
	 */
	public float getArrivalBattery() {
		return arrivalBattery;
	}
	/**
	 * @param arrivalBattery the arrivalBattery to set
	 */
	public void setArrivalBattery(float arrivalBattery) {
		this.arrivalBattery = arrivalBattery;
	}
	/**
	 * @return the arrivalCapacity
	 */
	public float getArrivalCapacity() {
		return arrivalCapacity;
	}
	/**
	 * @param arrivalCapacity the arrivalCapacity to set
	 */
	public void setArrivalCapacity(float arrivalCapacity) {
		this.arrivalCapacity = arrivalCapacity;
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
