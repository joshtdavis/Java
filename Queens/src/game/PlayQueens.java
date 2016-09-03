package game;

import java.util.Random;

public class PlayQueens {

	/**
	 * @param args
	 */
	static Grid grid;
	static Queen[] queens;
	static int heuristic = 20;
	static int bh = 10;
	static boolean solution = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playGame();
	}

	// plays the game
	private static void playGame() {
		// TODO Auto-generated method stub
		initialize();
		while(!solution){
			heuristic = checkState();
			System.out.println("Current heuristic " + checkState());
			findMove();
			printGrid();
		}
	}
	
	private static void findMove() {
		// TODO Auto-generated method stub
		int bestY = 100;
		int choosenQueen = 10;
		int bestH = 10;
		int currH = 10;
		Queen[] q = new Queen[8];
		Queen[] queenList = grid.getAllQueens();
		Queen currQueen = new Queen(-1,-1);
		
		
		for(int i=0; i<queenList.length;i++){
			currQueen.setX(queenList[i].getX());
			currQueen.setY(queenList[i].getY());
			
			for(int j=0; j<8; j++){
				currQueen.setY(j);
				
				switch(i){
				case 0:	q[0] = currQueen;
						q[1] = queenList[1];
						q[2] = queenList[2];
						q[3] = queenList[3];
						q[4] = queenList[4];
						q[5] = queenList[5];
						q[6] = queenList[6];
						q[7] = queenList[7];
						break;
				case 1:
						q[1] = currQueen;
						q[0] = queenList[0];
						q[2] = queenList[2];
						q[3] = queenList[3];
						q[4] = queenList[4];
						q[5] = queenList[5];
						q[6] = queenList[6];
						q[7] = queenList[7];
						break;
				case 2:
						q[2] = currQueen;
						q[0] = queenList[0];
						q[1] = queenList[1];
						q[3] = queenList[3];
						q[4] = queenList[4];
						q[5] = queenList[5];
						q[6] = queenList[6];
						q[7] = queenList[7];
					break;
				case 3:	
						q[3] = currQueen;
						q[0] = queenList[0];
						q[1] = queenList[1];
						q[2] = queenList[2];
						q[4] = queenList[4];
						q[5] = queenList[5];
						q[6] = queenList[6];
						q[7] = queenList[7];
					break;
				case 4:	
						q[4] = currQueen;
						q[0] = queenList[0];
						q[1] = queenList[1];
						q[2] = queenList[2];
						q[3] = queenList[3];
						q[5] = queenList[5];
						q[6] = queenList[6];
						q[7] = queenList[7];
					break;
				case 5:	
						q[5] = currQueen;
						q[0] = queenList[0];
						q[1] = queenList[1];
						q[2] = queenList[2];
						q[3] = queenList[3];
						q[4] = queenList[4];
						q[6] = queenList[6];
						q[7] = queenList[7];
					break;
				case 6:	
						q[6] = currQueen;
						q[0] = queenList[0];
						q[1] = queenList[1];
						q[2] = queenList[2];
						q[3] = queenList[3];
						q[4] = queenList[4];
						q[5] = queenList[5];
						q[7] = queenList[7];
					break;
				case 7:	
						q[7] = currQueen;
						q[0] = queenList[0];
						q[1] = queenList[1];
						q[2] = queenList[2];
						q[3] = queenList[3];
						q[4] = queenList[4];
						q[5] = queenList[5];
						q[6] = queenList[6];
					break;
				default: q = null;
				}
				currH = calcHeuristic(q);
				if(currH<bestH){
					int bh = bestH;
					bestH = currH;
					bestY = j;
					choosenQueen = currQueen.getX();
					//System.out.println("Better Heuristic value found " + "currH: "+ currH + " bestH: " + bh + " Y val: " + bestY + " Queen: " + choosenQueen);
				}
			}
		}
			// make move
			System.out.println("Making Move: ");
			grid.getQueenAt(choosenQueen).setY(bestY);
			//System.out.println("currH: " + currH + " bestH: " + bestH + " bh: "+ bh + " Heuristic: " + heuristic + " choosenQueen: " + choosenQueen);
			//System.out.println("Grid Queen Y val: "+grid.getQueenAt(choosenQueen).getY() + " act Y val: "+bestY);
			if(bestH == heuristic || currH == heuristic || bh == bestH){
				System.out.println(bestH + " , " + heuristic);
				reset();
			}
			if(bestH==0){
				System.out.println("Solution Found!");
				solution = true;
			}
			bh = bestH;
	}

	private static int calcHeuristic(Queen[] q) {
		// TODO Auto-generated method stub
		int heur = 0;
		Queen currentQueen;
		for(int i=0;i<q.length; i++){
			q[i].setDanger(false);
		}
		
		for(int q1=0; q1<q.length;q1++){
			currentQueen = q[q1];
			
			for(int x=0; x<q.length; x++){
				if(q1 != x){
					if(currentQueen.getY() == q[x].getY()){
						currentQueen.setDanger(true);
					}
					if( Math.abs(q[x].getX() - currentQueen.getX()) == Math.abs(q[x].getY() - currentQueen.getY())){
						currentQueen.setDanger(true);
					}
				}
			}
			
			if(currentQueen.isInDanger()){
				heur++;
			}
		}
		return heur;
	}

	private static int checkState() {
		// TODO Auto-generated method stub
		int currentHeuristic = 0;
		Queen currentQueen;
		for(int q=0; q<queens.length;q++){
			currentQueen = queens[q];
			
			for(int x=0; x<queens.length; x++){
				if(q!=x){
					if(currentQueen.getY() == queens[x].getY()){
						currentQueen.setDanger(true);
						queens[x].setDanger(true);
					}
					if( Math.abs(queens[x].getX() - currentQueen.getX()) == Math.abs(queens[x].getY() - currentQueen.getY())){
						currentQueen.setDanger(true);
						queens[x].setDanger(true);
					}
				}
			}
			
			if(currentQueen.isInDanger()){
				currentHeuristic++;
			}
		}
		return currentHeuristic;
	}

	// prints out the grid
	private static void printGrid() {
		// TODO Auto-generated method stub
		System.out.println("Current State: ");
		grid.printGrid();
	}

	// sets up the board
	private static void initialize() {
		// TODO Auto-generated method stub
		grid = new Grid();
		Random r = new Random();
		for(int i=0; i<8; i++){
			grid.addQueen(new Queen(i,r.nextInt(8)));
		}
		queens = grid.getAllQueens();
	}
	
	// resets the board in event of local minimum
	private static void reset() {
		System.out.println("Random Restart ");
		grid.deleteQueens();
		Random r = new Random();
		for(int i=0; i<8; i++){
			grid.addQueen(new Queen(i,r.nextInt(8)));
		}
		queens = grid.getAllQueens();
	}
}
