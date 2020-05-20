package DataStructures_Algorihm.thuchanh;

import DataStructures_Algorihm.baitap.MyLinkedListFull;

public class MyLinkedList <T> {
    private  Node head;
    private  int numNodes;

    private class Node {
        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public MyLinkedList(){

    }

    public MyLinkedList(T data) {
        head = new Node(data);
    }

    public void add(int index, T data) {
        index--;
        Node temp = head;
        Node holder;
        if(index == 0) {
            addFirst(data);
            return;
        }
        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(T data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public void addLast (T data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }
    public Node get(int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(10);
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(13);
        myLinkedList.add(2,109);
        myLinkedList.printList();
    }
}