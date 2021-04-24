/******************************************************************************

V1: Create a word bank
V2: Randomly choose a word from the word bank
V3: Make an array of alphabet
- Whenever a letter is guessed it converts to a dash

 *******************************************************************************/
//importing
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class V3
{
    public static void main(String[] args) {
        // create random
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        String [] wordbank = {"java", "break", "sleep", "hippo", "lion", "giraffe", "string", "semicolon", "public", "class", "spider", "asterisk", "void", "anaconda", "atmosphere"};
        int randomnum = ran.nextInt(15);
        char userguess = '.';
        boolean dashpresent = true;
        // System.out.println(randomnum);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char [] alpharay = new char [26];
        for (int i = 0; i < alpharay.length; i++) {
            alpharay [i] = alphabet.charAt(i);
        }
        System.out.println(Arrays.toString(alpharay));
        while (dashpresent){
            System.out.println("Guess a letter");
            userguess = sc.nextLine().charAt(0);

            for (int i = 0; i < alpharay.length; i++) {
                if (alpharay [i] == userguess) {
                    alpharay [i] = '-';
                }
            }
            System.out.println(Arrays.toString(alpharay));
        }
    }
}