package game;

import java.util.ArrayList;

public class Node {
	private Board board;
	private int heuristic;
	private int[][] boardMove;
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}
	public int getHeuristic() {
		return heuristic;
	}
	public int[][] getBoardMove() {
		return boardMove;
	}
	
	public void setBoardMove(int x, int y, int value){
		boardMove[x][y] = value;
	}
	
	public void setBoardMove(int[][] value){
		for(int i=0;i<boardMove.length;i++){
			for(int j=0; j<boardMove[i].length; j++){
				boardMove[i][j] = value[i][j];
			}
		}
	}
	
	public Node(Board board, int x,  int y, int value) {
		super();
		this.board = board;
		heuristic = 0;
		boardMove = new int[board.getBoard().length][board.getBoard()[0].length];
		for(int i=0;i<boardMove.length;i++){
			for(int j=0; j<boardMove[i].length; j++){
				boardMove[i][j] = 0;
			}
		}
		boardMove[x][y]=value;
	}
	public Node(Board board) {
		super();
		this.board = board;
		heuristic = 0;
		boardMove = new int[board.getBoard().length][board.getBoard()[0].length];
		for(int i=0;i<boardMove.length;i++){
			for(int j=0; j<boardMove[i].length; j++){
				boardMove[i][j] = 0;
			}
		}
	}
	public Node(){
		boardMove = new int[board.getBoard().length][board.getBoard()[0].length];
		for(int i=0;i<boardMove.length;i++){
			for(int j=0; j<boardMove[i].length; j++){
				boardMove[i][j] = 0;
			}
		}
	}
	public void calcHeuristic(){
		heuristic =0;
		if( checkWinState() ){
			return;
		}else{
			int[] rowPlayer = {0,0,0};
			int[] colPlayer = {0,0,0};
			int[] rowComp = {0,0,0};
			int[] colComp = {0,0,0};
			
			for(int i=0; i<board.getBoard().length ;i++){
				if( board.getSpace(i,0).getSpace()=='X' ){
					rowPlayer[0] += 1;
				}
				if( board.getSpace(i,1).getSpace()=='X' ){
					rowPlayer[1] += 1;
				}
				if( board.getSpace(i,2).getSpace()=='X' ){
					rowPlayer[2] += 1;
				}
				if( board.getSpace(i,0).getSpace()=='O' ){
					rowComp[0] += 1;
				}
				if( board.getSpace(i,1).getSpace()=='O' ){
					rowComp[1] += 1;
				}
				if( board.getSpace(i,2).getSpace()=='O' ){
					rowComp[2] += 1;
				}
				// columns
				if( board.getSpace(0,i).getSpace()=='X' ){
					colPlayer[0] += 1;
				}
				if( board.getSpace(1,i).getSpace()=='X' ){
					colPlayer[1] += 1;
				}
				if( board.getSpace(2,i).getSpace()=='X' ){
					colPlayer[2] += 1;
				}
				if( board.getSpace(0,i).getSpace()=='O' ){
					colComp[0] += 1;
				}
				if( board.getSpace(1,i).getSpace()=='O' ){
					colComp[1] += 1;
				}
				if( board.getSpace(2,i).getSpace()=='O' ){
					colComp[2] += 1;
				}
			}
			for(int i=0; i<rowPlayer.length;i++){
				if(rowPlayer[i]==2){
					heuristic--;
				}
				if(colPlayer[i]==2){
					heuristic--;
				}
				if(rowComp[i]==2){
					heuristic++;
				}
				if(colComp[i]==2){
					heuristic++;
				}
			}
		}
	}
	private boolean checkWinState() {
		// player wins
		if( playerWins() ){
			return true;
		}
		//computer wins
		if( compWins() ){
			return true;
		}
		
		return false;
	}
	private boolean playerWins() {
		if( board.getSpace(0, 0).getSpace()=='X' && board.getSpace(0, 1).getSpace()=='X' && board.getSpace(0, 2).getSpace()=='X'){
			heuristic = -100;
			return true;
		}
		if( board.getSpace(0, 0).getSpace()=='X' && board.getSpace(1, 0).getSpace()=='X' && board.getSpace(2, 0).getSpace()=='X'){
			heuristic = -100;
			return true;
		}
		if( board.getSpace(0, 0).getSpace()=='X' && board.getSpace(1, 1).getSpace()=='X' && board.getSpace(2, 2).getSpace()=='X'){
			heuristic = -100;
			return true;
		}
		if( board.getSpace(1, 0).getSpace()=='X' && board.getSpace(1, 1).getSpace()=='X' && board.getSpace(1, 2).getSpace()=='X'){
			heuristic = -100;
			return true;
		}
		if( board.getSpace(2, 0).getSpace()=='X' && board.getSpace(2, 1).getSpace()=='X' && board.getSpace(2, 2).getSpace()=='X'){
			heuristic = -100;
			return true;
		}
		if( board.getSpace(0, 1).getSpace()=='X' && board.getSpace(1, 1).getSpace()=='X' && board.getSpace(2, 1).getSpace()=='X'){
			heuristic = -100;
			return true;
		}
		if( board.getSpace(0, 2).getSpace()=='X' && board.getSpace(1, 2).getSpace()=='X' && board.getSpace(2, 2).getSpace()=='X'){
			heuristic = -100;
			return true;
		}
		if( board.getSpace(0, 2).getSpace()=='X' && board.getSpace(1, 1).getSpace()=='X' && board.getSpace(2, 0).getSpace()=='X'){
			heuristic = -100;
			return true;
		}
		return false;
	}
	private boolean compWins() {
		if( board.getSpace(0, 0).getSpace()=='O' && board.getSpace(0, 1).getSpace()=='O' && board.getSpace(0, 2).getSpace()=='O'){
			heuristic = 100;
			return true;
		}
		if( board.getSpace(0, 0).getSpace()=='O' && board.getSpace(1, 0).getSpace()=='O' && board.getSpace(2, 0).getSpace()=='O'){
			heuristic = 100;
			return true;
		}
		if( board.getSpace(0, 0).getSpace()=='O' && board.getSpace(1, 1).getSpace()=='O' && board.getSpace(2, 2).getSpace()=='O'){
			heuristic = 100;
			return true;
		}
		if( board.getSpace(1, 0).getSpace()=='O' && board.getSpace(1, 1).getSpace()=='O' && board.getSpace(1, 2).getSpace()=='O'){
			heuristic = 100;
			return true;
		}
		if( board.getSpace(2, 0).getSpace()=='O' && board.getSpace(2, 1).getSpace()=='O' && board.getSpace(2, 2).getSpace()=='O'){
			heuristic = 100;
			return true;
		}
		if( board.getSpace(0, 1).getSpace()=='O' && board.getSpace(1, 1).getSpace()=='O' && board.getSpace(2, 1).getSpace()=='O'){
			heuristic = 100;
			return true;
		}
		if( board.getSpace(0, 2).getSpace()=='O' && board.getSpace(1, 2).getSpace()=='O' && board.getSpace(2, 2).getSpace()=='O'){
			heuristic = 100;
			return true;
		}
		if( board.getSpace(0, 2).getSpace()=='O' && board.getSpace(1, 1).getSpace()=='O' && board.getSpace(2, 0).getSpace()=='O'){
			heuristic = 100;
			return true;
		}
		return false;
	}
}
