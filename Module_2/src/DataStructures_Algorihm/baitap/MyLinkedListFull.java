package DataStructures_Algorihm.baitap;

import DataStructures_Algorihm.thuchanh.MyLinkedList;

public class MyLinkedListFull <T> implements Cloneable {
    public Node<T> head;
    private int numNodes;



    public MyLinkedListFull() {

    }

    public MyLinkedListFull(T data) {
        head = new Node<T>(data);
    }

    public void add(int index, T data) {
        index--;
        Node<T> temp = head;
        Node<T> holder;
        if (index == 0) {
            addFirst(data);
            return;
        }
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node<T>(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(T data) {
        Node<T> temp = head;
        head = new Node<>(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(T data) {
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<T>(data);
    }

    public void remove(int index) {
        if (index == 1) {
            removeFirst();
            return;
        }
        Node<T>temp = head;
        Node<T> previous = null;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = temp.next;
        numNodes--;
    }
//public void remove(int position) {
//    Node<T> current = head;
//    Node<T> holder = null;
//    int prePos = 1;
//    if (head != null) {
//        if (position == 1) {
//            removeFirst();
//        } else {
//            while (current.next != null && prePos < position) {
//                prePos++;
//                holder = current;
//                current = current.next;
//            }
//            if (current.next != null) {
//                holder.next = current.next;
//            } else {
//                holder.next = null;
//            }
//        }
//        numNodes--;
//    }
//}

    public void removeFirst() {
        Node<T> temp = head;
        head = temp.next;
        numNodes--;
    }

    public void remove(T data) {

    }

    public Node<T> get(int index) {
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node<T> temp = head;
        while (temp!= null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int size() {
        return numNodes;
    }

    public int indexOf(T data) {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getData() == data) {
                return count + 1;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public MyLinkedListFull<T> clone() throws CloneNotSupportedException {
        MyLinkedListFull<T> cloned = (MyLinkedListFull<T>) super.clone();
        cloned.head = this.head.clone();
        Node<T> pointerClone = cloned.head;
        Node<T> pointer = this.head;
        while (pointer.next != null) {
            pointerClone.next = pointer.next.clone();
            pointerClone = pointerClone.next;
            pointer = pointer.next;
        }
        return cloned;
    }
}
    class TestMyLinkedListFull {
        public static void main(String[] args) throws CloneNotSupportedException {
            MyLinkedListFull<Integer> myLinkedListFull = new MyLinkedListFull<>();
            myLinkedListFull.addFirst(15);
            myLinkedListFull.addFirst(14);
            myLinkedListFull.addFirst(13);
            myLinkedListFull.addFirst(12);
            myLinkedListFull.addFirst(11);
            System.out.println("----------------");
            MyLinkedListFull<Integer> myLinkedListFull_2 = myLinkedListFull.clone();
            myLinkedListFull_2.remove(5);
            myLinkedListFull_2.printList();
            System.out.println("---------------");
            myLinkedListFull.printList();
        }
    }
class Node<T> implements Cloneable {
    Node<T> next;
    T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Node<T> clone() throws CloneNotSupportedException {
        return (Node<T>) super.clone();
    }
}