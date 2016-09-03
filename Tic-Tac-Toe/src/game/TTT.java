package game;

import java.util.ArrayList;
import java.util.Scanner;

public class TTT {

	static Board board;
	static boolean gameOn;
	static final int MAX_DEPTH = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
		while(gameOn){
//			board.printBoard();
			playerMove();
			if(gameOn){
				compMove();
				checkWinner();
			}
		}
	}

	private static void compMove() {
		// TODO Auto-generated method stub
		Node result = miniMax(0,true, new Node(board));
		
		Board theBoard = result.getBoard();
		//System.out.println("Computer generated board");
		for(int j=theBoard.getBoard().length-1;j>=0;j--){
			for(int i=0;i<theBoard.getBoard()[j].length;i++){
				if(result.getBoardMove()[i][j]>1){
					theBoard.getBoard()[i][j].setSpace('E');
				}
				//System.out.print(theBoard.getBoard()[i][j].getSpace() + " : "+result.getBoardMove()[i][j]);
			}
			//System.out.println();
		}
		board = theBoard;
		board.printBoard();
	}
	
	private static ArrayList<Node> getMoves(Node n, boolean max, int level){
		ArrayList<Node> moves = new ArrayList<Node>();
		for(int i=0; i<n.getBoard().getBoard().length;i++){
			for(int j=0; j<n.getBoard().getBoard()[i].length;j++){
				if( n.getBoard().getSpace(i, j).getSpace()=='E' ){
					Board b = new Board( n.getBoard().getBoard() );
					if(max){
						b.updateSpace('O', i, j);
					}
					else{
						b.updateSpace('X', i, j);
					}
					Node next = new Node(b);
					next.setBoardMove(n.getBoardMove());
					next.setBoardMove(i, j, level+1);
					//moves.add(new Node(b,i,j,level+1) );
					moves.add(next);
				}
			}
		}
//		for(int i=0;i<moves.size();i++){
//			System.out.println("Move "+i);
//			moves.get(i).getBoard().printBoard();
//			int[][] vals = moves.get(i).getBoardMove();
//			System.out.println(vals[0][2]+" "+vals[1][2]+" "+vals[2][2]);
//			System.out.println(vals[0][1]+" "+vals[1][1]+" "+vals[2][1]);
//			System.out.println(vals[0][0]+" "+vals[1][0]+" "+vals[2][0]);
//		}
		return moves;
	}
	
	private static Node miniMax(int level, boolean max, Node n){
		if(level>MAX_DEPTH){
			n.calcHeuristic();
			return n;
		}
		ArrayList<Node> moves = getMoves(n, max, level);
		if(moves.size() == 0){
			n.calcHeuristic();
			return n;
		}
		Node returnNode;
		Node bestMove = null;
		for(Node move: moves){
			//System.out.println("Am I at recure point");
			returnNode = miniMax(level+1, !max, move);
			if(max){
				if(bestMove==null){
					bestMove = returnNode;
				}else{
					if(bestMove.getHeuristic()<returnNode.getHeuristic()){
						//System.out.println("Setting bestMove to returnNode");
						bestMove = returnNode;
					}
				}
			}else{
				if(bestMove==null){
					bestMove = returnNode;
				}else{
					if(bestMove.getHeuristic()>returnNode.getHeuristic()){
						bestMove = returnNode;
					}
				}
			}
		}
		return bestMove;
	}
	
	private static void initialize() {
		// TODO Auto-generated method stub
		board = new Board();
		gameOn=true;
		System.out.println("Player is X Computer is O");
		board.printBoard();
	}
	
	private static void checkWinner(){
		if( board.getSpace(0, 0).getSpace()=='X' && board.getSpace(0, 1).getSpace()=='X' && board.getSpace(0, 2).getSpace()=='X'){
			gameOn = false;
			System.out.println("Player Wins!");
			return;
		}
		if( board.getSpace(0, 0).getSpace()=='X' && board.getSpace(1, 0).getSpace()=='X' && board.getSpace(2, 0).getSpace()=='X'){
			gameOn = false;
			System.out.println("Player Wins!");
			return;
		}
		if( board.getSpace(0, 0).getSpace()=='X' && board.getSpace(1, 1).getSpace()=='X' && board.getSpace(2, 2).getSpace()=='X'){
			gameOn = false;
			System.out.println("Player Wins!");
			return;
		}
		if( board.getSpace(1, 0).getSpace()=='X' && board.getSpace(1, 1).getSpace()=='X' && board.getSpace(1, 2).getSpace()=='X'){
			gameOn = false;
			System.out.println("Player Wins!");
			return;
		}
		if( board.getSpace(2, 0).getSpace()=='X' && board.getSpace(2, 1).getSpace()=='X' && board.getSpace(2, 2).getSpace()=='X'){
			gameOn = false;
			System.out.println("Player Wins!");
			return;
		}
		if( board.getSpace(0, 1).getSpace()=='X' && board.getSpace(1, 1).getSpace()=='X' && board.getSpace(2, 1).getSpace()=='X'){
			gameOn = false;
			System.out.println("Player Wins!");
			return;
		}
		if( board.getSpace(0, 2).getSpace()=='X' && board.getSpace(1, 2).getSpace()=='X' && board.getSpace(2, 2).getSpace()=='X'){
			gameOn = false;
			System.out.println("Player Wins!");
			return;
		}
		if( board.getSpace(0, 2).getSpace()=='X' && board.getSpace(1, 1).getSpace()=='X' && board.getSpace(2, 0).getSpace()=='X'){
			gameOn = false;
			System.out.println("Player Wins!");
			return;
		}
		//computer wins
		if( board.getSpace(0, 0).getSpace()=='O' && board.getSpace(0, 1).getSpace()=='O' && board.getSpace(0, 2).getSpace()=='O'){
			gameOn = false;
			System.out.println("Player Loses.");
			return;
		}
		if( board.getSpace(0, 0).getSpace()=='O' && board.getSpace(1, 0).getSpace()=='O' && board.getSpace(2, 0).getSpace()=='O'){
			gameOn = false;
			System.out.println("Player Loses.");
			return;
		}
		if( board.getSpace(0, 0).getSpace()=='O' && board.getSpace(1, 1).getSpace()=='O' && board.getSpace(2, 2).getSpace()=='O'){
			gameOn = false;
			System.out.println("Player Loses.");
			return;
		}
		if( board.getSpace(1, 0).getSpace()=='O' && board.getSpace(1, 1).getSpace()=='O' && board.getSpace(1, 2).getSpace()=='O'){
			gameOn = false;
			System.out.println("Player Loses.");
			return;
		}
		if( board.getSpace(2, 0).getSpace()=='O' && board.getSpace(2, 1).getSpace()=='O' && board.getSpace(2, 2).getSpace()=='O'){
			gameOn = false;
			System.out.println("Player Loses.");
			return;
		}
		if( board.getSpace(0, 1).getSpace()=='O' && board.getSpace(1, 1).getSpace()=='O' && board.getSpace(2, 1).getSpace()=='O'){
			gameOn = false;
			System.out.println("Player Loses.");
			return;
		}
		if( board.getSpace(0, 2).getSpace()=='O' && board.getSpace(1, 2).getSpace()=='O' && board.getSpace(2, 2).getSpace()=='O'){
			gameOn = false;
			System.out.println("Player Loses.");
			return;
		}
		if( board.getSpace(0, 2).getSpace()=='O' && board.getSpace(1, 1).getSpace()=='O' && board.getSpace(2, 0).getSpace()=='O'){
			gameOn = false;
			System.out.println("Player Loses.");
			return;
		}
		int count=0; // counts number of empty spaces on board if none then draw
		for(int i=0;i<board.getBoard().length;i++){
			for(int j=0; j<board.getBoard()[i].length;j++){
				if( board.getSpace(i, j).getSpace()=='E' ){
					count++;
				}
			}
		}
		if(count==0){
			gameOn=false;
			board.printBoard();
			System.out.println("Game ends in a Draw");
			return;
		}
	}
	
	private static void playerMove(){
		Scanner s = new Scanner(System.in);
		boolean validMove = false;
		while(!validMove){
			System.out.println("Enter X cord of space you want to mark ");
			int x = s.nextInt();
			System.out.println("Enter Y cord of space you want to mark ");
			int y = s.nextInt();
			
			if(x<0 || x>3 || y<0 || y>3){
				System.out.println("Invalid move out of bounds");
			}else{
				if( board.getSpace(x, y).getSpace()=='E' ){
					validMove = true;
					board.updateSpace('X', x, y);
				}else{
					System.out.println("Invalid move Space occupied");
					System.out.println(board.getSpace(x, y).getSpace()+": ");
				}
			}
		}	
		checkWinner();
	}
}
