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
V6: Draw the hangman correctly on the number of mistakes made
- NOTE: Methods were created in V6, did V7 by accident in V6
V7: Tell us if we win or lose the game
V8: Repeat the game if we want to

 *******************************************************************************/
//importing
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class V8
{
    public static String[] wordbank = {"jumping", "break", "slip", "yeah", "lion", "insect", "string", "column", "public", "crows", "spider", "ants", "void", "honey", "chips"};
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print('\u000C'); //clear screen bluej

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
            // test System.out.println ("Random number: " + randomnum + " --> " + wordbank[randomnum]);
            System.out.println (Arrays.toString (worddash));

            while (dashpresent)
            {
                // get userguess input
                say ("Enter a letter.");
                userguess = sc.nextLine ().charAt (0);
                mistake++;
                // test System.out.println(mistake);
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
        }
        say ("Alright, goodbye.");
    }

    public static void say (String x) {
        System.out.println(x);   
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