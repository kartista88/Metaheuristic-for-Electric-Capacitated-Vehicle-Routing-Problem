import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 */

/**
 * @author Mauro
 *
 */
public class MetaHeuristic {

	/**
	 * 
	 */
	private static NodeDepot depot;
	/**
	 * 
	 */
	private static ArrayList<NodeCustomer> customers;
	/**
	 * 
	 */
	private static ArrayList<NodeRecharger> chargerNodes;
	/**
	 * 
	 */
	private static ArrayList<ElectricVehicle> vehicles;
	/**
	 * 
	 */
	private static ArrayList<ArrayList<Float>> nodeToNode;
	/**
	 * 
	 */
	private static ArrayList<OutputStream> list;
	/**
	 * 
	 */
	private static float totalDist;
	/**
	 * Default constructor
	 */
	public MetaHeuristic() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Default constructor
	 */
	public void Start(NodeDepot depot,  ArrayList<NodeRecharger> chargerNodes, ArrayList<ElectricVehicle> vehicles, ArrayList<ArrayList<Float>> nodeToNode, ArrayList<OutputStream> list, ArrayList<Cluster> clusterSet, ArrayList<Solution> clusterObj, long exStartTime) {
		this.depot= depot;
		this.chargerNodes= chargerNodes;
		this.vehicles= vehicles;
		this.nodeToNode= nodeToNode;
		this.list= list;
		this.totalDist= 0;


		
		for(int k=0;k<clusterSet.size();k++) {
			this.customers= clusterSet.get(k).getCustomers();
			this.list= new ArrayList();
			totalDist = 0;
			
			for(int i=0;i<2;i++) {
				int start=0;
				
				ElectricVehicle van= vehicles.remove(0);
				//System.out.println(van.getId());

		
				while(true) {
					
					
					start= InitRouting(van, clusterSet.get(k).getRechargingStation());			
						if(start==0) {
							
							break;
						}
				}
				
				
				if(this.customers.size()==0) {
					
					if(!checkCollision(this.list)){
						
						System.out.print("[");
						for(int i1=0;i1<this.list.size();i1++) {
							System.out.print("(" + this.list.get(i1).getVehicleId() + ")" + this.list.get(i1).getCustomerId() + " --> "  + this.list.get(i1).getArrivalTime() + ", ");
						}
						System.out.println("]");
						System.out.println(totalDist);
						if((this.list.get(0).getVehicleId()) == 1)
						{
							if(totalDist < clusterObj.get(0).getBestObj())
							{
								clusterObj.get(0).setBestList(this.list);
								clusterObj.get(0).setBestObj(totalDist);
								clusterObj.get(0).setObjTime(System.currentTimeMillis() - exStartTime);
								System.out.println("NUOVO BEST TROVATO DI " + (this.list.get(0).getVehicleId()) );
								System.out.println("-----------------");
								
							}
							break;
						}
						else if(this.list.get(0).getVehicleId() == 3 || this.list.get(0).getVehicleId() == 2)
						{
							if(totalDist < clusterObj.get(1).getBestObj())
							{
								clusterObj.get(1).setBestList(this.list);
								clusterObj.get(1).setBestObj(totalDist);
								clusterObj.get(1).setObjTime(System.currentTimeMillis() - exStartTime);
								System.out.println("NUOVO BEST TROVATO DI " + (this.list.get(0).getVehicleId()) );
								System.out.println("-----------------");
								
							}
							break;
						}
						
						else if((this.list.get(0).getVehicleId()) == 5)
						{
							if(totalDist < clusterObj.get(1).getBestObj())
							{
								clusterObj.get(2).setBestList(this.list);
								clusterObj.get(2).setBestObj(totalDist);
								clusterObj.get(2).setObjTime(System.currentTimeMillis() - exStartTime);
								System.out.println("NUOVO BEST TROVATO DI " + (this.list.get(0).getVehicleId()) );
								System.out.println("-----------------");
								
							}
							break;
						}
					}
					
				}	
			}
			
			
			
			
			
		}
		
	}
	/**
	 * Default constructor
	 */
	private boolean checkCollision(ArrayList<OutputStream> list) {
		// TODO Auto-generated method stub
		ArrayList<Float> startChg = new ArrayList<Float>();
		ArrayList<Float> endChg = new ArrayList<Float>();
		for(OutputStream t : list){
			if(t.getRechargingTime()!=0)
			{
				startChg.add(t.getArrivalTime());
				endChg.add(t.getArrivalTime() + t.getRechargingTime());
			}	
		}
		for(int i=0; i<startChg.size()-1; i++)
		{
			for(int j=i+1; j<startChg.size(); j++)
			{
				if(startChg.get(j)>startChg.get(i) && startChg.get(j)<endChg.get(i)){
					//System.out.println("scarto");
					return true;
					
				}
				else if(endChg.get(j)>startChg.get(i) && endChg.get(j)<endChg.get(i)){
					//System.out.println("scarto");
					return true;
				}
				else if(startChg.get(j)<startChg.get(i) && endChg.get(j)>endChg.get(i)){
					//System.out.println("scarto");
					return true;
				}	
			}
		}
		return false;
	}
	/**
	 * Default constructor
	 */
	public static int InitRouting(ElectricVehicle vehicle, NodeRecharger charger){
		ElectricVehicle van= vehicle;

		int currentVisitedNode= van.getCurrentNodeId();
		
		float battery = van.getBattery();
		float executablePath = battery / van.getRo();


		ArrayList<NodeCustomer> executableCustomers = new ArrayList<NodeCustomer>();

		NodeRecharger cStation = charger;	
		
		float nodeChargeDist= getDistanceNN(currentVisitedNode, cStation.getId());
		
		if(van.getCurrentNodeId()==0 && (van.getId()==1 || van.getId()==3 || van.getId()==5))
		{
			return goToCharge(van, nodeChargeDist, cStation);
			//System.out.println("CARICO QUANDO ARRIVO IN CLUSTER");
		}
		
		
		
		if(van.isGoToDepot()==true) {
			return goToDepot(van);
		}
		
		Map<Integer, Float> Cdistance= new HashMap<Integer, Float>();
		
		if(customers.size()==0) {
		
			float distanceToDepot= getDistanceNN(0, van.getCurrentNodeId());
			if(distanceToDepot*van.getRo()<=van.getBattery()) {
				return goToDepot(van);
			}
			else {
				return goToCharge(van, nodeChargeDist, cStation);
			}
		}
		
		else if(customers.size()>0)
		{
			
			//ho ancora clienti da servire
			for(int i=0;i<customers.size();i++) {
				NodeCustomer c= customers.get(i);
				float distance= getDistanceNN(currentVisitedNode, c.getId());
				Cdistance.put(c.getId(), distance);
			}
			
			Random rand= new Random();
			ArrayList<NodeCustomer> exec = new ArrayList<NodeCustomer>();
	
				for(int i=0;i<customers.size();i++){
					NodeCustomer c= customers.get(i);
					
					float currToCustomer= Cdistance.get(c.getId());
					float customerToCharger= getDistanceNN(c.getId(), cStation.getId());
					// raggiungibili per autonomia
					if(currToCustomer + customerToCharger <= executablePath){
							executableCustomers.add(c);
					}
				}
	
			if(executableCustomers.size()!=0) 
			{	
				// ho trovato clienti eseguibili per autonomia 
				NodeCustomer customer = null;
				float travelTime = 0;
				float travelKm = 0;
	
				for(int i=0;i<executableCustomers.size();i++){
					NodeCustomer c= executableCustomers.get(i);
					float totalKm= Cdistance.get(c.getId());
					float totalTime = totalKm/van.getSpeed();
					//if (van.getTravelTime() + totalTime + c.getServiceTime() <= c.d){
					if (van.getTravelTime() + totalTime <= c.getD()){
						exec.add(c);	
					}
				}
				// qui da quelli raggiungibili per autonomia restringo a quelli raggiugnibili per deadline
				
				if(exec.size()!=0) {
					customer = exec.get(rand.nextInt(exec.size()));	
					//customer = RandomWeightedPick(exec);
					//System.out.println(customer.id);
					travelKm = Cdistance.get(customer.getId());
					travelTime = travelKm/van.getSpeed();
					//qui prendo randoomicamente fra quelli selezioanti prima per deadline e autonomia 
				}
				
				if(customer==null) {
					//se non ho fattibili vado a casa
					if(getDistanceNN(0, van.getCurrentNodeId())*van.getRo() <= van.getBattery()){
						return goToDepot(van);
					}
					else
					{
						return goToCharge(van, nodeChargeDist, cStation);
					}
					
				}
				
				else 
				{
					//qui ho un nodo seleionato
					float distanceToDepot= getDistanceNN(0, customer.getId());
					int residualCapacity= van.getCapacity() - customer.getDemand();
					
					if(van.getTravelTime()+travelTime+customer.getServiceTime()+distanceToDepot/van.getSpeed() <= van.gettMax() && residualCapacity>=0) {					
						float arrtime = 0;
						if(van.getTravelTime()+travelTime <= customer.getR()){
							van.setTravelTime(customer.getServiceTime() + customer.getR());
							arrtime = van.getTravelTime()+travelTime;
						}
						else{
							van.setTravelTime(van.getTravelTime()+travelTime+customer.getServiceTime());
							arrtime = van.getTravelTime()+travelTime;
						}
						
						van.setCapacity(residualCapacity);
						van.setBattery(van.getBattery() - travelKm*van.getRo());
						customers.remove(customer);
	
						
						totalDist += travelKm;
						
						
						if(van.getCurrentNodeId()!=customer.getId()){
							OutputStream t= new OutputStream(customer.getId(),  van.getTravelTime()-customer.getServiceTime(), van.getId(), van.getBattery(), van.getCapacity(), 0, 0);
							list.add(t);
							van.setCurrentNodeId(customer.getId());
						}
						
						
						return van.getCurrentNodeId();
					}
					
					else if(van.getTravelTime()+travelTime+customer.getServiceTime()+distanceToDepot/van.getSpeed() > van.gettMax() || residualCapacity<0) {
						if(distanceToDepot*van.getRo()<=van.getBattery())
							return goToDepot(van);
						else {
							van.setGoToDepot(true);
							return goToCharge(van, nodeChargeDist, cStation);
						}
					}
				}
			}
			
			else {
				return goToCharge(van, nodeChargeDist, cStation);
			}
		}
		
		
		
		return van.getCurrentNodeId();
	}
	/**
	 * Default constructor
	 */
	private static int goToCharge(ElectricVehicle van, float nodeChargeDist, NodeRecharger cStation) {
		
		Random rand = new Random();
		
		float chgperc = 0;
		
		while(chgperc<0.5)
		{
			chgperc = (float)( van.getBattery()/van.getMaxBatt() + rand.nextFloat() * (1 - van.getBattery()/van.getMaxBatt()));
		}
		
		cStation.setBusy(true);
		van.setCurrentNodeId(cStation.getId());

		van.setBattery(van.getBattery() - nodeChargeDist*van.getRo());
		float arrbatt = van.getBattery();
		float kwhneed = van.getMaxBatt()*chgperc - van.getBattery();
		van.setTravelTime(van.getTravelTime() + nodeChargeDist/van.getSpeed());
		
		van.setBattery(van.getBattery() + kwhneed);
		
		
		
		OutputStream t;
		if(van.getCurrentNodeId()==0 && van.getId()%2==0)
		{
			t = new OutputStream(cStation.getId(), nodeChargeDist/van.getSpeed(), van.getId(), arrbatt, van.getCapacity(), kwhneed/van.getAlpha(), van.getTravelTime());
		}
		else{
			t= new OutputStream(cStation.getId(), van.getTravelTime(), van.getId(), arrbatt, van.getCapacity(), kwhneed/van.getAlpha(), van.getTravelTime());
		}
		
		van.setTravelTime(van.getTravelTime() + kwhneed/van.getAlpha());
		
		
		list.add(t);
		totalDist += nodeChargeDist;
		return van.getCurrentNodeId();		
	}
	/**
	 * Default constructor
	 */
	private static int goToDepot(ElectricVehicle van) {
		float distanceToDepot= getDistanceNN(0, van.getCurrentNodeId());
		
		van.setTravelTime(van.getTravelTime() + distanceToDepot/van.getSpeed());
		van.setBattery(van.getBattery() - distanceToDepot*van.getRo());	
		
		totalDist += distanceToDepot;
		
		van.setCurrentNodeId(0);
		OutputStream t= new OutputStream(0, van.getTravelTime(), van.getId(), van.getBattery(), van.getCapacity(), 0, 0);
		list.add(t);
		return van.getCurrentNodeId();
	}
	/**
	 * Default constructor
	 */
	private static Float getDistanceNN(int i, int id) {
		return nodeToNode.get(i).get(id);

	}
	/**
	 * Default constructor
	 */
	static class SortbyOpeningCustomerWindow implements Comparator<NodeCustomer>{
	    public int compare(NodeCustomer a, NodeCustomer b){
	    	return a.getAvg().compareTo(b.getAvg());
	    }
	}
	/**
	 * Default constructor
	 */
	public static NodeCustomer RandomWeightedPick(ArrayList<NodeCustomer> exec){
		Random rnd = new Random();
		NodeCustomer choosen = null;
		double r = rnd.nextDouble() * exec.get(exec.size()-1).getSummedWeight();
		for(int i=0; i<exec.size(); i++)
		{
			if(exec.get(i).getSummedWeight()>r)
			{
				choosen = exec.get(i);
				break;
			}
			else if (i>0 && exec.get(i-1).getSummedWeight() < r && exec.get(i).getSummedWeight() > r)
		    {
				choosen = exec.get(i);
		    	break;
		    }	
			else{
				choosen = exec.get(exec.size()-1);
				break;
			}
		}
		return choosen;
	}
}
