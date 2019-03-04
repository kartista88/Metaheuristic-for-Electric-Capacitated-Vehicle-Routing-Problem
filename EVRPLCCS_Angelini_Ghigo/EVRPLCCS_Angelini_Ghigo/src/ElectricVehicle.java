/**
 * 
 */

/**
 * @author Mauro
 *
 */
public class ElectricVehicle {
	
	/**
	 * Default constructor
	 */
	private int id;
	/**
	 * Default constructor
	 */
	private int tMax;
	/**
	 * Default constructor
	 */
	private int capacity;
	/**
	 * Default constructor
	 */
	private int speed;
	/**
	 * Default constructor
	 */
	private int distCost;
	/**
	 * Default constructor
	 */
	private float battery;
	/**
	 * Default constructor
	 */
	private float ro;
	/**
	 * Default constructor
	 */
	private float alpha;
	/**
	 * Default constructor
	 */
	private float travelTime;
	/**
	 * Default constructor
	 */
	private int currentNodeId;
	/**
	 * Default constructor
	 */
	private boolean goToDepot;
	/**
	 * Default constructor
	 */
	private float maxBatt;
	/**
	 * Default constructor
	 */
	public ElectricVehicle() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param tMax
	 * @param capacity
	 * @param speed
	 * @param distCost
	 * @param battery
	 * @param ro
	 * @param alpha
	 * @param maxBatt
	 */
	public ElectricVehicle(int id, int tMax, int capacity, int speed, int distCost, float battery, float ro,
			float alpha, float maxBatt) {
		super();
		this.id = id;
		this.tMax = tMax;
		this.capacity = capacity;
		this.speed = speed;
		this.distCost = distCost;
		this.battery = battery;
		this.ro = ro;
		this.alpha = alpha;
		this.maxBatt = maxBatt;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the tMax
	 */
	public int gettMax() {
		return tMax;
	}
	/**
	 * @param tMax the tMax to set
	 */
	public void settMax(int tMax) {
		this.tMax = tMax;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * @return the distCost
	 */
	public int getDistCost() {
		return distCost;
	}
	/**
	 * @param distCost the distCost to set
	 */
	public void setDistCost(int distCost) {
		this.distCost = distCost;
	}
	/**
	 * @return the battery
	 */
	public float getBattery() {
		return battery;
	}
	/**
	 * @param battery the battery to set
	 */
	public void setBattery(float battery) {
		this.battery = battery;
	}
	/**
	 * @return the ro
	 */
	public float getRo() {
		return ro;
	}
	/**
	 * @param ro the ro to set
	 */
	public void setRo(float ro) {
		this.ro = ro;
	}
	/**
	 * @return the alpha
	 */
	public float getAlpha() {
		return alpha;
	}
	/**
	 * @param alpha the alpha to set
	 */
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
	/**
	 * @return the travelTime
	 */
	public float getTravelTime() {
		return travelTime;
	}
	/**
	 * @param travelTime the travelTime to set
	 */
	public void setTravelTime(float travelTime) {
		this.travelTime = travelTime;
	}
	/**
	 * @return the currentNodeId
	 */
	public int getCurrentNodeId() {
		return currentNodeId;
	}
	/**
	 * @param currentNodeId the currentNodeId to set
	 */
	public void setCurrentNodeId(int currentNodeId) {
		this.currentNodeId = currentNodeId;
	}
	/**
	 * @return the goToDepot
	 */
	public boolean isGoToDepot() {
		return goToDepot;
	}
	/**
	 * @param goToDepot the goToDepot to set
	 */
	public void setGoToDepot(boolean goToDepot) {
		this.goToDepot = goToDepot;
	}
	/**
	 * @return the maxBatt
	 */
	public float getMaxBatt() {
		return maxBatt;
	}
	/**
	 * @param maxBatt the maxBatt to set
	 */
	public void setMaxBatt(float maxBatt) {
		this.maxBatt = maxBatt;
	}

}
