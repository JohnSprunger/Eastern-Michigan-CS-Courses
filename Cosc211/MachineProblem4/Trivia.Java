/*****************************************************************
 A class created to handle the creation of my Trivia objects,
 takes in questions, answers, and allows the developer to
 change the number of points per question.

 @author John Sprunger
 @version 1.0
 @date 11/21/2016
 *****************************************************************/
public class Trivia implements java.io.Serializable{

    /** Instance variables for setting up my questions, answer, and user points */
    private String myQuestion;
    private String myAnswer;
    private int ansPoints;

    /** Default Constructor to initialize instance variables */
    public Trivia(){
        this.myAnswer = "";
        this.myQuestion = "";
        this.ansPoints = 1;
    }

    /** Overloaded Constructor that takes in a question and answer */
    public Trivia(String myQuestion, String myAnswer) {
        this.myQuestion = myQuestion;
        this.myAnswer = myAnswer;
        this.ansPoints = 1;
    }

    /** Getter for question */
    public String getMyQuestion() {
        return myQuestion;
    }

    /** Setter for question */
    public void setMyQuestion(String myQuestion) {
        this.myQuestion = myQuestion;
    }

    /** Getter for answer */
    public String getMyAnswer() {
        return myAnswer;
    }

    /** Setter for answer */
    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    /** Getter for points */
    public int getAnsPoints() {
        return ansPoints;
    }

    /** Setter for points */
    public void setAnsPoints(int ansPoints) {
        this.ansPoints = ansPoints;
    }
}

