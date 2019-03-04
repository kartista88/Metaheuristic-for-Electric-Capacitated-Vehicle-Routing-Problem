/**
 * NodeRecharger memorise all information about a Recharging station
 */

/**
 * @author Mauro
 *
 */
public class NodeRecharger {

	/**
	 * Charging Station identifier
	 */
	private int id;	
	/**
	 * Number of plug
	 */
	private int numRec; 		
	/**
	 * Charging Station status
	 */
	private boolean busy; 	
	/**
	 * 
	 */
	private float maxBattery;	
	/**
	 * Default constructor
	 */
	public NodeRecharger() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor with parameter taken by input
	 */
	public NodeRecharger(int id, int numRec) {
		this.id= id;
		this.numRec= numRec;
		this.busy= false;
		
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
	 * @return the numRec
	 */
	public int getNumRec() {
		return numRec;
	}
	/**
	 * @param numRec the numRec to set
	 */
	public void setNumRec(int numRec) {
		this.numRec = numRec;
	}
	/**
	 * @return the busy
	 */
	public boolean isBusy() {
		return busy;
	}
	/**
	 * @param busy the busy to set
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	/**
	 * @return the maxBattery
	 */
	public float getMaxBattery() {
		return maxBattery;
	}
	/**
	 * @param maxBattery the maxBattery to set
	 */
	public void setMaxBattery(float maxBattery) {
		this.maxBattery = maxBattery;
	}

}
