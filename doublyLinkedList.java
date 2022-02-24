
class DlinkedList {

  class Node{
    int data;
    Node next=null;
    Node prev=null;
    Node(int data){
      this.data = data;
    }
  }
  Node head;
  Node tail;
  

  public DlinkedList(){
    head = null;
    tail = null;
    
  }

  public void addFirst(int data){
    Node newNode = new Node(data);
    if(head == null){
      head = newNode;
      tail = newNode;
    }else{
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  public void addLast(int data){
    Node newNode = new Node(data);
    if(head == null){
      head = newNode;
      tail = newNode;
    }else{
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
  }

  public void addAfter(int data,int after){
    Node newNode = new Node(data);
    Node current = head;
    while(current.data != after){
      current = current.next;
    }
    newNode.next = current.next;
    current.next.prev = newNode;
    current.next = newNode;
    newNode.prev = current;
  }

  public void deleteFirst(){
    if(head == null){
      System.out.println("List is empty");
    }else{
      head = head.next;
      head.prev = null;
    }
  }

  public void deleteLast(){
    if(tail == null){
      System.out.println("List is empty");
    }else{
      tail = tail.prev;
      tail.next = null;
    }
  }

  public void deleteAny(int key){
    Node temp = head;
    while(temp != null){
      if(temp.data == key){
        if(temp == head){
          head = head.next;
          head.prev = null;
        }else if(temp == tail){
          tail = tail.prev;
          tail.next = null;
        }else{
          temp.prev.next = temp.next;
          temp.next.prev = temp.prev;
        }
        break;
      }
      temp = temp.next;
    }
  }

  public void traverse(){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
    System.out.println("\n");
  }

}

class DLDemo{
  public static void main(String[] args) {

    DlinkedList dl = new DlinkedList();
    dl.addFirst(10);
    dl.addFirst(20);
    dl.addFirst(30);
    dl.addFirst(40);
    dl.addFirst(50);
    dl.addLast(5);
    dl.addAfter(12, 30);
    dl.traverse();
    dl.deleteFirst();
    System.out.println("\nAfter delete first");
    dl.traverse();
    dl.deleteLast();
    System.out.println("\nAfter delete last");

    dl.traverse();
    dl.deleteAny(30);
    System.out.println("\nAfter delete");

    dl.traverse();

    
  }
}