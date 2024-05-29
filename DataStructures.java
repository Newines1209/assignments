public class DataStructures {

    public static void main(String[] args) {

        //  Stack
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack:");
        stack.display();
        stack.pop();
        System.out.println("After popping:");
        stack.display();

        // Linked List
        LinkedList list = new LinkedList();
        list.insertAtPos(1, 10);
        list.insertAtPos(2, 20);
        list.insertAtPos(3, 30);
        System.out.println("Linked List:");
        list.display();
        list.deleteAtPosition(2);
        System.out.println("After deleting at position 2:");
        list.display();
    }

    static class Stack {
        Node top;

        Stack() {
            top = null;
        }

        void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }

        void pop() {
            if (top == null) {
                System.out.println("Stack is empty");
            } else {
                top = top.next;
            }
        }

        int peek() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1;
            } else {
                return top.data;
            }
        }

        boolean isEmpty() {
            return top == null;
        }

        void display() {
            Node currNode = top;
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    }

    static class LinkedList {
        Node head;

        LinkedList() {
            head = null;
        }

        void insertAtPos(int position, int value) {
            Node newNode = new Node(value);

            if (position == 1) {
                newNode.next = head;
                head = newNode;
            } else {
                Node temp = head;

                for (int i = 1; i < position - 1 && temp != null; i++) {
                    temp = temp.next;
                }

                if (temp == null) {
                    System.out.println("Invalid position");
                } else {
                    newNode.next = temp.next;
                    temp.next = newNode;
                }
            }
        }

        void deleteAtPosition(int position) {
            if (head == null) {
                System.out.println("Empty list");
            } else if (position == 1) {
                head = head.next;
            } else {
                Node temp = head;
                for (int i = 1; i < position - 1 && temp != null; ++i) {
                    temp = temp.next;
                }
                if (temp != null && temp.next != null) {
                    temp.next = temp.next.next;
                } else {
                    System.out.println("Invalid position");
                }
            }
        }

        void display() {
            for (Node currNode = head; currNode != null; currNode = currNode.next) {
                System.out.print(currNode.data + " ");
            }
            System.out.println();
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }
}
