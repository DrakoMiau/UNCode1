package robots;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        LinkedList myOL1 = new LinkedList();
        LinkedList myOL2 = new LinkedList();
        myOL1.printList();
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");
        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arrInt.length; i++) {  //pasamos los datos del arreglo de strings a entero
            arrInt[i] = Integer.parseInt(arr[i]); //este es nuestro arreglo de enteros
        }
        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] > 0) {
                myOL1.insert(arrInt[i]);
            } else{
                myOL2.insert(arrInt[i]);
            }
        }
        
        luchaRobots(myOL1, myOL2);
    }
    
    public static void luchaRobots(LinkedList myOL1, LinkedList myOL2){
        while(!myOL1.isEmpty() && !myOL2.isEmpty()){
            if (myOL1.queue.getData() > -myOL2.head.getData()) {
                myOL2.delete(0);
            } else if(myOL1.queue.getData() < -myOL2.head.getData()){
                myOL1.delete(myOL1.size-1);
            } else if (myOL1.queue.getData() == -myOL2.head.getData()) {
                myOL2.delete(0);
                myOL1.delete(myOL1.size-1);
            }
        }
        if (myOL1.isEmpty() && myOL2.isEmpty() ) {
            System.out.print("No quedaron robots!");
        } else if(myOL1.isEmpty() && !myOL2.isEmpty()){
            myOL2.printList();
        } else if(!myOL1.isEmpty() && myOL2.isEmpty()){
            myOL1.printList();
        }
    }
}

class Node {

    Node next;
    Node back;
    int data;

    public Node(int data) {
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }
}

class LinkedList {

    Node head;
    Node queue;
    int size = 0;
    
    public boolean isEmpty(){
        if (head == null) {
            return true;
        } else{
            return false;
        }
    }

    public void insert(int data) {
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
        size++;

    }

    public void delete(int position) {
        if (head == null) {
            return; // la lista está vacía, no se puede eliminar ningún elemento
        }
        if (position == 0) {
            head = head.next; // si la posición es la primera, se elimina el head
            if (head != null) {
                head.back = null;
            }
            size--;
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next; // mover al nodo en la posición anterior
        }
        if (current == null || current.next == null) {
            return; // la posición está más allá del final de la lista
        }
        current.next = current.next.next;
        if (current.next != null) {
            current.next.back = current;
        } else {
            queue = current;
        }
        size--;
    }

    public void printList() {
        Node start = head;
        while (start != null) {
            if (start.next != null) {
                System.out.print(start.data + " ");
            } else{
                System.out.print(start.data);
            }
            
            start = start.next;
        }
    }

    public void printBack() {
        try {
            System.out.println(queue.back.getData());
        } catch (Exception e) {
            System.out.println("null");
        }
    }

    public void printHead() {
        System.out.println(head.getData());
    }
}

