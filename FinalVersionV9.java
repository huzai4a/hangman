/******************************************************************************

Hangman 
By: Huzaifa Syed
On screen, you will see:
1. The word bank (a random word will be chosen from here)
2. The alphabet with dashes for chosen letters (after game commences)
3. The word (filled with dashes)
4. The amount of wrong guesses (after game commences)
5. The hangman (after game commences)
6. Enter a letter. 
Full screen the console if you cannot see all of this. Enjoy!

 *******************************************************************************/
//importing
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class FinalVersionV9
{
    public static String[] wordbank = {"jumping", "break", "slip", "yeah", "lion", "insect", "string", "column", "public", "crows", "spider", "ants", "void", "honey", "chips"};
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        clearscreen();

        Random ran = new Random();

        //creating variables
        char userguess;
        boolean dashpresent;
        String yesno = "y";

        while (yesno.charAt(0) == 'y') {
            /* these two have to be in the while for the repeat so 
            the word changes and mistakes reset */
            int randomnum = ran.nextInt (wordbank.length);
            int mistake = 0;
            // creating dash array of random word and alphabet array
            char[] worddash = new char[wordbank[randomnum].length ()];
            char [] alpharay = new char [26];        

            fillarrays(worddash, alpharay);//calls fill arrays

            dashpresent = true;

            // prints some stuff
            System.out.println (Arrays.toString (wordbank));
            System.out.println (Arrays.toString (worddash));

            while (dashpresent)
            {                
                // get userguess input
                say ("Enter a letter.");
                userguess = sc.nextLine ().charAt (0);
                mistake++;
                // searches for userguess letter in word
                for (int i = 0; i < wordbank[randomnum].length (); i++)
                {
                    if (userguess == wordbank[randomnum].charAt (i) && worddash [i] != wordbank[randomnum].charAt(i)) {
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

                // prints the wordbank
                System.out.println (Arrays.toString (wordbank));            
                // prints the current state of alphabet to show letters available to use
                System.out.println (Arrays.toString (alpharay));
                // prints the current state of the worddash
                System.out.println (Arrays.toString (worddash));

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
                drawhangman (mistake); //calls draw hangman
                if (mistake == 6) {
                    dashpresent = false;
                }
            }               // while loop ends

            winconditions(mistake); //calls win condition
            say ("Do you want to repeat?");
            yesno = sc.nextLine().toLowerCase();

            clearscreen(); //clears after getting repeat answer
        }
        say ("Alright, goodbye.");
    }

    public static void say (String x) {
        System.out.println(x);   
    }

    public static void clearscreen() {
        System.out.print('\u000C');
    }

    public static void fillarrays (char [] tempar1, char [] tempar2) {
        // adding dashes per letter of word
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < tempar1.length; i++) {
            tempar1[i] = '-';
        }               // for loop ends

        for (int i = 0; i < tempar2.length; i++) {
            tempar2 [i] = alphabet.charAt(i);
        }    
    }

    public static void winconditions (int temp) {
        if (temp < 6){
            say("You win! Good job"); 
            if (temp > 0){
                System.out.println("You missed " + temp + " time(s).");
            }
        }
        else {
            say ("You lose!");
            System.out.println("You missed " + temp + " time(s).");
        }
    }

    public static void drawhangman (int temp) {
        if (temp == 1){
            say ("   ____________");
            say ("   |          |");
            say ("   |");
            say ("   |");
            say ("   |");
            say ("   |");
            say ("   |");
            say ("   |");
            say ("___|___");
        }

        if (temp == 2){
            say ("   ____________");
            say ("   |          |");
            say ("   |          O");
            say ("   |");
            say ("   |");
            say ("   |");
            say ("   |");
            say ("   |");
            say ("___|___");
        }

        if (temp == 3){
            say ("   ____________");
            say ("   |          |");
            say ("   |          O");
            say ("   |          |");
            say ("   |"); // 3 arms because it thinks / \ is an escape
            say ("   |");
            say ("   |");
            say ("   |");
            say ("___|___");
        }

        if (temp == 4){
            say ("   ____________");
            say ("   |          |");
            say ("   |          O");
            say ("   |          |");
            say ("   |         / \\"); // 3 arms because it thinks / \ is an escape
            say ("   |");
            say ("   |");
            say ("   |");
            say ("___|___");
        }

        if (temp == 5){
            say ("   ____________");
            say ("   |          |");
            say ("   |          O");
            say ("   |          |");
            say ("   |         / \\"); // 3 arms because it thinks / \ is an escape
            say ("   |          |");
            say ("   |");
            say ("   |");
            say ("___|___");    
        }

        if (temp == 6){
            say ("   ____________");
            say ("   |          |");
            say ("   |          O");
            say ("   |          |");
            say ("   |         / \\"); // 3 arms because it thinks / \ is an escape
            say ("   |          |");
            say ("   |         / \\"); // 3 legs because it thinks / \ is an escape
            say ("   |");
            say ("___|___");
        }
    }
}
