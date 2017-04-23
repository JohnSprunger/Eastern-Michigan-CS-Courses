import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*****************************************************************
 The Test class holds the  main functionality of the program
 it handles setting up the questions, setting them to a binary
 file, reading them back from a binary file, then randomizing
 the order so the user can attempt to answer the trivia questions.

 @author John Sprunger
 @version 1.0
 @date 11/21/2016
 *****************************************************************/
public class Test implements java.io.Serializable{

    /** Set's up the file name */
    private final static String fileName = "trivia.ser";

    /** A temp array to help the readBinary method */
    private static Trivia[] tempArray;

    /** The questions read back and randomized */
    private static ArrayList<Trivia> randomQuestions = new ArrayList<>();

    /** The number of points the user has */
    private static int usersPoints = 0;

    /*****************************************************************
     The main method, used for setting up the Trivia questions,
     adding them to an ArrayList, and running the read and write binary
     methods, followed by setting and asking the user the
     aforementioned Trivia questions.
     *****************************************************************/
    public static void main(String[] args) {
        //Trivia questions
        Trivia quest1 = new Trivia("Who invented C++? ","Bjarne Stroustrup");
        Trivia quest2 = new Trivia("Who invented C? ","Dennis Ritchie");
        Trivia quest3 = new Trivia("Who invented Java? ","James Gosling");
        Trivia quest4 = new Trivia("Who invented JavaScript? ","Brendan Eich");
        Trivia quest5 = new Trivia("Who invented Linux? ","Linus Torvalds");

        //ArrayList for trivia questions
        ArrayList<Trivia> triviaQuestions = new ArrayList<>();

        //Adding the trivia questions
        triviaQuestions.add(quest1);
        triviaQuestions.add(quest2);
        triviaQuestions.add(quest3);
        triviaQuestions.add(quest4);
        triviaQuestions.add(quest5);

        writeBinary(triviaQuestions);
        readBinary();
        setQuestions();
        askQuestions();

        //Output message thanking the user
        System.out.println("Thanks for playing my trivia game, your final score was: " + usersPoints);
    }

    /*****************************************************************
     The write binary method takes in a list of trivia questions
     and writes them to a binary file.
     *****************************************************************/
    public static void writeBinary(ArrayList<Trivia> triviaQuestions){
        try {
            //Output to the file
            FileOutputStream fileOS = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOS);

            //Writes all the trivia questions
            for(int i = 0; i < triviaQuestions.size(); i++){
                os.writeObject(triviaQuestions.get(i));
            }
            os.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /*****************************************************************
     The read binary method takes the freshly written binary file
     and reads it back into a temporary array.
     *****************************************************************/
    public static void readBinary(){
        //Temporary question ArrayList
        ArrayList<Trivia> tempQuestions = new ArrayList<>();
        Trivia tempQAPair;

        try{
            //File input
            FileInputStream fileIS = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fileIS);

            //For loop that reads in my objects and sends them to the temp ArrayList
            for(int j = 0; j < 5; j++){
                tempQAPair = (Trivia)is.readObject();
                tempQuestions.add(tempQAPair);
            }

            tempArray = tempQuestions.toArray(new Trivia[tempQuestions.size()]);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*****************************************************************
     Set questions takes the temporary array and transfers it to
     an ArrayList, then randomizes the order of the questions.
     *****************************************************************/
    public static void setQuestions(){
        //A for loop that copies the temporary array to the random ArrayList
        for(int i = 0; i < tempArray.length; i++){
            randomQuestions.add(tempArray[i]);
        }

        //Randomizes the ArrayList
        Collections.shuffle(randomQuestions);
    }

    /*****************************************************************
     Ask questions prints out the randomize questions and then
     takes the users input to see if he/she is getting the correct
     answers.
     *****************************************************************/
    public static void askQuestions(){
        //Scanner object
        Scanner answerMe = new Scanner(System.in);

        //Stores scanned in answer
        String userAnswer;

        //For loop to that loops through the random questions and test if the user has the correct answer
        for (int i = 0; i < randomQuestions.size(); i++) {
            System.out.println(randomQuestions.get(i).getMyQuestion());
            System.out.print("What is your answer?: ");
            userAnswer = answerMe.nextLine();

            //Is the answer correct?
            if(userAnswer.equals(randomQuestions.get(i).getMyAnswer())) {
                System.out.println("Correct you've earned 1 point!");
                usersPoints++;
            }
            else
                System.out.println("Incorrect the answer is: " + randomQuestions.get(i).getMyAnswer());
        }
    }
}
