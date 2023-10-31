public class CircularDoublyLinkedList {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to insert a node at the beginning of the list
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            head.prev = newNode;
            last.next = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to insert a node at the end of the list
    public void insertAtLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            head.prev = newNode;
            last.next = newNode;
        }
        size++;
    }

    // Method to insert a node at a particular index
    public void insertAt(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        if (index == 0) {
            insertAtFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int currentIndex = 0;

        while (currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    // Method to delete the first node
    public void deleteFirst() {
        if (head == null) {
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            Node last = head.prev;
            head = head.next;
            head.prev = last;
            last.next = head;
        }
        size--;
    }

    // Method to delete the last node
    public void deleteAtEnd() {
        if (head == null) {
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            Node last = head.prev;
            Node secondLast = last.prev;
            secondLast.next = head;
            head.prev = secondLast;
        }
        size--;
    }

    // Method to delete a node at a particular index
    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node current = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        Node prevNode = current.prev;
        Node nextNode = current.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }

    // Method to display the elements of the list
    public void display() {
        if (head == null) {
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);

        System.out.println(" (size: " + size + ")");
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList myList = new CircularDoublyLinkedList();

        myList.insertAtLast(1);
        myList.insertAtLast(2);
        myList.insertAtLast(3);

        myList.display();

        myList.insertAtFirst(0);
        myList.display();

        myList.insertAt(2, 2);
        myList.display();

        myList.deleteFirst();
        myList.display();

        myList.deleteAtEnd();
        myList.display();

        myList.deleteAt(1);
        myList.display();
    }
}