package LinkedListEx;

import javax.naming.OperationNotSupportedException;

public class BiDirectionalLinkedList extends LinkedList {
    BiDirectionalNode tail;

    class BiDirectionalNode extends Node {
        BiDirectionalNode prev;

        BiDirectionalNode(String d) {
            super(d);
        }
    }

    public BiDirectionalLinkedList reverse(LinkedList list) {
        BiDirectionalLinkedList bdList = new BiDirectionalLinkedList();
        if (list.head == null) {
            System.out.println("Empty List");
            return null;
        }

        Node iterNode = list.head;
        do {
            bdList = bdList.insert(iterNode.data);
            iterNode = iterNode.next;
        } while (iterNode != null);


        return bdList;

    }

    @Override
    public BiDirectionalLinkedList insert(String data) {
        // create a node
        BiDirectionalNode newNode = new BiDirectionalNode(data);

        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            Node iterNode = this.head;
            for (; iterNode.next != null; iterNode = iterNode.next) {
            }
            iterNode.next = newNode;
            newNode.prev = (BiDirectionalNode) iterNode;
            this.tail = newNode;
        }

        return this;
    }

    @Override
    public void printList(boolean fromTail) throws OperationNotSupportedException {
        if (fromTail == false) {
            super.printList(fromTail);
            return;
        }

        if (this.head == null) {
            System.out.println("Empty List");
            return;
        }

        BiDirectionalNode iterNode = this.tail;
        do {
            System.out.println(iterNode.data);
            iterNode = iterNode.prev;
        } while (iterNode != null);
    }}
