/*
Keita Nonaka
CS2 Lab2, Making POLYNOMIAL formula. 1.26.b
1/31/2018
////////////////////////////////////////////////////////////////////////////////
This is for making polynomial. I need to use class to learn object oriented data
structure.
*/

import java.util.Scanner;
public class PolynomialApp {
    private double[] coefficient;  // array for store coefficient
    private int i = 0; // counter

    public PolynomialApp(int degree) {    // constructor
        coefficient = new double[degree + 1];
    }

    public void setCoefficient(double num) { // setter
        this.coefficient[this.i++] = num;
    }

    ///////////  // calculate the formula using the value
    public double evaluate(double value) {
        double eval = 0;  // store the value of formula
        for (int i = 0; i < this.coefficient.length; i++) {
            eval += this.coefficient[i] * Math.pow(value, this.coefficient.length - 1 - i); // calculating using pow
        }
        return eval;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String ans; // for asking continue

        System.out.print("Input parameter, such as 3 5 0 2 -3> ");
        int degree = cin.nextInt(); // get a degree
        PolynomialApp myapp = new PolynomialApp(degree);    // object
        for(int i = 0; i < degree + 1; i++){
            double coefficient = cin.nextDouble();
            myapp.setCoefficient(coefficient);
        }

        do {  // looping until ans is other than Yes or y.
            System.out.print("Enter a value> ");
            double val = cin.nextDouble();
            System.out.println("The result is " + myapp.evaluate(val)); // evaluation
            System.out.print("Continue?> ");
            ans = cin.next();
        }while (ans.equals("Yes") || ans.equals("y"));
    }
}
