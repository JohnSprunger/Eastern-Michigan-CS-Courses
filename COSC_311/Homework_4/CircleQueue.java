package Homework_4;
import java.util.Random;
/*****************************
 * John Sprunger
 * URL - https://drive.google.com/open?id=1g0C3nYtLOsSQ58ce7diDCge-EtPGVQXp
 * Class - COSC 311
 * Homework - hw1011
 * Semester - FALL 2018
 *****************************/

public class CircleQueue {
    /*  the data structure   */
    public static int q[];                // array
    public static int  head, tail;        // indexes into q[]
    public static Random randNum;

    public CircleQueue(){}

    public CircleQueue(int size){
        q = new int[size];
        initialize();
    }

    /* initialize queue pointers */
    public static void initialize() {
        head = tail = 0;
        randNum = new Random();
        randNum.setSeed(3);
    }

    /* test for full */
    public static boolean isFull() { return head == tail + 1; }

    /* test for empty */
    public static boolean isEmpty() { return head == tail; }

    /* insert x at tail */
    public static void insert(int x) {
        if (!isFull())
            q[tail++] = x;

        else System.out.println("The queue is full.");
    }

    public void printQueue() {
            for (int i = 0; i < q.length - 1; i ++)
                System.out.print(q[i]);
    }

    /* delete from head */
    public static int delete() {
        if (!isEmpty())
            return q[head++];

        System.out.println("The queue is empty.");
        return 0;
    }
}
