public class DoubleLinkedList{
Node first;
int size;

public DoubleLinkedList(){
	size = 0;
	first = null;
}
public boolean isEmpty(){
	return first==null;
}

public void add(Node n){
	if(!isEmpty()){
		n.setNext(first);
		first.setPrev(n);
	}
	first = n;
	size++;
}

public int size(){
	return size;
}

public void remove(Object item){
	Node temp = first;

	while(temp != null){
			 
			 if(temp.getData.equals(item)){
				//found match. set prev's next to temp's next
				if(temp.getPrev() == null){
				   //object we're removing is to the front
				   first = first.getNext();
				   first.setPrev(null);
				}else{
				   temp.getPrev().setNext( temp.getNext() );
				   if(temp.getNext() != null){
					  temp.getNext().setPrev( temp.getPrev() );
				   }
				} 
			 }
			 temp = temp.getNext();
	}
}

public Node find(Object item){
	Object temp = first;

	while(temp != null){
			 if(temp.getData().equals(n)){
				//found a match
				return temp;
			 }else{
				temp = temp.getNext();
			 }
	}
		  System.out.println("Didn't find it");
		  return null;
}

}