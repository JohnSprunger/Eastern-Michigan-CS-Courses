import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*****************************************************************
 Program Description:
 Graphical representation of a Roman Numeral Conversion Calculator
 Allows user to enter in Roman Numerals and have the values
 converted into integers and then modified by addition,
 subtraction, multiplication, division, and modulus buttons.

 @author John Sprunger, Aman
 @version 1.0
 @date 11/2/2016
 @class COSC 211 - Programming Data Structures
 @assignment Machine Problem #3
 *****************************************************************/
public class RomanCalculator extends JFrame{

    /** Accessors to the Roman Class */
    private Roman newRome;
    private Roman newRome2;

    /** The Frame for the GUI */
    private JFrame romFrame;

    /** Text boxes to handle input and output */
    private JTextField romanText;
    private JTextField romanText1;
    private JTextField romanTot;
    private JTextField intText;
    private JTextField intText1;
    private JTextField intTot;

    /** Buttons for the user interface */
    private JButton btnMin;
    private JButton btnMul;
    private JButton btnPls;
    private JButton btnMod;
    private JButton btnDiv;
    private JButton btnEql;
    private JButton btnCe;
    private JButton btnC;
    private JButton btnD;
    private JButton btnV;
    private JButton btnM;
    private JButton btnX;
    private JButton btnL;
    private JButton btnI;
    private String display = "";
    private Integer tempTot;


    /*****************************************************************
     A constructor for the RomanCalculator Class
     This is the main method of the application.
     It handles the construction and placement of the entire GUI.
     *****************************************************************/
    RomanCalculator(){

        /** The next block of code handles the creation of the frame*/
        //Super to handle the extension
        super("Roman Calculator");
        newRome = new Roman("");
        newRome2 = new Roman("");
        romFrame = new JFrame();
        romFrame.setBounds(100, 100, 357, 302);
        romFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        romFrame.getContentPane().setLayout(null);
        romFrame.setTitle("Roman Calculator");


        /*****************************************************************
         The next block of code handles the creation of textboxes in the
         GUI
         *****************************************************************/
        /** Roman textbox 1 */
        romanText = new JTextField();
        romanText.setBounds(18, 34, 152, 17);
        romFrame.getContentPane().add(romanText);
        romanText.setColumns(10);

        /** Roman textbox 2 */
        romanText1 = new JTextField();
        romanText1.setBounds(18, 5, 152, 17);
        romanText1.setColumns(10);
        romFrame.getContentPane().add(romanText1);

        /** Roman result box */
        romanTot = new JTextField("Result");
        romanTot.setBounds(18, 63, 152, 17);
        romanTot.setColumns(10);
        romanTot.setEditable(false);
        romFrame.getContentPane().add(romanTot);

        /** Integer box 1 */
        intText = new JTextField("Integer1");
        intText.setBounds(196, 5, 152, 17);
        intText.setColumns(10);
        intText.setEditable(false);
        romFrame.getContentPane().add(intText);

        /** Integer box 2 */
        intText1 = new JTextField("Integer2");
        intText1.setBounds(196, 34, 152, 17);
        intText1.setColumns(10);
        intText1.setEditable(false);
        romFrame.getContentPane().add(intText1);

        /** Integer Results */
        intTot = new JTextField("Integer3");
        intTot.setBounds(196, 63, 152, 17);
        intTot.setColumns(10);
        intTot.setEditable(false);
        romFrame.getContentPane().add(intTot);


        /*****************************************************************
         The next block of code handles the creation of the Roman
         Numeral buttons on the GUI
         *****************************************************************/
        /** I button */
        btnI = new JButton("I");
        btnI.setBounds(18, 88, 70, 35);
        romFrame.getContentPane().add(btnI);
        IButton iButton = new IButton();
        btnI.addActionListener(iButton);

        /** V button */
        btnV = new JButton("V");
        btnV.setBounds(100, 88, 70, 35);
        romFrame.getContentPane().add(btnV);
        VButton vButton = new VButton();
        btnV.addActionListener(vButton);

        /** C button */
        btnC = new JButton("C");
        btnC.setBounds(18, 135, 70, 35);
        romFrame.getContentPane().add(btnC);
        CButton cButton = new CButton();
        btnC.addActionListener(cButton);

        /** D button */
        btnD = new JButton("D");
        btnD.setBounds(100, 135, 70, 35);
        romFrame.getContentPane().add(btnD);
        DButton dButton = new DButton();
        btnD.addActionListener(dButton);

        /** X button */
        btnX = new JButton("X");
        btnX.setBounds(196, 91, 70, 35);
        romFrame.getContentPane().add(btnX);
        XButton xButton = new XButton();
        btnX.addActionListener(xButton);

        /** L button */
        btnL = new JButton("L");
        btnL.setBounds(278, 91, 70, 35);
        romFrame.getContentPane().add(btnL);
        LButton lButton = new LButton();
        btnL.addActionListener(lButton);

        /** M button */
        btnM = new JButton("M");
        btnM.setBounds(196, 138, 70, 35);
        romFrame.getContentPane().add(btnM);
        MButton mButton = new MButton();
        btnM.addActionListener(mButton);


        /*****************************************************************
         The next block of code handles the creation of the arithmetic
         buttons on the GUI
         *****************************************************************/
        /** + button */
        btnPls = new JButton("+");
        btnPls.setBounds(100, 182, 70, 35);
        romFrame.getContentPane().add(btnPls);
        AddButton addButton = new AddButton();
        btnPls.addActionListener(addButton);

        /** = button */
        btnEql = new JButton("=");
        btnEql.setBounds(100, 229, 70, 35);
        romFrame.getContentPane().add(btnEql);
        EqlButton eqlButton = new EqlButton();
        btnEql.addActionListener(eqlButton);

        /** - button */
        btnMin = new JButton("-");
        btnMin.setBounds(18, 182, 70, 35);
        romFrame.getContentPane().add(btnMin);
        SubButton subButton = new SubButton();
        btnMin.addActionListener(subButton);

        /** * button */
        btnMul = new JButton("*");
        btnMul.setBounds(18, 229, 70, 35);
        romFrame.getContentPane().add(btnMul);
        MulButton mulButton = new MulButton();
        btnMul.addActionListener(mulButton);

        /** CE button */
        btnCe = new JButton("CE");
        btnCe.setBounds(278, 138, 70, 35);
        romFrame.getContentPane().add(btnCe);
        ClrButton clrButton = new ClrButton();
        btnCe.addActionListener(clrButton);

        /** / button */
        btnDiv = new JButton("/");
        btnDiv.setBounds(196, 185, 70, 35);
        romFrame.getContentPane().add(btnDiv);
        DivButton divButton = new DivButton();
        btnDiv.addActionListener(divButton);

        /** % button */
        btnMod = new JButton("%");
        btnMod.setBounds(278, 185, 70, 35);
        romFrame.getContentPane().add(btnMod);
        ModButton modButton = new ModButton();
        btnMod.addActionListener(modButton);
    }

