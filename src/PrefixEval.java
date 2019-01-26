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

public class PrefixEval {
    public static void main (String argv[]) {
        Scanner lineInput = new Scanner(System.in);
        System.out.println("This is a program for calculating prefix expressions.");
        System.out.println("You may use these operators ... +, -, *, / \n");
        System.out.print("Enter an prefix expression: ");

        while(lineInput.hasNextLine()) {
            String line = lineInput.nextLine();
            Scanner expr = new Scanner(line);
            Prefix p = new Prefix(expr);
            try{
                double r = p.result();
                if(expr.hasNext())
                    throw new IllegalArgumentException("Invalid expression");
                System.out.println(line + " = " + r);
            } catch (Exception e){
                System.out.println("Error with input:"+line + "ERROR="+e.getMessage());
            } finally {
                System.out.print("Enter an prefix expression: ");
            }
        }
    }
}

/*
This is a program for calculating prefix expressions.
You may use these operators ... +, -, *, /

Enter an prefix expression: + 3 4
+ 3 4 = 7.0
Enter an prefix expression: - 9 4
- 9 4 = 5.0
Enter an prefix expression: -596
-596 = -596.0
Enter an prefix expression: - 4 9
- 4 9 = -5.0
Enter an prefix expression: / * 15 4 + 5 1
/ * 15 4 + 5 1 = 10.0
Enter an prefix expression: - + + 9 8 7 6
- + + 9 8 7 6 = 18.0
Enter an prefix expression: + * 2 -3 * -4 15
+ * 2 -3 * -4 15 = -66.0
Enter an prefix expression: / * 309 3 * + 23 9 - 8 3
/ * 309 3 * + 23 9 - 8 3 = 5.79375
Enter an prefix expression: / 6 - 4 * 2 2
Error with input:/ 6 - 4 * 2 2ERROR=0 division exception
Enter an prefix expression: + 4
Error with input:+ 4ERROR=Invalid expression
Enter an prefix expression: + 1 2 3
Error with input:+ 1 2 3ERROR=Invalid expression
Enter an prefix expression: & 1 2
Error with input:& 1 2ERROR=Invalid expression
Enter an prefix expression: + 3 * 4
Error with input:+ 3 * 4ERROR=Invalid expression
Enter an prefix expression: / 4 - 5 5
Error with input:/ 4 - 5 5ERROR=0 division exception
Enter an prefix expression: * 3 oops
Error with input:* 3 oopsERROR=Invalid expression
Enter an prefix expression: + 3 * 2 5
+ 3 * 2 5 = 13.0
Enter an prefix expression: - +9 8
- +9 8 = 1.0
 */