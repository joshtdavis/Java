package game;

import java.util.ArrayList;

public class Grid {
	int[][] grid;
	ArrayList<Queen> queens;
	
public Grid() {
	grid = new int[8][8];
	queens = new ArrayList<Queen>();
}

public void addQueen(Queen q) {
	queens.add(q);
}

public Queen[] getAllQueens(){
	Queen[] queensInGrid = new Queen[8];
	
	for(int i=0; i<queens.size(); i++){
		queensInGrid[i] = queens.get(i);
	}
	return queensInGrid;
}

public Queen getQueenAt(int x) {
	return queens.get(x);
}

public void deleteQueens() {
	queens.clear(); // not sure if this works
}

public void printGrid(){
	for(int j=7;j>=0;j--){
		for(int i=0;i<grid.length;i++){
			if(j == getQueenAt(i).getY() && i == getQueenAt(i).getX()){
				System.out.print(" 1 ");
			}else{
				System.out.print(" 0 ");
			}
		}
		System.out.println("");
	}
}


}
