
class DL{
  class Node{
    int data;
    Node next=null;
    Node prev=null;
    Node(int data){
      this.data = data;
    }
  }
  Node head;
  public void insertNodeFront(int data){
    Node newNode=new Node(data);
    if(head==null){
      head=newNode;
    }
  }
}

public class cycle6 {
  
}
