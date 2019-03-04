/**
 * 
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
/**
 * @author Mauro
 *
 */
public class InputReader {

	/**
	 * 
	 */
	public InputReader() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @throws FileNotFoundException 
	 * 
	 */
	public void ImportInputData(String istance, NodeDepot depot, ArrayList<NodePosition> nodes, ArrayList<NodeRecharger> chargerNodes, ArrayList<NodeCustomer> customers, ArrayList<ElectricVehicle> vehicles)  {
		String filename= istance;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner in= new Scanner(fileReader);
		in.useLocale(Locale.ENGLISH);
		
		in.nextLine(); //NODES
		in.nextLine(); //ID,X,Y,TYPE
		while(in.hasNextLine()){
			String next= in.next();
			
			
			if(!next.equals("RECHARGERS")){
				int id= Integer.parseInt(next);
				float x= in.nextFloat();
				float y= in.nextFloat();
				String type= in.next();
				NodePosition n= new NodePosition(id, x, y, type);
				nodes.add(n);
				
				
			}
			else
				break;
		}

		in.nextLine();
		in.nextLine();

		while(in.hasNextLine()){
			String next= in.next();

			if(!next.equals("CUSTOMERS")) {
				int id= Integer.parseInt(next);
				int numRec= in.nextInt();
				NodeRecharger cg= new NodeRecharger(id, numRec);
				chargerNodes.add(cg);
			}
			else 
				break;
		}
		
		//I customer hanno id da 1 a ..
		@SuppressWarnings("unused")
		String line;
		line= in.next();
		line= in.nextLine();
		while(in.hasNextLine()){
			String next= in.next();
			
			if(!next.equals("INSTDATA")) {
				int id= Integer.parseInt(next);
				int demand= in.nextInt();
				float serviceTime= in.nextFloat();
				float r= in.nextFloat();
				float d= in.nextFloat();
				int summedWeight = (int) (20 - (d - r));
				NodeCustomer c= new NodeCustomer(id, demand, serviceTime, r, d);
				c.setSummedWeight(summedWeight);
				customers.add(c);
			}
			else 
				break;
		}
		
		line= in.next();
		line= in.nextLine();
		int Tmax= in.nextInt();
		
		int numV= in.nextInt();
		int capacity=  in.nextInt();
		int speed= in.nextInt();
		int distCost= in.nextInt();
		int batt= in.nextInt();
		float ro= in.nextFloat();
		float alpha= in.nextFloat();

		for(int i=1;i<=numV;i++){
			ElectricVehicle v= new ElectricVehicle(i, Tmax, capacity, speed, distCost, batt , ro, alpha, batt);
			vehicles.add(v);
		}
		
		depot= new NodeDepot(nodes.get(0).getId(), nodes.get(0).getX(), nodes.get(0).getX());
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
	}
	/**
	 * 
	 */
	public ArrayList<ArrayList<Float>> distanceMatrixNodeToNode(ArrayList<NodePosition> nodes){
		ArrayList<ArrayList<Float>> nodetoNode= new ArrayList<ArrayList<Float>>();
		
		for(int i=0;i<nodes.size();i++){
			NodePosition c= nodes.get(i);
			ArrayList<Float> t = new ArrayList<Float>();
			
			for(int k=0;k<nodes.size();k++){
				NodePosition c1= nodes.get(k);
				float ed= (float) Math.sqrt(Math.pow((c.getX() - c1.getX()), 2) + Math.pow((c.getY() - c1.getY()), 2));
				t.add(ed);	
			}
			nodetoNode.add(t);
		}
		return nodetoNode;
	}
	

}
