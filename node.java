public class Node{
Object data;
Node next, prev;

public Node(Object Data){
this.data = Data;
next = null;
}

public void setPrev(node){
prev = node;
}

public Node getPrev(){
return prev;
}

public void setNext(node){
next = node;
}

public Node getNext(){
return next;
}

public Object getData(){
return data;
}

public void Object setData(Object data){
this.data = data;
}

}