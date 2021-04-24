/******************************************************************************

V1: Create a word bank
V2: Randomly choose a word from the word bank

*******************************************************************************/
//importing
import java.util.Random;
public class V2
{
    public static void main(String[] args) {
        //create random
        Random rand = new Random();   
        String [] wordbank = {"java", "break", "sleep", "hippo", "lion", "giraffe", "string", "semicolon", "public", "class", "spider", "asterisk", "void", "anaconda", "atmosphere"};
        int randomnum = rand.nextInt (15);

    }

}

