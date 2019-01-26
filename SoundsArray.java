/*
    Koki Omori, Keita Nonaka
    Program 2
    2/12/2018
////////////////////////////////////////////////////////////////////////////////
    This is a program for sound mashup. There are two classes. 
    User may input 5 commands to make the original sound album.
    This class is for functions of 5 commands.
*/

public class SoundsArray {
    private Sound[] sounds;
    private Sound[] temp;
    private int n = 0;   // number of active clips
    private int size = 100;
    
    public SoundsArray(){ // constructor 
        sounds = new Sound[100];
        temp = new Sound[100];
    }
    public SoundsArray(int size){ // constructor 
        if(size > 100 || size < 1){
            sounds = new Sound[100];
        }else{
            sounds = new Sound[size];
            this.size = size;
        }
    }
    
    public void Append(Sound clip){ // append
        if(n <= size - 1){
            sounds[n] = clip;
            System.out.println("appended");
            n++;
        }
        else
            System.out.println("rejected");
    }
      
    public boolean Insert (Sound clip, int pos){ // insert
        if(pos < 0 || pos > n || n < 1 || n > size -1){ // pos as index of sound
            System.out.println("rejected");
            return false;
        }
        temp = new Sound[size];
        int diff = 0;
        for(int i = 0; i < n; i++){
            if(i == pos){
                temp[i] = clip;
                diff = 1;
            }
            temp[i + diff] = sounds[i];
        }
        sounds = temp;
        System.out.println("inserted");
        n++;
        return true;
    }
    
    public boolean Delete(int pos){ // delete 
        if(pos < 0 || pos > n || n < 1){ // pos as index of sound
            System.out.println("rejected");
            return false;
        }
        temp = new Sound[size];
        int diff = 0;
        for(int i = 0; i < n - 1; i++){
            if(i == pos)
                diff = 1;
            temp[i] = sounds[i + diff];
        }
        sounds = temp;
        System.out.println("deleted");
        n--;
        return true;
    }

    public void Play(){ // play with 250 msc pauase
        double time = 0.0;
        for(int i = 0; i < n; i++){
            System.out.println("Playing No." + (i + 1));
            time = time + sounds[i].getLength()/22.05 + 250;
            sounds[i].blockingPlay();
            try {
                Thread.sleep(250); // sleep 1/4 sec
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
                System.err.println("Stack Trace is:");
                e.printStackTrace();
            }
        }
        System.out.println("The total play time: " + (time/1000) + " seconds");
    }
}