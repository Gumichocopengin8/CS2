/******************************************
 *
 * Keita Nonaka, Koki Omori
 * Data: 3/26/2018 pi day!!
 * Program 7
 ////////////////////////////////////////////////////////////////////////////////
 *
 * This is a program for calculating prefix expressions using recursion.
 *
 *******************************************/

import java.util.*;

public class Prefix {
    private Scanner line;  // scanner

    public Prefix(Scanner s){ // need a non default constructor
        line = s; // assignment
    }

    public double result () { // recursion
        String token; // token
        double a; // first variable
        double b; // second variable
        if(line.hasNext()) {
            token = line.next();
        } else
            throw new IllegalArgumentException("Invalid expression");

        if(token.equals("+")){ // addition
            a = result();
            b = result();
            return a + b;
        } else if(token.equals("-")){ // subtraction
            a = result();
            b = result();
            return a - b;
        } else if(token.equals("*")){ // multiplication
            a = result();
            b = result();
            return a * b;
        }else if(token.equals("/")){ // division
            a = result();
            b = result();
            if(b == 0)
                throw new IllegalArgumentException("0 division exception"); // throw
            return a / b;
        }else // then it's a constant in the expression
            return Double.parseDouble(token); // this could throw an exception if it's not a number!
    }
}

