package Homework_4;
/*****************************
 * John Sprunger
 * URL - https://drive.google.com/open?id=1g0C3nYtLOsSQ58ce7diDCge-EtPGVQXp
 * Class - COSC 311
 * Homework - hw1011
 * Semester - FALL 2018
 *****************************/

public class Main {
    public static void main(String[] args) {
        CircleQueue test1 = new CircleQueue(10);
        int x = test1.randNum.nextInt(5);
        int y = test1.randNum.nextInt(5);
        int count = 0;
        int inserts = test1.randNum.nextInt(99);

        while(x < count){
            inserts = test1.randNum.nextInt(99);
            test1.insert(inserts);
            count++;
        }

        while(y < count){
            test1.delete();
            count++;
        }

        System.out.println(y);
    }
}
