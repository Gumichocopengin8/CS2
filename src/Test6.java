import java.util.Scanner;
public class Test6 {
    /*
    Keita Nonaka
    No.6
    1/23/2018
////////////////////////////////////////////////////////////////////////////////
    6. Create an array to hold up to 1000 strings.
        a. input lines of text into the array until an empty line is entered.
           Count the number of lines.
        b. input a character (such as an 'A' or 'x'. Print all lines that start
           with that character.
        c. input a word and find and print all lines that contain that word
           (String manipulations, searching, and loops)
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String[] text = new String[1000]; // up to 1000 strings.
        int count = 0;

        // input lines of text into the array until an empty line is entered.
        // Count the number of lines.
        System.out.println("Enter lines of text. Input empty line to terminate.\n");
        while (true) {
            String input = cin.nextLine();
            if(input.isEmpty()) break;
            text[count] = input + "\n";
            count++;
        }
        System.out.println("The number of lines is " + count);

        // input a character. Print all lines that start with that character.
        System.out.print("Enter a character, such as an 'A' or 'x'.\n Char: ");
        char ch = cin.next().charAt(0);
        System.out.println("Your input: " + ch + "\nResult:");
        for(int i = 0; i < count; i++) {
            if(text[i].charAt(0) == ch)
                System.out.print((i + 1) + ": " + text[i]);
        }
        // input a word and find and print all lines that contain that word.
        System.out.print("\nEnter a word you wanna search. \n Word: ");
        String word = cin.next();
        System.out.println("Your input: " + word + "\nResult:");
        for(int i = 0; i < count; i++) {
            if(text[i].contains(word))    // looking for the word
                System.out.print((i + 1) + ": " + text[i]);
        }
    }
}
/* ---------- sample interaction inserted below ----------
Enter lines of text. Input empty line to escape.

Hela heba helloa CHA CHA, hela...You say yes, I say no.
You say stop and I say go go go, oh no.
You say goodbye and I say hello
Hello hello
I don't know why you say goodbye, I say hello
Hello hello
I don't know why you say goodbye, I say hello.

The number of lines is 7
Enter a character, such as an 'A' or 'x'.
 Char: I
Your input: I
Result:
5: I don't know why you say goodbye, I say hello
7: I don't know why you say goodbye, I say hello.

Enter a word you wanna search.
 Word: why
Your input: why
Result:
5: I don't know why you say goodbye, I say hello
7: I don't know why you say goodbye, I say hello.

------------------------------*/
