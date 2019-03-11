package LinkedListEx;


import javax.naming.OperationNotSupportedException;

public class LinkedList {

    Node head;

    class Node {
        String data;
        Node next;

        Node(String d) {
            this.data = d;
        }

    }

    public LinkedList insert(String data) {
        // create a node
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        }
        else {
            Node iterNode = this.head;
            for (; iterNode.next != null; iterNode = iterNode.next) {
            }
            iterNode.next = newNode;
        }

        return this;
    }

    public void printList() throws OperationNotSupportedException {
        this.printList(false);
    }

    public void printList(boolean fromTail) throws OperationNotSupportedException {
        if (fromTail == true) {
            throw new OperationNotSupportedException("Only for "+BiDirectionalLinkedList.class.getName());
        }
        if (this.head == null) {
            System.out.println("Empty List");
            return;
        }

        Node iterNode = this.head;
        do {
            System.out.println(iterNode.data);
            iterNode = iterNode.next;
        } while (iterNode != null);
    }

    public void printReverseList(Node iterNode) {
        if (iterNode != null) {
            printReverseList(iterNode.next);
            System.out.println(iterNode.data);
        }
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        LinkedList inst = new LinkedList();

        inst = inst.insert("a");
        inst.printList();
        System.out.println("-------");

        inst = inst.insert("b");
        inst.printList();
        System.out.println("-------");

        inst = inst.insert("c");
        inst.printList();
        System.out.println("-------");

        inst = inst.insert("d");
        inst.printList();
        System.out.println("-------");

        inst = inst.insert("e");
        inst.printList();
        System.out.println("-------");

        inst.printReverseList(inst.head);
        System.out.println("-------");

        BiDirectionalLinkedList inst2 = new BiDirectionalLinkedList();
        inst2 = inst2.reverse(inst);
        System.out.println("---++---");
        inst2.printList(false);
        System.out.println("---++---");
        inst2.printList(true);
        System.out.println("---++---");

    }


}
