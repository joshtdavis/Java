public class ANode implements Comparable{
	
	private int row, col, f, g, h, type;
	private ANode parent;
   
	public ANode(int r, int c, int t){
		row = r;
		col = c;
		type = t;
		parent = null;
		//type 0 is traverseable, 1 is not
	}
	
	//mutator methods to set values
	public void setF(){
		f = g + h;
	}
	public void setG(int value){
		g = value;
	}
	public void setH(int value){
		h = value;
	}
	public void setParent(ANode n){
		parent = n;
	}
   
   public int compareTo(Object n){
      ANode in = (ANode) n;
      return getF () - in.getF ();
   }
      
	
	//accessor methods to get values
	public int getF(){
		return f;
	}
	public int getG(){
		return g;
	}
	public int getH(){
		return h;
	}
	public ANode getParent(){
		return parent;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	
	public boolean equals(Object in){
		//typecast to Node
		ANode n = (ANode) in;
		
		return row == n.getRow() && col == n.getCol();
	}
   
	public String toString(){
		return "Node: " + row + "_" + col;
	}
	
}
