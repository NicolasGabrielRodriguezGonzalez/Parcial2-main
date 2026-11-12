package Punto3;

public class Queue<T> {

    // Each node stores a value and a reference to the next node
    private static class Node<T> {
        private final T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front; // exit side: dequeue removes here
    private Node<T> rear;  // entry side: enqueue adds here
    private int size;      // counter so size() is O(1)

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;      // first node is both front and rear
        } else {
            rear.next = newNode;  // link the current last node to the new one
        }
        rear = newNode;           // the new node becomes the last one
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;       // move front to the next node
        if (front == null) {
            rear = null;          // queue is now empty: rear must not point to a removed node
        }
        size--;
        return data;
    }
}