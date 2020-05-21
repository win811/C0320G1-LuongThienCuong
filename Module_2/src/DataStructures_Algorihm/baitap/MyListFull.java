package DataStructures_Algorihm.baitap;

import java.util.Arrays;

public class MyListFull<T> implements Cloneable {
    int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyListFull() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyListFull (int capacity) {
        elements = new Object[capacity];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(T data) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = data;
    }
    public void add (int index,T data) {
        if (size == elements.length) {
            ensureCapa();
        }
        Object[] tempArray = new Object[elements.length + 1];
        System.arraycopy(elements,0,tempArray,0,index-1);
        tempArray[index-1] = data;
        System.arraycopy(elements,index-1,tempArray,index,elements.length - (index-1));
        elements = tempArray;
        size++;
    }
    public void remove (int index) {
        Object[] tempArray = new Object[elements.length - 1];
        System.arraycopy(this.elements,0,tempArray,0,index-1);
        System.arraycopy(this.elements,index,tempArray,index-1,this.elements.length - index);
        this.elements = tempArray;
    }
    public T get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (T) elements[i];
    }
    public int size () {
        return size;
    }
    public int indexOf (T data) {
        for (int i = 0; i < this.elements.length;i++) {
            if (this.elements[i] == data) {
                return i+1;
            }
        }
        return -1;
    }
    public boolean contains (T data) {
        return indexOf(data) != -1;
    }
    public void clear() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }
    public void print () {
        for (Object value : this.elements) {
            if (value != null) {
                System.out.println(value);
            }
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public MyListFull<T> clone() throws CloneNotSupportedException {
        return (MyListFull<T>) super.clone();
    }
}
class TestMyListFull {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyListFull<Integer> myListFull = new MyListFull<>();
        myListFull.add(1);
        myListFull.add(3);
        myListFull.add(4);
        myListFull.add(5);
        myListFull.add(6);
        MyListFull<Integer> myListFull1_2 = myListFull.clone();
        myListFull.remove(2);
        myListFull.print();
        System.out.println("--------");
        myListFull1_2.print();
    }
}
