package Homework_3;


import java.util.Random;

public class CircleList {

    /*  the data structure   */
    public static int q[];                // array
    public static int  head, tail;        // indexes into q[]

    public CircleList(){}

    public static void createList(int size){
        q = new int[size];
        initialize();
    }

    /* initialize queue pointers */
    public static void initialize() {
        head = tail = 0;
    }

    /* test for full */
    public static boolean isFull() {
        return head == tail + 1;
    }

    /* test for empty */
    public static boolean isEmpty() {
        return head == tail;
    }

    /* insert x at tail */
    public static void insert(int x) {
        if (!isFull())
            q[tail++] = x;

        else isEmpty();
    }

    /* delete from head */
    public static int delete() {
        if (!isEmpty())
            return q[head++];

        isFull();
        return 0;
    }

    /* print from head to tail */
    /* note, this is not a queue operation, but is handy for debugging */
    public void printQueue() {
        if (!isEmpty())
            for (int i = head; i != tail-1; i ++)
                System.out.print(q[i]);
    }

    public static void insertDelete(){

    }

    public static void main(String[] args) {
        //Number of operations to time
        final int k = 10000;
        final int K = 15000;
        long startTime;
        long endTime;
        long duration;
        int count = 0;
        Random random = new Random();

        /** timing for n == 10 */
        createList(10);
        startTime = System.nanoTime();
        while(k > count){
            if(random.nextInt(2) == 0){
                insert(8);
            }
            else{
                delete();
            }
            count++;
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Time for k = 10000 & q = 10: " + duration);


    }

}