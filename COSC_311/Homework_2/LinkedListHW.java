package Homework_2;
/*****************************
 * John Sprunger
 * URL - https://drive.google.com/open?id=1g0C3nYtLOsSQ58ce7diDCge-EtPGVQXp
 * Class - COSC 311
 * Homework - hw0911
 * Semester - FALL 2018
 *****************************/
public class LinkedListHW {
    public class Node{
        private Node next;
        private double data;

        public Node(){}

        public Node(double data){
            this.data = data;
        }

        public Node(double data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node getNext(){
            return this.next;
        }

        public double getData(){ return this.data; }
    }

    private static Node head;
    public LinkedListHW(){}

    public String printList(){
        Node current = head;
        String result = current.data + " ";

        while(current.getNext() != null){
            current = current.getNext();
            result += current.data + " ";
        }

        return result;
    }

    public void append(double data){
        if(head == null){
            head = new Node(data);
            return;
        }

        Node current = new Node(data);

        current.next = head;

        head = current;
    }

    public Node getHead(){
        return head;
    }

    public void delete(){
        if(head == null)
            return;

        // Store head node
        Node current = head;

        head = current.next;

        // Find previous node of the node to be deleted
        for (int i = 0; current != null; i++)
            current = current.next;

        // If position is more than number of ndoes
        if (current == null || current.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = current.next.next;

        current.next = next;  // Unlink the deleted node from list
    }

    public void prepend(double data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteList(){
        while(head.getNext() != null){
            delete();
        }

        head = null;
    }

    public int size(){
        Node current = head;
        if(current.getNext() == null)
            return 1;

        int size = 1;

        while(current.getNext() != null){
            current = current.next;
            size ++;
        }

        return size;
    }

    public double sum(){
        double sum = 0.0;
        Node current = head;

        while(current != null){
            sum += current.data;
            current = current.next;
        }

        return sum;
    }

    public double getAvg(){ return sum() / size(); }

    public void subPar(double avg) {
        if(this.head == null) return;

        if(head.getData() > avg) head = head.next;

        Node previous = null;
        Node current = head;

        while(current != null){
            if(current.getData() > getAvg()){
                if(previous == null) {
                    Node node = current.getNext();
                    current.next = previous;
                    previous = node;
                    current = previous.getNext();
                    head = previous;
                }
                else{
                    Node node = current.getNext();
                    previous.next = node;
                    current.next = null;
                    current = node;
                }
            }
            else {
                previous = current;
                current = current.getNext();
            }
        }
    }
}
