import java.util.Scanner;
public class Test3 {
    /*
    Keita Nonaka
    No.3
    1/23/2018
////////////////////////////////////////////////////////////////////////////////
    3. Input an integer n, in a for loop then input n numbers (doubles),
    computing the sum/subtotal as each number is entered, at the end of the loop,
    print the average. (integer and double types, for loop)
     */
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);   // Input func
        System.out.print("How many times do you wanna input?\n Enter a number: ");
        int count = cin.nextInt();
        double sum = 0.0;

        for(int i = 0; i < count; i++){
            System.out.print("Enter an integer: "); // Output.
            double num = cin.nextInt();  // Input.
            sum += num;  // Adding.
            System.out.println("So far, the subtotal is " + sum); // Output subtotal.
        }
        System.out.println("\nTotal is " + sum);   // sum
        System.out.println("Average is " + sum / count); // Average
    }
}
/* ---------- sample interaction inserted below ----------
How many times do you wanna input?
 Enter a number: 5
Enter an integer: 1
So far, the subtotal is 1.0
Enter an integer: 2
So far, the subtotal is 3.0
Enter an integer: 3
So far, the subtotal is 6.0
Enter an integer: 4
So far, the subtotal is 10.0
Enter an integer: 5
So far, the subtotal is 15.0

Total is 15.0
Average is 3.0

------------------------------*/
