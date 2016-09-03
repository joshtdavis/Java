package aStar;

public class MinHeap {

	Tile[] heap;
	int back;
	int size;
	
	public MinHeap(int x, int y){
		heap = new Tile[x*y];
		heap[1] = null;
		back = 1;
		size = 0;
	}
	
	public void add(Tile t){
		heap[back] = t;
		back++;
		size++;
		addHeapify();
	}
	
	public boolean isEmpty(){
		return heap[1]==null;
	}
	
	public boolean contains(Tile t){
		if(find(t)==null){
			return false;
		}
		return find(t).equals(t);
	}
	
	public Tile find(Tile t){
		// linear search for now
		for(int i=1; i<size;i++){
			if(heap[i].equals(t)){
				return heap[i];
			}
		}
		return null;
	}
	
	public Tile remove(){
		if(!isEmpty()){
			Tile x = heap[1];
			size--;
			heap[1] = heap[back-1];
			heap[back-1] = null;
			back--;
			removeHeapify();
			return x;
		}
		return null;
	}
	
	private void removeHeapify() {
		int index = 1;
		int largest;
		while(index < size/2){
			if( (index*2+1 < size) && (heap[index*2].getF() > heap[index*2+1].getF()) ){
				largest = index*2+1;
			}
			else{
				largest = index*2;
			}
			if(heap[index].getF() < heap[largest].getF()){
				break;
			}
			else{
				Tile t = heap[index];
				heap[index] = heap[largest];
				heap[largest] = t;
			}
			index = index*2;
		}
	}

	private boolean isLeaf(int index){
		return ( ( index>=size/2 ) && (index<size) );
	}
	
	private Tile leftChild(int index){
		return heap[2*index];
	}
	
	private Tile rightChild(int index){
		return heap[2*index+1]; 
	}
	
	private Tile parent(int index){
		return heap[index/2];
	}
	
	public void addHeapify(){
		int index = back-1;
		
		//System.out.println("Index is :"+ index + "\nTile :" + heap[index]);
		
		while(parent(index)!=null && heap[index].getF() < parent(index).getF()){
			//System.out.println("Index is :"+ index + "\nTile :" + heap[index]);
			Tile t = heap[index];
			heap[index] = parent(index);
			heap[index/2] = t;
		}
	}

	public int size() {
		return size;
	}

	public void clear() {
		back=0;
		size=0;
		heap=null;
	}
}
