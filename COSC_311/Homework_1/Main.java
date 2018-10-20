package Homework_1;
/*****************************
 * John Sprunger
 * URL - https://drive.google.com/file/d/1c08rIRaWl03gpSf-SaYxmnxqVN4Ypakc/view?usp=sharing
 * Class - COSC 311
 * Homework - hw0906
 * Semester - FALL 2018
*****************************/
public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int factor;

        System.out.println("Test one : factor = 1");
        factor = 1;
        System.out.print("a[] = ");
        printArray(a);
        System.out.print("b[] = ");
        printArray(repeat(a, factor));

        System.out.println('\n' + "Test two : factor = 2");
        factor = 2;
        System.out.print("a[] = ");
        printArray(a);
        System.out.print("b[] = ");
        printArray(repeat(a, factor));

        System.out.println('\n' + "Test three : factor = -2");
        factor = -2;
        System.out.print("a[] = ");
        printArray(a);
        System.out.print("b[] = ");
        printArray(repeat(a, factor));
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i] + " ");
        System.out.println();
    }

    public static int[] repeat(int[] a, int factor){
        if(factor < 1){
            int[] blank = new int[0];
            return blank;
        }

        int[] b = new int[a.length * factor];
        for (int i = 0; i < b.length; i++) {
            b[i] = (i > a.length - 1) ? a[i - a.length] : a[i];
        }

        return b;
    }
}