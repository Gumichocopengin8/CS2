import java.util.Scanner;
public class Test2 {
    /*
    Keita Nonaka
    No.2
    1/23/2018
////////////////////////////////////////////////////////////////////////////////
    2. Input 3 numbers (doubles), compute and print their sum and average.
       (input, double type)
     */
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);   // Input func
        double sum = 0.0;

        System.out.println("Enter three numbers: "); // Output.
        for(int i = 0; i < 3; i++){
            double num = cin.nextDouble();  // Input.
            sum += num;  // Adding.
        }
        System.out.println("\nSum is " + sum); // output sum
        System.out.println("Average is " + sum / 3.0); // output average
    }
}
/* ---------- sample interaction inserted below ----------
Enter three numbers:
1 2 3

Sum is 6.0
Average is 2.0

------------------------------*/
