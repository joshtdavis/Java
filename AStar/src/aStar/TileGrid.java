package aStar;

public class TileGrid {
	Tile[][] grid;

	public TileGrid() {
		grid = new Tile[15][15];
	}
	
	public Tile getTile(int row, int col){
		return grid[row][col];
	}
	
	public void setTile(Tile t){
		grid[t.getRow()][t.getCol()] = t;
	}
	
	public Tile[][] getGrid(){
		return grid;
	}
	
	public void printGrid(){
		System.out.println("Printing world:  ");
		for(int j=grid.length-1;j>=0;j--){
			for(int i=0;i<grid[j].length;i++){
				grid[i][j].printTile();
			}
			System.out.println();
		}
		System.out.println("World printed");
	}

	public void clear() {
		// TODO Auto-generated method stub
	}
}
