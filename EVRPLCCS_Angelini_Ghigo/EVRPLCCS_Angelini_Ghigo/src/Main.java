import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;

/**
 * 
 */

/**
 * @author Mauro
 *
 */
public class Main {
	/**
	 * 
	 */
	public static NodeDepot depot;
	/**
	 * 
	 */
	public static ArrayList<NodePosition> nodes;
	/**
	 * 
	 */
	public static ArrayList<NodeCustomer> customers;
	/**
	 * 
	 */
	public static ArrayList<NodeRecharger> chargerNodes;
	/**
	 * 
	 */
	public static ArrayList<ElectricVehicle> vehicles;
	/**
	 * 
	 */
	public static ArrayList<ArrayList<Float>> nodeToNode;
	/**
	 * 
	 */
	public static ArrayList<Cluster> clusterSet;
	/**
	 * 
	 */
	public static ArrayList<OutputStream> list;
	/**
	 * 
	 */
	static int distCost = 0;
	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String istance = null;
		
		ArrayList<Solution> clusterObj = new ArrayList<Solution>();
		for(int i= 0; i<3; i++)
		{
			Solution sol = new Solution();
			sol.setBestObj(Integer.MAX_VALUE);
			clusterObj.add(sol);
		}
		
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0;
		
		long exStartTime = System.currentTimeMillis();
		while((System.currentTimeMillis() - exStartTime)<= Integer.parseInt(args[1])*1000) 
		{
			InputReader reader= new InputReader();
			istance= args[0];
			
			nodes= new ArrayList<NodePosition>();
			chargerNodes= new ArrayList<NodeRecharger>();
			customers= new ArrayList<NodeCustomer>();
			vehicles= new ArrayList<ElectricVehicle>();
			depot= new NodeDepot();
			clusterSet= new ArrayList<Cluster>();
			
			reader.ImportInputData(istance, depot, nodes, chargerNodes, customers, vehicles);
			nodeToNode= reader.distanceMatrixNodeToNode(nodes);
			
			distCost = vehicles.get(0).getDistCost();
			
		
			
			for(int k=0;k<chargerNodes.size();k++) {
				
				if(chargerNodes.get(k).getId()==0)
						continue;
				ArrayList<NodeCustomer> c = null;
				c= divisionData(k);
				Cluster cluster = new Cluster(c, chargerNodes.get(k));
				clusterSet.add(cluster);
			}		
			
			list= new ArrayList<OutputStream>();
			
			MetaHeuristic h= new MetaHeuristic();
			h.Start(depot, chargerNodes, vehicles, nodeToNode, list, clusterSet, clusterObj, exStartTime);
		}
		
		long stopTime = System.currentTimeMillis();
	    elapsedTime = stopTime - startTime;
	    
		float totalObj= 0;
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("LOCAL OPTIMUM:");
		ArrayList<OutputWriter> OutPrint = new ArrayList<OutputWriter>();
		for(Solution sol : clusterObj)
		{
			
			if(sol.getBestList()!=null)
			{
				OutPrint.addAll(generateoutput(sol, customers, chargerNodes)); 
				totalObj += sol.getBestObj();
				System.out.println("best found @ " + sol.getObjTime() + " ms");
				System.out.println("obj: " + sol.getBestObj());
				for(int i1=0;i1<sol.getBestList().size();i1++) {
					System.out.print("(" + sol.getBestList().get(i1).getVehicleId() + ")" + sol.getBestList().get(i1).getCustomerId() + " --> "  + sol.getBestList().get(i1).getArrivalTime() + ", ");
				}
			}
			
			System.out.println("--------------");
		}
		System.out.println("OBJ: " + totalObj);
		
