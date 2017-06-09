//Linked list program
package linkedlist;

public class LinkedList {

    private Node head;

    // Size method for finding the size of the list
    public int size() {
        int n = 0;
        Node current = this.head;
        while (current != null) {
            n++;
            current = current.next;
        }
        return n;
    }
    
    //Get method for getting the value at the corresponding index position
    public Object get(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n = 0;
        Node current = this.head;
        while (current != null) {
            if (n == idx) {
                return current.val;
            }
            n++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException();
    }
    
    //This is for setting new value at the index mentioned
    public void set(int idx, Object o) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n = 0;
        Node current = this.head;
        while (current != null) {
            if (n == idx) {
                current.val = o;
                return;
            }
            n++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException();
    }
    
    // this is for adding new value to the end of the linked list
    public int append(Object o) {
        if (this.head == null) {
            this.head = new Node();
            this.head.val = o;
            return 1;
        }
        int n = 1;
        Node current = this.head;
        Node prev = null;
        while (current != null) {
            n++;
            prev = current;
            current = current.next;
        }
        prev.next = new Node();
        prev.next.val = o;
        return n;
    }
    
    // this method is for getting the node at the corresponding index
    public Node getNode(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n = 0;
        Node current = this.head;
        while (current != null) {
            if (n == idx) {
                return current;
            }
            n++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException();
    }

    //this method is to insert new object at the index position mentioned
    public void insert(int idx, Object o) {
        
        if(idx == 0) {
            Node b = getNode(idx);
            Node a = new Node();
            this.head = a;
            a.val = o;
            a.next = b;
        } else {    
        Node x = getNode(idx);
        Node y = getNode(idx-1);
        Node z = new Node();
        z.val = o;
        y.next = z;
        z.next = x; }
        
        
    }
    
    //Main method
    //includes test cases
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append("hi");
        list.append("yo");
        list.append("bye");
        list.set(1, "au revoir");
        System.out.println(list.size());
        list.insert(0, "first");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        list.insert(1, "replace");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }

}

class Node {
    public Object val;
    public Node next;
}