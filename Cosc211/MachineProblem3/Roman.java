/*****************************************************************
 I (John Sprunger) was solely responsible for this class.
 It's main functionality is to handle the conversion of Roman
 numerals to Integers and Integers to Roman numerals.

 @author John Sprunger
 @version 1.0
 @date 11/2/2016
 *****************************************************************/
public class Roman {

    /** Holds the incoming Roman Numerals */
    private String roman;

    /** Constructor, takes in and sets Roman */
    public Roman(String roman){
        this.roman=roman;
    }

    /** Getter, displays roman */
    public String getRoman() {
        return roman;
    }

    /** Setter, sets the value for roman */
    public void setRoman(String roman) {
        this.roman = roman;
    }


    /*****************************************************************
     Converts passed in Roman Numeral to an Integer
     @param roman Set roman numeral
     @return value Converted roman numeral
     *****************************************************************/
    public int convert_Roman_to_int(String roman){
        int value = 0;
        int length = roman.length();
        // Loop through characters in the string.
        for (int i = 0; i < length; ) {
            // Look at the next character.
            char c = roman.charAt(i);
            // Also look at the following character, but be careful that we
            // might be at the end of the string.
            char n;
            if (i < length - 1)
                n = roman.charAt(i + 1);
            else
                // Use a character that won't match anything below.
                n = '?';

            // Accumulate value based on the next character or two characters.
            // If we use one character, advance i by one; if we use two
            // characters, advance i by two.
            if (c == 'M') {
                value += 1000;
                i += 1;
            } else if (c == 'C' && n == 'M') {
                value += 900;
                i += 2;
            } else if (c == 'D') {
                value += 500;
                i += 1;
            } else if (c == 'C' && n == 'D') {
                value += 400;
                i += 2;
            } else if (c == 'C') {
                value += 100;
                i += 1;
            } else if (c == 'X' && n == 'C') {
                value += 90;
                i += 2;
            } else if (c == 'L') {
                value += 50;
                i += 1;
            } else if (c == 'X' && n == 'L') {
                value += 40;
                i += 2;
            } else if (c == 'X') {
                value += 10;
                i += 1;
            } else if (c == 'I' && n == 'X') {
                value += 9;
                i += 2;
            } else if (c == 'V') {
                value += 5;
                i += 1;
            } else if (c == 'I' && n == 'V') {
                value += 4;
                i += 2;
            } else if (c == 'I') {
                value += 1;
                i += 1;
            } else {
                return -1;
            }
        }
        return value;
    }

    /*****************************************************************
     Converts passed in Integer to a Roman Numeral value
     @param number number to be converted
     @return result the result of the conversion in Roman Numeral
     *****************************************************************/
    public String convert_Int_to_Roman(int number){
        //Checks to see if the number is within range of conversion
        if (number < 1 || number >= 10000) {
            if(number > 10000)
                return "Error number too large";
            else
                return "Error number less than 1";
        }

        //A long list of boolean statements which takes the incoming number
        //and converts it's value into the proper Roman Numeral
        String result = "";
        while (number >= 1000) {
            result += "M";
            number -= 1000;
        }
        if (number >= 900) {
            result += "CM";
            number -= 900;
        }
        if (number >= 500) {
            result += "D";
            number -= 500;
        }
        if (number >= 400) {
            result += "CD";
            number -= 400;
        }
        while (number >= 100) {
            result += "C";
            number -= 100;
        }
        if (number >= 90) {
            result += "XC";
            number -= 90;
        }
        if (number >= 50) {
            result += "L";
            number -= 50;
        }
        if (number >= 40) {
            result += "XL";
            number -= 40;
        }
        while (number >= 10) {
            result += "X";
            number -= 10;
        }
        if (number >= 9) {
            result += "IX";
            number -= 9;
        }
        if (number >= 5) {
            result += "V";
            number -= 5;
        }
        if (number >= 4) {
            result += "IV";
            number -= 4;
        }
        while (number > 0) {
            result += "I";
            number -= 1;
        }

        return result;
    }
}
