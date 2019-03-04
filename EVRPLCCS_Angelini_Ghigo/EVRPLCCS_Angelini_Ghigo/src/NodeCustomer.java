/**
 * NodeCustomer memorise all information about a Customer
 */

/**
 * @author Mauro
 *
 */
public class NodeCustomer {
	/**
	 * Customer identifier
	 */
	private int id;
	/**
	 * Customer demand
	 */
	private int demand;
	/**
	 * Customer service time
	 */
	private float serviceTime;
	/**
	 * Customer ready time
	 */
	private float r;
	/**
	 * Customer deadline 
	 */
	private float d;
	/**
	 * 
	 */
	private Float avg;
	/**
	 * 
	 */
	private int summedWeight;
	/**
	 * Default constructor
	 */
	public NodeCustomer() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param demand
	 * @param serviceTime
	 * @param r
	 * @param d
	 */
	public NodeCustomer(int id, int demand, float serviceTime, float r, float d) {
		super();
		this.id = id;
		this.demand = demand;
		this.serviceTime = serviceTime;
		this.r = r;
		this.d = d;
	}
	/**
	 * @param id
	 * @param demand
	 * @param serviceTime
	 * @param r
	 * @param d
	 * @param avg
	 * @param summedWeight
	 */
	public NodeCustomer(int id, int demand, float serviceTime, float r, float d, Float avg, int summedWeight){
		super();
		this.id = id;
		this.demand = demand;
		this.serviceTime = serviceTime;
		this.r = r;
		this.d = d;
		this.avg = avg;
		this.summedWeight = summedWeight;
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
	 * @return the demand
	 */
	public int getDemand() {
		return demand;
	}
	/**
	 * @param demand the demand to set
	 */
	public void setDemand(int demand) {
		this.demand = demand;
	}
	/**
	 * @return the serviceTime
	 */
	public float getServiceTime() {
		return serviceTime;
	}
	/**
	 * @param serviceTime the serviceTime to set
	 */
	public void setServiceTime(float serviceTime) {
		this.serviceTime = serviceTime;
	}
	/**
	 * @return the r
	 */
	public float getR() {
		return r;
	}
	/**
	 * @param r the r to set
	 */
	public void setR(float r) {
		this.r = r;
	}
	/**
	 * @return the d
	 */
	public float getD() {
		return d;
	}
	/**
	 * @param d the d to set
	 */
	public void setD(float d) {
		this.d = d;
	}
	/**
	 * @return the avg
	 */
	public Float getAvg() {
		return avg;
	}
	/**
	 * @param avg the avg to set
	 */
	public void setAvg(Float avg) {
		this.avg = avg;
	}
	/**
	 * @return the summedWeight
	 */
	public int getSummedWeight() {
		return summedWeight;
	}
	/**
	 * @param summedWeight the summedWeight to set
	 */
	public void setSummedWeight(int summedWeight) {
		this.summedWeight = summedWeight;
	}
	

}
