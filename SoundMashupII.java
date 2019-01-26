/*
    Koki Omori, Keita Nonaka
    Program 2
    2/12/2018
////////////////////////////////////////////////////////////////////////////////
    This is a program for sound mashup. There are two classes. 
    User may input 5 commands to make the original sound album.
    This class is a main class. 
*/

import java.util.Scanner;
public class SoundMashupII {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        SoundsArray soundsArray = new SoundsArray(100);
        Sound clip = null; // clip
        String fileName = ""; // file name
        int position = 0; // position of array
        
        System.out.print("SoundMashupII$ ");
        char command = Character.toUpperCase(cin.next().charAt(0));
        
        while (command != 'Q'){ // until quit
            switch (command){
                case 'A': // append
                    fileName = FileChooser.pickAFile();
                    clip = new Sound(fileName);
                    try{
                        clip = reverse_scale(clip);
                    }catch (Exception e) {
                            System.out.println("No reverse and scaling");
                    }
                    soundsArray.Append(clip);
                    break;
                case 'I': // insert
                    do {
                        fileName = FileChooser.pickAFile();
                        clip = new Sound(fileName);
                        System.out.print("Where do you wanna insert? ");
                        try{
                            position = cin.nextInt();
                            clip = reverse_scale(clip);
                        }catch (Exception e) {
                            System.out.println("Inappropriate value");
                            position = -1; // to get rejection
                            cin.next();
                        }
                    }while(soundsArray.Insert(clip, position - 1));
                    break;
                case 'D': // delete
                    do {
                        System.out.print("Which sound do you wanna delete? ");
                        try{
                            position = cin.nextInt();
                        }catch (Exception e) {
                            System.out.println("Inappropriate value");
                            position = -1; // to get rejection
                            cin.next();
                        }
                    }while(soundsArray.Delete(position - 1));
                    break;
                case 'P': // play
                    soundsArray.Play();
                    break;
                default: // error 
                    System.out.println(command + ": command not found");
                    break;
            }
            System.out.print("SoundMashupII$ ");
            command = Character.toUpperCase(cin.next().charAt(0));
        }
        System.out.println("quit");
    }
    
    public static Sound reverse_scale(Sound clip){
        Scanner cin = new Scanner(System.in);
        System.out.print("Do you wanna reverse the sound? (y/n) ");
        char reverse = Character.toLowerCase(cin.next().charAt(0));
        if(reverse == 'y')
            clip = clip.reverse();
        System.out.print("How much scaling should be applied? ");
        double scaling = cin.nextDouble();
        clip = clip.scale(scaling);
        return clip;
    }
}

/* ----------------------output------------------------
SoundMashupII$ a
Do you wanna reverse the sound? (y/n) y
How much scaling should be applied? 3
appended 
SoundMashupII$ a
Do you wanna reverse the sound? (y/n) a
How much scaling should be applied? 1
appended 
SoundMashupII$ i
Where do you wanna insert? 2
Do you wanna reverse the sound? (y/n) y
How much scaling should be applied? 1
inserted 
Where do you wanna insert? d
Inappropriate value 
rejected 
SoundMashupII$ p
Playing No.1 
Playing No.2 
Playing No.3 
The total play time: 9.532993197278913 seconds 
SoundMashupII$ fdsa
F: command not found 
SoundMashupII$ nad
N: command not found 
SoundMashupII$ d
Which sound do you wanna delete? 1
deleted 
Which sound do you wanna delete? d
Inappropriate value 
rejected 
SoundMashupII$ p
Playing No.1 
Playing No.2 
The total play time: 3.4312925170068027 seconds 
SoundMashupII$ a
Do you wanna reverse the sound? (y/n) y
How much scaling should be applied? 2
appended 
SoundMashupII$ p
Playing No.1 
Playing No.2 
Playing No.3 
The total play time: 4.619433106575963 seconds 
SoundMashupII$ i
Where do you wanna insert? 3
Do you wanna reverse the sound? (y/n) y
How much scaling should be applied? 1
inserted 
Where do you wanna insert? 2
Do you wanna reverse the sound? (y/n) d
How much scaling should be applied? 1
inserted 
Where do you wanna insert? d
Inappropriate value 
rejected 
SoundMashupII$ p
Playing No.1 
Playing No.2 
Playing No.3 
Playing No.4 
Playing No.5 
The total play time: 8.070045351473922 seconds 
SoundMashupII$ d
Which sound do you wanna delete? 8
rejected 
SoundMashupII$ d
Which sound do you wanna delete? 5
deleted 
Which sound do you wanna delete? d
Inappropriate value 
rejected 
SoundMashupII$ p
Playing No.1 
Playing No.2 
Playing No.3 
Playing No.4 
The total play time: 6.881904761904761 seconds 
SoundMashupII$ d
Which sound do you wanna delete? 1
deleted 
Which sound do you wanna delete? d
Inappropriate value 
rejected 
SoundMashupII$ p
Playing No.1 
Playing No.2 
Playing No.3 
The total play time: 6.200657596371881 seconds 
SoundMashupII$ a
Do you wanna reverse the sound? (y/n) y
How much scaling should be applied? 1
appended 
SoundMashupII$ p
Playing No.1 
Playing No.2 
Playing No.3 
Playing No.4 
The total play time: 8.401224489795917 seconds 
SoundMashupII$ d
Which sound do you wanna delete? 1
deleted 
Which sound do you wanna delete? 1
deleted 
Which sound do you wanna delete? 1
deleted 
Which sound do you wanna delete? 1
deleted 
Which sound do you wanna delete? 1
rejected 
SoundMashupII$ 1
1: command not found 
SoundMashupII$ 1
1: command not found 
SoundMashupII$ p
The total play time: 0.0 seconds 
SoundMashupII$ q
quit 

 */
