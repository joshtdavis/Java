package game;

public class Board {
	private Space board[][];
	
	
	
	public Board(){
		board = new Space[3][3];
		for(int i=0; i<board.length;i++){
			for(int j=0; j<board[i].length;j++){
				board[i][j] =  new Space(i,j);
			}
		}
	}
	
	public Board(Space[][] b){
		board = new Space[b.length][b[0].length];
		for(int i=0; i<board.length;i++){
			for(int j=0; j<board[i].length;j++){
				board[i][j] = new Space();
				board[i][j].setSpace( b[i][j].getSpace() );
				board[i][j].setX( b[i][j].getX() );
				board[i][j].setY( b[i][j].getY() );
			}
		}
	}
	
	public Space[][] getBoard() {
		return board;
	}

	public void setBoard(Space[][] board) {
		this.board = board;
	}

	public void updateSpace(char m, int x, int y){
		board[x][y].setSpace(m);
	}
	
	public Space getSpace(int x, int y){
		return board[x][y];
	}
	
	public void printBoard(){
		for(int j=board.length-1;j>=0;j--){
			System.out.print(j + " ");
			for(int i=0;i<board[j].length;i++){
				System.out.print(board[i][j].getSpace() + " ");
			}
			System.out.println();
		}
		System.out.println("  0 1 2");
	}
}