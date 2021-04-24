/******************************************************************************

V1: Create a word bank
V2: Randomly choose a word from the word bank
V3: Make an array of alphabet
- Whenever a letter is guessed it converts to a dash
V4: Make an array of dashes based on the randomly chosen word
- Whenever a letter is chosen correctly, it converts to the letter
V5: Count mistakes
- If a letter is guessed that is not in the word
- If a letter is guessed that was already guessed

 *******************************************************************************/
//importing
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class V5
{
    public static String[] wordbank = {"jumping", "break", "slip", "yeah", "lion", "insect", "string", "column", "public", "crows", "spider", "ants", "void", "honey", "chips"};
    public static Scanner sc = new Scanner(System.in);
    public static Random ran = new Random();

    public static void main(String[] args) {
        System.out.print('\u000C'); //clear screen bluej

        //creating variables
        int randomnum = ran.nextInt (wordbank.length);
        char userguess;
        boolean dashpresent;
        int mistake = 0;

        // creating dash array of random word
        char[] worddash = new char[wordbank[randomnum].length ()];

        // adding dashes per letter of word
        for (int i = 0; i < worddash.length; i++) {
            worddash[i] = '-';
        }               // for loop ends

        // creating alphabet array
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char [] alpharay = new char [26];
        for (int i = 0; i < alpharay.length; i++) {
            alpharay [i] = alphabet.charAt(i);
        }

        dashpresent = true;

        // prints some stuff
        System.out.println (Arrays.toString (wordbank));
        System.out.println ("Random number: " + randomnum + " --> " + wordbank[randomnum]);
        System.out.println (Arrays.toString (worddash));

        while (dashpresent)
        {
            // get userguess input
            System.out.println ("Enter a letter.");
            userguess = sc.nextLine ().charAt (0);
            mistake++;
            //test System.out.println(mistake);
            // searches for userguess letter in word
            for (int i = 0; i < wordbank[randomnum].length (); i++)
            {
                if (userguess == wordbank[randomnum].charAt (i)) {
                    worddash[i] = userguess;
                    mistake--;
                }           //if equal ends
            }           // for loop ends

            // searches for userguess letter in alphabet
            for (int i = 0; i < alpharay.length; i++) {
                if (alpharay [i] == userguess) {
                    alpharay [i] = '-';
                }
            }

            // prints the current state of the worddash
            System.out.println (Arrays.toString (worddash));
            // prints the current state of alphabet to show letters available to use
            System.out.println (Arrays.toString (alpharay));

            // figures out when to leave loop
            dashpresent = false;
            for (int i = 0; i < worddash.length; i++)//search through the length of worddash for dashes
            {
                if (worddash[i] == '-')
                {
                    dashpresent = true;
                }           // if ends
            }
            System.out.println("Wrong guesses: " + mistake);
        }               // while loop ends

        System.out.println("done"); 

        if (mistake > 0){
            System.out.println("You missed " + mistake + " time(s).");
        }
    }
}