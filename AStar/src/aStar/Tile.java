package aStar;

import java.util.Random;

public class Tile implements Comparable{
		
		private int row, col, g, h, type, print;
		private Tile parent;
	   
		public Tile(int r, int c){
			row = r;
			col = c;
			print = 0;
			Random rand = new Random();
			int randomNum = rand.nextInt(10);
			if(randomNum == 0){
				type = 1;
				print = 1;
			}
			parent = null;
		}
		public void setG(int value){
			g = value;
		}
		public void setH(int value){
			h = value;
		}
		public void setParent(Tile n){
			parent = n;
		}
	   
	   public int compareTo(Object n){
	      Tile in = (Tile) n;
	      return getF () - in.getF ();
	   }
		public int getF(){
			return g + h;
		}
		public int getG(){
			return g;
		}
		public int getH(){
			return h;
		}
		public Tile getParent(){
			return parent;
		}
		public int getRow(){
			return row;
		}
		public int getCol(){
			return col;
		}
		
		public boolean passable(){
			return type==0;
		}
		
		public void setPrint(){
			print = 9;
		}
		
		public void printTile(){
			System.out.print(print + " ");
		}
		
		public boolean equals(Object in){
			//typecast to Tile
			Tile n = (Tile) in;
			
			return row == n.getRow() && col == n.getCol();
		}
	   
		public String toString(){
			return "Tile: " + row + "_" + col;
		}
		
}