		if(!OutPrint.isEmpty())
		{
			PrintCsv(OutPrint, clusterObj,  totalObj, istance.substring(0, istance.length()-4), distCost);
			OutputCsv(totalObj, clusterObj, elapsedTime, istance);
		}
		
	}
	/**
	 * 
	 */
	public static ArrayList<OutputWriter> generateoutput(Solution sol, ArrayList<NodeCustomer> customers, ArrayList<NodeRecharger> chargers){
		
		ArrayList<OutputWriter>OutPrint = new ArrayList<OutputWriter>();
		//System.out.println("clienti dim" + customers.size());
		OutputWriter o = null;
		ArrayList<OutputStream> tuples = sol.getBestList();
		//System.out.println("tuples dim" + tuples.size());
		for(int i=0; i<tuples.size(); i++)
		{
			for(NodeCustomer c : customers)
			{
				if(i==0 && tuples.get(i).getCustomerId() == c.getId())
				{
					
					o = new OutputWriter(tuples.get(i).getVehicleId() , 0, c.getId() , (float)nodeToNode.get(0).get(c.getId()), c.getR() , c.getD(), c.getServiceTime(), c.getDemand(),  tuples.get(i).getArrivalTime(), tuples.get(i).getArrivalBattery(), tuples.get(i).getArrivalCapacity(), (float)0, 0, 0);
					OutPrint.add(o);
					break;
				}
				else if(tuples.get(i).getCustomerId() == c.getId())
				{
					
					o = new OutputWriter(tuples.get(i).getVehicleId(), tuples.get(i-1).getCustomerId(), c.getId(), (float)nodeToNode.get(tuples.get(i-1).getCustomerId()).get(c.getId()), c.getR(), c.getD(), c.getServiceTime(), c.getDemand(),  tuples.get(i).getArrivalTime(), tuples.get(i).getArrivalBattery(), tuples.get(i).getArrivalCapacity(), (float)0, 0, 0);
					OutPrint.add(o);
					break;
				}
				
				else{
					boolean found = false;
					for(NodeRecharger r : chargers)
					{
						if(tuples.get(i).getCustomerId() == r.getId())
						{
							if(i==0){
								o = new OutputWriter(tuples.get(i).getVehicleId(), 0, r.getId(), (float)nodeToNode.get(0).get(r.getId()), 0, 0, 0, 0,  tuples.get(i).getArrivalTime(), tuples.get(i).getArrivalBattery(), tuples.get(i).getArrivalCapacity(), tuples.get(i).getRechargingTime(), 1, tuples.get(i).getStartRechargingTime());
							}else{
								o = new OutputWriter(tuples.get(i).getVehicleId(), tuples.get(i-1).getCustomerId(), r.getId(), (float)nodeToNode.get(tuples.get(i-1).getCustomerId()).get(r.getId()), 0, 0, 0, 0,  tuples.get(i).getArrivalTime(), tuples.get(i).getArrivalBattery(), tuples.get(i).getArrivalCapacity(), tuples.get(i).getRechargingTime(), 1, tuples.get(i).getStartRechargingTime());
							}
							
							OutPrint.add(o);
							found = true;
							break;
						}
					}
					if(found)
					{
						break;
					}
					
				}
				
			}
		}
		return OutPrint;
	}
	/**
	 * 
	 */
	public static ArrayList<NodeCustomer> divisionData(int k) {
		
		ArrayList<NodeCustomer> cluster= new ArrayList<NodeCustomer>();
		for(int j=1;j<=customers.size();j++) {
			if(customers.size()>=41)
			{
				if(nodeToNode.get(j).get(chargerNodes.get(k).getId()) <= 15) {
					cluster.add(customers.get(j-1));
				}
			}
			else
			{
				if(nodeToNode.get(j).get(chargerNodes.get(k).getId()) <= 20) {
					cluster.add(customers.get(j-1));
				}
			}
			
		}
		return cluster;
	}
	/**
	 * 
	 */
	public static void PrintCsv(ArrayList<OutputWriter> output, ArrayList<Solution> clusterObj, float obj,  String filename, int distCost)
	{
		try {
			
			float objTime = 0;
			for(Solution s : clusterObj)
			{
				if(s.getObjTime()>=objTime)
				{
					objTime = s.getObjTime();
				}
			}
			
			String[] header = {"Vehicle", "Orig","Dest","Dist","Rel","Dead","ServTime","DemDest","ArrTimeDest","ArrBattDest","ArrLoadDest", "RecTime", "PlugUsed", "StartRecharging" }; 
			PrintWriter pw = new PrintWriter("output//" + filename + "_Result.csv");
			StringBuilder sb = new StringBuilder();
			
			sb.append("Obj");
			sb.append(';');
			sb.append(String.format(Locale.ITALIAN, "%f", obj*(float)distCost));
			sb.append('\n');
			
			sb.append("Time");
			sb.append(';');
			sb.append(String.format(Locale.ITALIAN, "%f", objTime));
			sb.append('\n');
			
			for(String s : header)
			{
				sb.append(s);
				sb.append(';');
			}
			
			sb.append('\n');
			
			int vehId = 1;
			
			if(!output.isEmpty())
			{
				for(int j = 0 ; j<output.size(); j++)
				{
					OutputWriter o = output.get(j);
					if(j>0 && output.get(j).getVehicle()!=output.get(j-1).getVehicle())
					{
						vehId++;
					}
					sb.append(vehId);
					sb.append(';');
					sb.append(o.getOrigin());
					sb.append(';');
					sb.append(o.getDestination());
					sb.append(';');
					sb.append(String.format(Locale.ITALIAN, "%f", o.getDistance()));
					sb.append(';');
					sb.append(String.format(Locale.ITALIAN, "%f", o.getRel()));
					sb.append(';');
					sb.append(String.format(Locale.ITALIAN, "%f", o.getDeadline()));
					sb.append(';');
					sb.append(String.format(Locale.ITALIAN, "%f", o.getServTime()));
					sb.append(';');
					sb.append(o.getDemDest());
					sb.append(';');
					sb.append(String.format(Locale.ITALIAN, "%f", o.getArrivalTimeDestination()));
					sb.append(';');
					sb.append(String.format(Locale.ITALIAN, "%f", o.getArrivalBatteryDestination()));
					sb.append(';');
					sb.append((int)o.getArrivalLoadDestination());
					sb.append(';');
					sb.append(String.format(Locale.ITALIAN, "%f", o.getRechargingTime()));
					sb.append(';');
					sb.append(o.getPlugUsed());
					sb.append(';');
					sb.append(String.format(Locale.ITALIAN, "%f", o.getStartRechargingTime() ));
					sb.append('\n');
					
				}
			}
			
			pw.write(sb.toString());
	        pw.close();
	        System.out.println("CSV file printed!");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 */
	public static void OutputCsv(float totalObj, ArrayList<Solution> clusterObj, long elapsedTime, String filename) {
		float objTime = 0;
		for(Solution s : clusterObj)
		{
			if(s.getObjTime()>=objTime)
			{
				objTime = s.getObjTime();
			}
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter("output//output.csv", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		StringBuilder sb = new StringBuilder();
		sb.append(filename);
		sb.append(';');
		sb.append(elapsedTime/1000);
		sb.append(';');
		sb.append(objTime/1000);
		sb.append(';');
		sb.append(String.format(Locale.ITALIAN, "%f", totalObj*(float)distCost));
		
		
		pw.write(sb.toString());
		pw.println();
        pw.close();
        System.out.println("output CSV file printed!");
	}
}
