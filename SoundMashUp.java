/*
    Keita Nonaka
    Program 1
    2/7/2018
////////////////////////////////////////////////////////////////////////////////
    This is a program to load n unique sound clips into an array and then
    randomly generate a mashup of these clips for a total of t seconds (input)
    by choosing clips from the array. After loading the n unique sound clips,
    you randomly play a sound clip and pause between the playing of
    each clip of 250 milliseconds for an audible transitional sense
    until you have played at least t*1000 milliseconds.
*/

import java.util.Scanner;
public class SoundMashUp {
    public static void main(String[] args) {
        Scanner cin = new Scanner (System.in);
        int soundClips = 0;  // the number of sound clips
        Sound[] sounds = null; // array to store sound clips

        System.out.println ("Enter number of sound files: ");
        soundClips = cin.nextInt();
        sounds = new Sound[soundClips];
        for(int i = 0; i < soundClips; i++) {
            String fileName; // file name
            boolean check = false;  // check uniqueness
            do{
                check = false;
                fileName = FileChooser.pickAFile();
                for(int n =0; n < i; n++){
                    if(sounds[n].getFileName().equals(fileName)){
                        check = true;
                        break;
                    }
                }
            }while(check == true);
            sounds[i] = new Sound(fileName);  // get a sound clip
        }
        
        System.out.println("How long do you wanna listen to them in seconds? >"); // ask time
        double time = cin.nextDouble() * 1000; // time to play sound clip
        while(time > 0){
            int rand = (int)(Math.random()*soundClips); // random
            System.out.println("The Time Remaining: " + time);
            System.out.println("File playing is '" + sounds[rand].getFileName() + "'");
            System.out.println("The clip in millisenconds: " + sounds[rand].getLength()/22.05 + "\n");
            time = time - (sounds[rand].getLength()/22.05 + 250); // calc remained time
            sounds[rand].blockingPlay();
            try {
                Thread.sleep(250); // sleep 1/4 sec
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
                System.err.println("Stack Trace is:");
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }
}

/*
Enter number of sound files:  
10
How long do you wanna listen to them in seconds? > 
120
The Time Remaining: 120000.0 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\warble-h.wav' 
The clip in millisenconds: 499.04761904761904
 
The Time Remaining: 119250.95238095238 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\vote.wav' 
The clip in millisenconds: 580.1360544217687
 
The Time Remaining: 118420.8163265306 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\guzdial.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 117170.8163265306 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\nu-f440.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 115920.8163265306 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 113720.29478458049 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\the.wav' 
The clip in millisenconds: 538.7755102040816
 
The Time Remaining: 112931.5192743764 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\vote.wav' 
The clip in millisenconds: 580.1360544217687
 
The Time Remaining: 112101.38321995463 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\gettysburg.wav' 
The clip in millisenconds: 17577.05215419501
 
The Time Remaining: 94274.33106575962 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\guzdial.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 93024.33106575962 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\the.wav' 
The clip in millisenconds: 538.7755102040816
 
The Time Remaining: 92235.55555555553 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 90035.03401360541 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\done.wav' 
The clip in millisenconds: 532.2902494331065
 
The Time Remaining: 89252.74376417231 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\nu-f440.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 88002.74376417231 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 85802.22222222219 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\warble-h.wav' 
The clip in millisenconds: 499.04761904761904
 
The Time Remaining: 85053.17460317457 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\nu-f440.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 83803.17460317457 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 81602.65306122445 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 79402.13151927434 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\nu-f440.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 78152.13151927434 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\vote.wav' 
The clip in millisenconds: 580.1360544217687
 
The Time Remaining: 77321.99546485256 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\vote.wav' 
The clip in millisenconds: 580.1360544217687
 
The Time Remaining: 76491.85941043078 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\impress.wav' 
The clip in millisenconds: 818.6848072562358
 
The Time Remaining: 75423.17460317454 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\the.wav' 
The clip in millisenconds: 538.7755102040816
 
The Time Remaining: 74634.39909297046 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\a.wav' 
The clip in millisenconds: 431.2018140589569
 
The Time Remaining: 73953.19727891151 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\done.wav' 
The clip in millisenconds: 532.2902494331065
 
The Time Remaining: 73170.9070294784 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 70970.38548752829 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\nu-f440.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 69720.38548752829 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 67519.86394557817 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\done.wav' 
The clip in millisenconds: 532.2902494331065
 
The Time Remaining: 66737.57369614506 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 64537.05215419495 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\done.wav' 
The clip in millisenconds: 532.2902494331065
 
The Time Remaining: 63754.76190476184 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\gettysburg.wav' 
The clip in millisenconds: 17577.05215419501
 
The Time Remaining: 45927.709750566835 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\nu-f440.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 44677.709750566835 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\a.wav' 
The clip in millisenconds: 431.2018140589569
 
The Time Remaining: 43996.50793650788 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 41795.98639455777 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\a.wav' 
The clip in millisenconds: 431.2018140589569
 
The Time Remaining: 41114.78458049881 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\nu-f440.wav' 
The clip in millisenconds: 1000.0
 
The Time Remaining: 39864.78458049881 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\aah.wav' 
The clip in millisenconds: 1950.5215419501133
 
The Time Remaining: 37664.2630385487 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\gettysburg.wav' 
The clip in millisenconds: 17577.05215419501
 
The Time Remaining: 19837.210884353688 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\impress.wav' 
The clip in millisenconds: 818.6848072562358
 
The Time Remaining: 18768.526077097453 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\done.wav' 
The clip in millisenconds: 532.2902494331065
 
The Time Remaining: 17986.235827664346 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\the.wav' 
The clip in millisenconds: 538.7755102040816
 
The Time Remaining: 17197.460317460263 
File playing is 'C:\Users\nonakkx16\Desktop\mediasources\gettysburg.wav' 
The clip in millisenconds: 17577.05215419501

Done
*/
