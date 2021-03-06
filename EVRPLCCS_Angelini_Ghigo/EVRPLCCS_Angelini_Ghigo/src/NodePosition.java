/**
 * 
 */

/**
 * @author Mauro
 *
 */
public class NodePosition {
	
	
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private float x;
	/**
	 * 
	 */
	private float y;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	public NodePosition() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param x
	 * @param y
	 * @param type
	 */
	public NodePosition(int id, float x, float y, String type) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.type = type;
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
	 * @return the x
	 */
	public float getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
