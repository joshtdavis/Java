package aStar;

public class HashTable {
Tile[] table;

public HashTable(int x, int y) {
	super();
	table = new Tile[x*y];
}

public int hashKey(Tile t){
	return t.getRow()*15 + t.getCol();
}


public void add(Tile t){
	table[hashKey(t)] = t;
}

public Tile find(Tile t){
	return table[hashKey(t)];
}

public boolean contains(Tile t){
	if(find(t)==null){
		return false;
	}
	return find(t).equals(t);
}

public void clear() {
	// TODO Auto-generated method stub
	table=null;
}

}
