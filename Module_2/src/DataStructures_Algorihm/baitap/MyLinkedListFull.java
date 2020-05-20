package DataStructures_Algorihm.baitap;

import DataStructures_Algorihm.thuchanh.MyLinkedList;

public class MyLinkedListFull <T> {
    private Node head;
    private  int numNodes;

    private class Node {
        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }

    public MyLinkedListFull(){

    }

    public MyLinkedListFull(T data) {
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
    public void remove (int index) {
        if (index == 1 ) {
            removeFirst();
            return;
        }
        Node temp = head;
        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        Node holder = temp.next;
        temp = head;
        for (int i = 0; i < index - 2 ; i++ ) {
            temp = temp.next;
        }
        temp.next = holder;
        numNodes--;
    }
    public void removeFirst () {
        Node temp = head;
        head = temp.next;
        numNodes--;
    }
    public void remove (T data) {

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
    public int size () {
        return numNodes;
    }

    public int indexOf (T data) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.getData() == data) {
                return count + 1 ;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    public boolean contains (T data) {
        return indexOf(data) != -1;
    }
    @Override
    public MyLinkedListFull<T> clone () {
        return this;
    }
}
class TestMyLinkedListFull {
    public static void main(String[] args) {
        MyLinkedListFull<Integer> myLinkedListFull = new MyLinkedListFull<>();
        myLinkedListFull.addFirst(15);
        myLinkedListFull.addFirst(14);
        myLinkedListFull.addFirst(13);
        myLinkedListFull.addFirst(12);
        myLinkedListFull.addFirst(11);

//        myLinkedListFull.printList();
//        System.out.println(myLinkedListFull.contains(13));
//        System.out.println(myLinkedListFull.indexOf(13));

        MyLinkedListFull<Integer> myLinkedListFull_2 = myLinkedListFull.clone();
        System.out.println(myLinkedListFull_2.size());
        myLinkedListFull_2.remove(5);
        myLinkedListFull_2.printList();

    }
}