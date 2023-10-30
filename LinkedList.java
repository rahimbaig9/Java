public class LinkedList {
    private Node head;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to insert a node at the beginning of the list
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a node at the end of the list
    public void insertAtLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Method to insert a node at a particular index
    public void insertAt(int data, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative.");
        }

        if (index == 0) {
            insertAtFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete the first node
    public void deleteFirst() {
        if (head == null) {
            return;
        }

        head = head.next;
    }

    // Method to delete the last node
    public void deleteAtEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    // Method to delete a node at a particular index
    public void deleteAt(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative.");
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        current.next = current.next.next;
    }

    // Method to display the elements of the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

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
