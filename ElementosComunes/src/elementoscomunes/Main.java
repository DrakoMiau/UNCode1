
package elementoscomunes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Declaramos las 2 listas y los arreglos que vamos a utilizar
        LinkedList myOL1 = new LinkedList();
        LinkedList myOL2 = new LinkedList();
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        String[] arr1 = input1.split(" ");
        String[] arr2 = input2.split(" ");
        for (int i = 0; i < arr1.length; i++) {
            myOL1.insert(Integer.parseInt(arr1[i]));
        }
        for (int i = 0; i < arr2.length; i++) {
            myOL2.insert(Integer.parseInt(arr2[i]));
        }
        commonElements(myOL1, myOL2);
    }

    public static void commonElements(LinkedList list1, LinkedList list2) {
        Node start1 = list1.head;
        Node start2 = list2.queue;
        int sizeList = 0;
        while (start1 != null) {
            if (start1.getData() != start2.getData()) {
                sizeList++;
            }
            start2 = start2.back;
            start1 = start1.next;
        }
        int[] arr1 = new int[sizeList];
        int[] arr2 = new int[sizeList];
        int contador = 0;
        start1 = list1.head;
        start2 = list2.queue;
        while (start1 != null) {
            if (start1.getData() != start2.getData()) {
                arr1[contador] = start1.getData();
                arr2[contador] = start2.getData();
                contador++;
            }
            start2 = start2.back;
            start1 = start1.next;
            
        }
        
        for (int i = 0; i < arr1.length; i++) {  
            if (i != arr1.length - 1) {
                System.out.print(arr1[i] + " ");
            } else{
                System.out.println(arr1[i]);
            }
        }
        for (int i = arr2.length-1; 0 <= i; i--) {
            if (i != 0) {
                System.out.print(arr2[i] + " ");
            } else{
                System.out.print(arr2[i]);
            }
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

    public void printList() {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            if (start == queue) {
                System.out.println("\n");
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