    /*****************************************************************
     getNumbers is a method I created to handle the constant task
     of getting numbers from the gui and populating the appropriate
     text boxes.
     *****************************************************************/
    public void getNumbers(){
        if(romanText1.getText() != "" && romanText.getText() != ""){
            newRome.setRoman(romanText.getText());
            newRome2.setRoman(romanText1.getText());
            Integer tempInt = newRome.convert_Roman_to_int(newRome.getRoman());
            Integer tempInt2 = newRome2.convert_Roman_to_int(newRome2.getRoman());
            intText.setText(tempInt2.toString());
            intText1.setText((tempInt.toString()));
        }
    }

    /*****************************************************************
     The next section of code is where I start to implement my action
     listener classes to give the GUI it's functionality
     *****************************************************************/

    /*****************************************************************
     The upcoming block of classes handles the basic functionality
     of the Roman Numeral buttons adding text to the textboxes
     *****************************************************************/
    /** Set's text for the V button */
    private class VButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = romanText.getText();
            romanText.setText(display + "V");
        }

    }

    /** Set's text for the C button */
    private class CButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            display = romanText1.getText();
            romanText1.setText(display + "C");
        }
    }

    /** Set's text for the D button */
    private class DButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            display = romanText1.getText();
            romanText1.setText(display + "D");
        }
    }

    /** Set's text for the M button */
    private class MButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            display = romanText.getText();
            romanText.setText(display + "M");
        }
    }

    /** Set's text for the X button */
    private class XButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            display = romanText1.getText();
            romanText1.setText(display + "X");
        }
    }

    /** Set's text for the L button */
    private class LButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            display = romanText.getText();
            romanText.setText(display + "L");
        }
    }

    /** Set's text for the I button */
    private class IButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            display = romanText.getText();
            romanText.setText(display + "I");
        }
    }


    /*****************************************************************
     The next block of classes gives the arithmetic buttons their
     functionality
     *****************************************************************/
    /** Add's two integer values */
    private class AddButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            getNumbers();
            int temp1 = Integer.parseInt(intText.getText());
            int temp2 = Integer.parseInt(intText1.getText());
            tempTot = temp1 + temp2;
        }
    }

    /** Subtract two integer values */
    private class SubButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(romanText1.getText() != "" && romanText.getText() != ""){
                getNumbers();
                int temp1 = Integer.parseInt(intText.getText());
                int temp2 = Integer.parseInt(intText1.getText());
                tempTot = temp1 - temp2;
            }
        }
    }

    /** Multiply two integer values */
    private class MulButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(romanText1.getText() != "" && romanText.getText() != ""){
                getNumbers();
                int temp1 = Integer.parseInt(intText.getText());
                int temp2 = Integer.parseInt(intText1.getText());
                tempTot = temp1 * temp2;
            }
        }
    }

    /** Divide two integer values */
    private class DivButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(romanText1.getText() != "" && romanText.getText() != ""){
                getNumbers();
                int temp1 = Integer.parseInt(intText.getText());
                int temp2 = Integer.parseInt(intText1.getText());
                tempTot = temp1 / temp2;
            }
        }
    }

    /** Gives the remainder of two integer values */
    private class ModButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(romanText1.getText() != "" && romanText.getText() != ""){
                getNumbers();
                int temp1 = Integer.parseInt(intText.getText());
                int temp2 = Integer.parseInt(intText1.getText());
                tempTot = temp1 % temp2;
            }
        }
    }

    /** Takes the calculation performed and displays the results */
    private class EqlButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            intTot.setText(tempTot.toString());
            String tempRom = newRome.convert_Int_to_Roman(tempTot);
            romanTot.setText(tempRom);
        }
    }

    /** Clears all textboxes */
    private class ClrButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            romanTot.setText("");
            romanText.setText("");
            romanText1.setText("");
            intText.setText("");
            intText1.setText("");
            intTot.setText("");
        }
    }

    
    /*****************************************************************
     The main method, it launches the GUI
     *****************************************************************/
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RomanCalculator window = new RomanCalculator();
                    window.romFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

