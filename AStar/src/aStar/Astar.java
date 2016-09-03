package aStar;

import java.util.Scanner;

public class Astar {
	static TileGrid world;
	static MinHeap openList;
	static HashTable closedList;
	static Tile start;
	static Tile end;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialize();
		boolean running = true;
		while(running){
			initialize();
			grabUserInput();
			runAstar();
			emptyStuff();
			Scanner k = new Scanner(System.in);
			System.out.println("If you wish to continue press y: ");
			if( !( k.nextLine().equals("y") || k.next().equals("y") ) ){
				running = false;
			}
		}
	}

	private static void emptyStuff() {
		openList.clear();
		closedList.clear();
	}

	private static void runAstar() {
		// TODO Auto-generated method stub
		findPath(start, end);
		world.printGrid();
	   }
	   
	   public static void findPath(Tile start, Tile end){
	   
	      openList = new MinHeap(world.getGrid().length,world.getGrid()[0].length);
	      closedList = new HashTable(world.getGrid().length,world.getGrid()[0].length);
	      
	      //add starting node to open list
	      openList.add(start);
	      
	      boolean keepSearching = true;
	      
	      //main loop body of A*
	      while(keepSearching){
	         
	         Tile current;
	         
	         //pop best move off of open list
	         if(openList.size() == 0){
	            keepSearching = false;
	            System.out.println("No Path could be found");
	            current = null;
	            break;
	         }else{
	            current = openList.remove();
	         }
	         
	         
	         //check for goal
	         if(current.equals(end)){               //found path!
	            System.out.println("Path found? ");
	            Tile n = current;
	            while(n.getParent() != null){
	               System.out.println(n.toString());
	               //n.setPrint();
	               world.getTile(n.getRow(),n.getCol()).setPrint();
	               n = n.getParent();
	            }
	            //world.printGrid();
	            keepSearching = false;
	         }else{                                 //explore neighbors
	            closedList.add(current);            //add current node to closed list
	            
	            int curRow = current.getRow ();
	            int curCol = current.getCol ();
	            
	            for(int r = curRow - 1; r <= curRow + 1; r++){
	               for(int c = curCol - 1; c <= curCol + 1; c++){
	                 
	                  if(!(r < 0 || c < 0 || r > world.getGrid().length - 1 || c > world.getGrid()[0].length - 1)){ //in bounds
	                     if(world.getTile(r, c).passable()){                                          //pathable
	                        Tile n = new Tile(r, c);
	                        if(!closedList.contains (n)){                               //not in closed list
	                           
	                           int g = 14;
	                           if(r == curRow || c == curCol){
	                              g = 10;
	                           }
	                           g += current.getG ();
	   
	                           if(!openList.contains (n)){                              //not in open list
	                              n.setG (g);
	                              n.setH (getH(n, end));
	                              n.setParent (current);
	                              openList.add ( n );
	                           }else{                                                   //already in open list
	                              //Tile m = openList.get(openList.indexOf(n));
	                              Tile m = openList.find(n);
	                        	   if(g < m.getG()){
	                                 m.setG(g);
	                                 m.setParent(current);
	                              }
	                           }
	                        }
	                     }
	                  }  
	               }
	            }
	         }
	      }  
	   }

	private static void initialize() {
		// TODO Auto-generated method stub
		
		//creates the world and populates it with tiles
		world = new TileGrid();
		for(int i =0; i<world.getGrid().length;i++){
			for(int j=0; j<world.getGrid()[i].length; j++){
				Tile tile = new Tile(i,j);
				world.setTile(tile);
			}
		}
	}

	private static void grabUserInput() {
		world.printGrid();
		// get user input for starting and ending position
		Scanner k = new Scanner(System.in);
	    int startRow, startCol, endRow, endCol;
	    boolean valid = false;
	    while(!valid){
		    System.out.println("Enter Starting Row: ");
		    startRow = k.nextInt();
		      
		    System.out.println("Enter Starting Col: ");
		    startCol = k.nextInt();
		     
		    System.out.println("Enter Ending Row: ");
		    endRow = k.nextInt();
		      
		    System.out.println("Enter Ending Col: ");
		    endCol = k.nextInt();
		    start = world.getTile(startRow,startCol);
		    end = world.getTile(endRow,endCol);
		    
		    if( !start.passable() || !end.passable()){
		    	valid = false;
		    	System.out.println("Start or ending tile is not passable choose again ");
		    }else{
		    	valid = true;
		    }
	    }
	    start.setPrint();
	}
	
	public static int getH(Tile s, Tile e){
	      int r = Math.abs(s.getRow() - e.getRow());
	      int c = Math.abs(s.getCol() - e.getCol());
	      
	      return (r + c) * 10;
	   }
}
