import java.util.Scanner;
public class Test5 {
    /*
    Keita Nonaka
    No.5
    1/23/2018
////////////////////////////////////////////////////////////////////////////////
    5. Redo/enhance # 3 by saving the data in an array of doubles.
       (basic numeric array manipulations).
       a. input the list of numbers into the array without the summing.
       b. after the array is filled, find and print the sum and average of the array
       c. find the largest number and print it
       d. count the number of numbers larger than the average and print that count.
     */
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);   // Input func
        System.out.print("How many times do you wanna input?\n Enter a number: ");
        int count = cin.nextInt();
        double[] num = new double[count];   // Array
        int large_count = 0; // counter

        // input the list of numbers into the array without the summing.
        System.out.println("Enter " + count + " numbers: ");
        for(int i = 0; i < count; i++){
            num[i] = cin.nextDouble();  // Input.
        }
        // after the array is filled, find and print the sum and average of the array
        // find the largest number and print it
        double sum = 0.0;
        double max = num[0];
        for(double i : num){
            sum += i;
            max = Math.max(max, i);
        }
        System.out.println("\nSum is " + sum);
        System.out.println("Average is " + sum / count);
        System.out.println("The largest number is " + max);

        // count the number of numbers larger than the average and print that count.
        for(double i : num){
            if(i > sum / count){
                large_count++;
            }
        }
        System.out.println("The number of numbers larger than the average is " + large_count);
    }
}
/* ---------- sample interaction inserted below ----------
How many times do you wanna input?
 Enter a number: 5
Enter 5 numbers:
1 -4 3 4 6

Sum is 10.0
Average is 2.0
The largest number is 6.0
The number of numbers larger than the average is 3

------------------------------*/
