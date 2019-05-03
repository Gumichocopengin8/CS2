/******************************************
 *
 * Keita Nonaka, Koki Omori
 * Data: 5/1/2018
 * Program 9
 ////////////////////////////////////////////////////////////////////////////////
 *      This program is for input and organize all of the words
 *      from a file of text and then generate a random passage
 *      in the same vocabulary and style of the original text.
 *      This file is using HashMap.
 *******************************************/

import java.io.*;
import java.util.*;

public class randomwriter {
    public static void main(String[] args) throws IOException {
        //Get file name arguments from command line or interactively as entered by user
        Scanner cin =  new Scanner(System.in);
        String sourceFileName;//Source file name
        String resultFileName;//Output file name
        int N;//number of output;
        int nWords = 0;
        int index = 0;
        long startTime; //for emperical time measurement
        long stopTime;  //elapsed time is difference in millisec

        System.out.println("This program is for input and organize all of the words from a file of text and then generate a random passage in the same vocabulary and style of the original text.");
        System.out.println("Pick an input file: ");
        sourceFileName = cin.next(); // get a file name
        System.out.println("What is the output file name?: ");
        resultFileName = cin.next(); // get a file name
        System.out.println("How many words do you wanna output?: ");
        N = cin.nextInt();
        Map<String, LinkedList<String>> unique = new HashMap<>();
        Map<Integer, String> facehash = new HashMap<>();
        //Prepare files
        Scanner dataFile = new Scanner(new FileReader(sourceFileName));
        PrintWriter outFile = new PrintWriter(new FileWriter(resultFileName));
        //Read a line from the source file until end of file
        String current = dataFile.next();//current word
        String first = current;
        String next;//next word that is following current
        startTime = System.currentTimeMillis();
        while(dataFile.hasNext()){
            next = dataFile.next();
            //check unique for current
            if(unique.containsKey(current) == false) {
                unique.put(current, new LinkedList<String>());
                unique.get(current).add(next);
                facehash.put(index, current);
                index++;
            } else if(unique.containsKey(current) == true)
                unique.get(current).add(next);
            current = next;
            nWords++;
            if(nWords % 1000 == 0)
                System.out.println(nWords+" words");//print # of words each 1000 words
        }
        if(unique.containsKey(current) == false) {//put beginning word to end of follows
            unique.put(current, new LinkedList<String>());
            unique.get(current).add(first);
            facehash.put(index, current);
            index++;
        }else
            unique.get(current).add(first);
        nWords++;
        System.out.println(nWords+" words");//print total # of word
        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed input time = "+(stopTime-startTime)+" msecs.");
        startTime = stopTime;
        outFile.println("\n------------random list----------------");
        outFile.flush();

        Random rand = new Random();
        String firstWord = facehash.get(rand.nextInt(index)); ///adfasf
        String nextWord;
        for (int i=0; i<N; i++){
            nextWord = unique.get(firstWord).get(rand.nextInt(unique.get(firstWord).size()));
            outFile.print(firstWord + " ");
            firstWord = nextWord;
        }

        outFile.flush();
        outFile.close();
        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed output time = "+(stopTime-startTime)+" msecs.");//print time it spent
    }
}
