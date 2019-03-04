import java.util.ArrayList;

/**
 * Class that subdivide the customer set assigning a charging station
 * where EV will go
 */

/**
 * @author Mauro
 *
 */
public class Cluster {
	/**
	 * Customer set 
	 */
	private ArrayList<NodeCustomer> customers;
	/**
	 * Recharger node assigned
	 */
	private NodeRecharger rechargingStation;
	/**
	 * Default constructor
	 */
	public Cluster() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param customers
	 * @param rechargingStation
	 */
	public Cluster(ArrayList<NodeCustomer> customers, NodeRecharger rechargingStation) {
		super();
		this.customers = customers;
		this.rechargingStation = rechargingStation;
	}
	/**
	 * @return the customers
	 */
	public ArrayList<NodeCustomer> getCustomers() {
		return customers;
	}
	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(ArrayList<NodeCustomer> customers) {
		this.customers = customers;
	}
	/**
	 * @return the rechargingStation
	 */
	public NodeRecharger getRechargingStation() {
		return rechargingStation;
	}
	/**
	 * @param rechargingStation the rechargingStation to set
	 */
	public void setRechargingStation(NodeRecharger rechargingStation) {
		this.rechargingStation = rechargingStation;
	}

}
