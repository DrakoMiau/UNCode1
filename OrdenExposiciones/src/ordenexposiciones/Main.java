
package ordenexposiciones;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList myOL = new LinkedList();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            myOL.insert(arr[i]);
        }
        myOL.printFinalList();
    }
}

class LinkedList {
    Node head;
    Node queue;
    class Node {
    
    Node next;
    Node back;
    String data;
    
    public Node(String data) {
        this.data = data;
        next = null;
        back = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
     public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }
    
}
          
    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            queue = head;
        } else {
            Node prev = null;
            Node temp = head;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            temp.next = newNode;
            if (temp.back == null) {
                prev = temp;
            }
            temp.next.back = temp;
            queue = temp.next;
            
        }
        
    }
    public void printList() {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }
    
    public void printFinalList(){
        while (head != queue && head.next != queue) {            
            System.out.print(head.getData() + " " + queue.getData() + " ");
            head = head.next;
            queue = queue.back;
        }
        if (head != queue) {
            System.out.print(head.getData() + " " + queue.getData());
            
        } else
            System.out.print(head.getData());
    }
    
    public void printBack(){
        try {
            System.out.println(queue.back.getData());
        } catch (Exception e) {
            System.out.println("null");
        }
    }
    
    public void printHead(){
        System.out.println(head.getData());
    }
}

