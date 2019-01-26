import java.util.Scanner;
public class Test4 {
    /*
    Keita Nonaka
    No.4
    1/23/2018
////////////////////////////////////////////////////////////////////////////////
    4. Input a list of words terminated by end of input (^D or ^Z),
       find the longest word, print it and how long it is.
       Also print how many words were input.
       (scanning, next(), end of input, while loop).
     */
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String word = "";
        int max_length = 0; // max length
        int count = 0;  // counting how many times user entered words

        System.out.println("Enter as many words as you want. Input ^D or ^Z to terminate.\n");
        while (cin.hasNext()) {  // infinite looping
            String input = cin.next();
            // get the largest word. I don't need to get all of the largest word.
            if(input.length() > word.length()){
                word = input;
                max_length = word.length();
            }
            count++;
        }
        // Output result
        System.out.println("\nThe longest word is " + word);
        System.out.println("The length is " + max_length);
        System.out.println("You've entered " + count + " words!\n");
    }
}
/* ---------- sample interaction inserted below ----------
Enter as many words as you want. Input ^D or ^Z to terminate.

If I profane with my unworthiest hand
This holy shrine, the gentle sin is this:
My lips, two blushing pilgrims, ready stand
To smooth that rough touch with a tender kiss.
^D
The longest word is unworthiest
The length is 11
You've entered 31 words!

------------------------------*/
