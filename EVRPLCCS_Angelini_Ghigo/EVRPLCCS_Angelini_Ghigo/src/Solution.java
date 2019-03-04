import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Mauro
 *
 */
public class Solution {
	
	/**
	 * 
	 */
	private ArrayList<OutputStream> bestList;
	/**
	 * 
	 */
	private float bestObj;
	/**
	 * 
	 */
	private float objTime;
	/**
	 * 
	 */
	public Solution() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param bestList
	 * @param bestObj
	 * @param objTime
	 */
	public Solution(ArrayList<OutputStream> bestList, float bestObj, float objTime) {
		super();
		this.bestList = bestList;
		this.bestObj = bestObj;
		this.objTime = objTime;
	}
	/**
	 * @return the bestList
	 */
	public ArrayList<OutputStream> getBestList() {
		return bestList;
	}
	/**
	 * @param bestList the bestList to set
	 */
	public void setBestList(ArrayList<OutputStream> bestList) {
		this.bestList = bestList;
	}
	/**
	 * @return the bestObj
	 */
	public float getBestObj() {
		return bestObj;
	}
	/**
	 * @param bestObj the bestObj to set
	 */
	public void setBestObj(float bestObj) {
		this.bestObj = bestObj;
	}
	/**
	 * @return the objTime
	 */
	public float getObjTime() {
		return objTime;
	}
	/**
	 * @param objTime the objTime to set
	 */
	public void setObjTime(float objTime) {
		this.objTime = objTime;
	}

}
