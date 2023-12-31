import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class myLinkedList {
  // To Delete A Node At First Place.
  Node deleteAtBeginning(Node head){
    Node current = head;
    head = current.next;
    current = null;
    return head;
  }

  // To Delete A Node At Last Place.
  Node deleteAtEnd(Node head){
    Node ptr1 = head;
    Node ptr2 = ptr1.next;
    while (ptr2.next != null){
      ptr2 = ptr2.next;
      ptr1 = ptr1.next;
    }
    ptr1.next = null;
    return head;
  }

  // To Delete A Node At Middle.
  Node deleteAtMiddle(Node head, int index){
    Node current = head;
    int i = 1;
    while(i != index-1){
      current = current.next;
      i++;
    }
    Node ptr = current.next;
    current.next = ptr.next;
    return head;
  }

  //To Delete A Node With The Given Value.
  Node deleteNodeWithValue(Node head, int value){
    Node ptr1 = head;
    Node ptr2 = ptr1.next;
    while (ptr2.data != value && ptr2.next != null){
      ptr2 = ptr2.next;
      ptr1 = ptr1.next;
    }
    if (ptr2.data == value){
      ptr1.next = ptr2.next;
    }
    else {
      return head;
    }
    return head;
  }
  // To Display The Linked List.
  void display(Node head) {
    Node current = head;
    while (current.next != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }
    System.out.print("null");
  }
}

class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    myLinkedList ll = new myLinkedList();
    Node head = new Node(10);
    Node second = new Node(20);
    Node third = new Node(30);
    Node fourth = new Node(40);
    Node fifth = new Node(50);
    head.next=second;
    second.next=third;
    third.next = fourth;
    fourth.next=fifth;
    System.out.println("Current Linked List: ");
    ll.display(head);
    System.out.print("\nDo You Want To Delete Any Node?[Y/N] : ");
    String choice1 = sc.next();
    // To Delete Node At Beginning.
    if(choice1.equals('Y')||choice1.equals("yes"))
    {
      System.out.print("\n~ To Delete A Node At Beginning Enter 'B'\n~ To Delete A Node At End Enter 'E'\n~ To Delete A Node At Middle Enter 'M'\n~ To Delete A Node With A Value Given Enter 'V'\n-> Enter Your Choice : ");
      String choice2 = sc.next();
      switch(choice2)
      {
        case "B":
          head = ll.deleteAtBeginning(head);
          System.out.println("Updated Linked List: ");
          ll.display(head);
          break;
        case "E":
          head = ll.deleteAtEnd(head);
          System.out.println("Updated Linked List: ");
          ll.display(head);
          break;
        case "M":
          System.out.print("Enter The Index Of The Node To Be Deleted : ");
          int index = sc.nextInt();
          head = ll.deleteAtMiddle(head, index);
          System.out.println("Updated Linked List: ");
          ll.display(head);
          break;
        case "V":
          System.out.print("Enter The Value Of The Node To Be Deleted : ");
          int value = sc.nextInt();
          head = ll.deleteNodeWithValue(head, value);
          System.out.println("Updated Linked List: ");
          ll.display(head);
          break;
        default:
          System.out.println("Invalid Choice");
          break;
      }
    }
    else
      {
        System.out.println("Thank You For Inteacting With Our Program!!");
    }
  }
}