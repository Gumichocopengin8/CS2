 /*
Keita Nonaka
CS2 Lab2, Making POLYNOMIAL formula. 1.26.a
1/31/2018
////////////////////////////////////////////////////////////////////////////////
This is for making polynomial. I need to use class to learn object oriented data
structure.
 */

 public class Polynomial {
    private double[] coefficient;  // array for store coefficient

    public Polynomial(int degree){    // constructor
        this.coefficient = new double[degree + 1];
    }

    public void setCoefficient(int degree, double num){ // setter
        this.coefficient[this.coefficient.length - (degree + 1)] += num;
    }

    ///////////  // calculate the formula using the value
    public double evaluate(double value){
        double eval = 0.0;  // store the value of formula
        for(int i = 0; i < this.coefficient.length; i++){
            eval += this.coefficient[i] * Math.pow(value, this.coefficient.length - 1 - i); // calculating using pow
        }
        return eval;
    }

    public static void main(String[] args) {
        Polynomial myPoly = new Polynomial(3); // object
        myPoly.setCoefficient(3, 1);
        myPoly.setCoefficient(3, 4);
        myPoly.setCoefficient(1, 2);
        myPoly.setCoefficient(0, -3);
        System.out.println(myPoly.evaluate(1));  // evaluation
    }
}
