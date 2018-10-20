package Homework_2;
/*****************************
 * John Sprunger
 * URL - https://drive.google.com/open?id=1g0C3nYtLOsSQ58ce7diDCge-EtPGVQXp
 * Class - COSC 311
 * Homework - hw0911
 * Semester - FALL 2018
 *****************************/
public class Test {
    public static void main(String[] args) {
        /** Test 1 */
        LinkedListHW test = new LinkedListHW();
        double[] arr1 = new double[]{100.0};
        addArr(arr1, test);
        System.out.println("Test 1 LinkedList - Unaltered: " + test.printList());
        System.out.println("Test 1 LinkedList Size: " + test.size());
        System.out.println("Test 1 LinkedList Sum: " + test.sum());
        System.out.println("Test 1 LinkedList Average: " + test.getAvg());
        test.subPar(test.getAvg());
        System.out.println("Test 1 LinkedList - Altered: " + test.printList());
        System.out.println("");
        test.deleteList();

        /** Test 2 */
        LinkedListHW test2 = new LinkedListHW();
        double[] arr2 = new double[]{10.0, 100.0, 10.0};
        addArr(arr2, test2);
        System.out.println("Test 2 LinkedList - Unaltered: " + test2.printList());
        System.out.println("Test 2 LinkedList Size: " + test2.size());
        System.out.println("Test 2 LinkedList Sum: " + test2.sum());
        System.out.println("Test 2 LinkedList Average: " + test2.getAvg());
        test.subPar(test2.getAvg());
        System.out.println("Test 2 LinkedList - Altered: " + test2.printList());
        System.out.println("");
        test2.deleteList();

        /** Test 3 */
        LinkedListHW test3 = new LinkedListHW();
        double[] arr3 = new double[]{100.0,  10.0,  15.0,  20.0,  200.0,  30.0,  40.0,  300.0};
        addArr(arr3, test3);
        System.out.println("Test 3 LinkedList - Unaltered: " + test3.printList());
        System.out.println("Test 3 LinkedList Size: " + test3.size());
        System.out.println("Test 3 LinkedList Sum: " + test3.sum());
        System.out.println("Test 3 LinkedList Average: " + test3.getAvg());
        test.subPar(test3.getAvg());
        System.out.println("Test 3 LinkedList - Altered: " + test3.printList());
    }

    public static void addArr(double[] arr, LinkedListHW test){
        for(int i = 0; i < arr.length; i++){
            test.prepend(arr[i]);
        }
    }
}
