import java.io.*;
import java.util.*;

public class HangmanFile implements Serializable{
   private static String fileName = "src/pokemonnames.txt";
   private static List<String> wordsList = new ArrayList<>(); // list to hold words listed in file

   private static int misses = 0;
   private static boolean solved = false;
   private static String unsolved ;

   // selectWord() returns original word and its coded form.
   private static String[] selectWord() {
      String word;
      String asteriskWord ;

      try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
         String l;
         // loop until end of file
         while ( (l = br.readLine()) != null ) {
            wordsList.add(l); //  add line to array of words
         }
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      Random r = new Random();
      int randint = r.nextInt(wordsList.size());
      String[] stringArray = wordsList.toArray(new String[0]); // convert List to String[]

      word = stringArray[randint].toUpperCase();
      asteriskWord = new String(new char[word.length()]).replace("\0", "*");

      String[] words = {word, asteriskWord};
      return words;
   }

   public static void requestGuess(){
      String[] wordToGuess = selectWord();
      unsolved = wordToGuess[1];
      Scanner input = new Scanner(System.in);
      String letter;
      System.out.println("\n**---- WHO'S THAT POKEMON? ---**\n");
      System.out.print("(Guess) Enter a letter in word " + wordToGuess[1] + " > ");
      letter = input.next();
      String checked = checkGuess(letter.toUpperCase(), wordToGuess[0], wordToGuess[1]);

      while (!solved){
         System.out.print("(Guess) Enter a letter in word " + unsolved + " > ");
         letter = input.next();
         unsolved = checkGuess(letter.toUpperCase(), wordToGuess[0], unsolved);
      }

      // word solved

      System.out.println("The word is " + wordToGuess[0] + ". ");
      if (misses == 1){
         System.out.println("You missed " + misses + " time. Not bad!");
      } else if(misses ==0){
         System.out.println("Wow! You never missed!");
      } else {
         System.out.println("You missed " + misses + " times, but that's okay!"); }
      System.out.print("Do you want to guess another word? Enter y or n > ");
      letter = input.next();
      if (letter.toUpperCase().equals("Y")){
         solved = false;
         misses = 0;
         requestGuess();
      }
      else {
         System.out.println("**---- BYE! ----**");
      }
   }

   public static String checkGuess(String guess, String word, String unsolvedWord){
      String result = "";
      boolean missed = true;
      boolean alreadyGuessed = false;
      for (int i=0; i < unsolvedWord.length(); i++) {
         // letter already guessed
         if ( unsolvedWord.charAt(i) == guess.charAt(0) ) {
            System.out.println(word.charAt(i) + " is already in the word. ");
            alreadyGuessed = true;
            result = unsolvedWord;
            break;
         } else if ( !alreadyGuessed ) {
            // correct guess
            if ( word.charAt(i) == guess.charAt(0) ) {
               missed = false;
               result += guess.charAt(0);
            } else if ( unsolvedWord.charAt(i) == word.charAt(i) ) {
               result += word.charAt(i);
            } else {
               result += "*";
            }
         }
      }
      if (result.equals(word)){
         solved = true;
      }
      if (!alreadyGuessed && missed){
         System.out.println("Sorry, there is no " + guess.charAt(0) + ".");
         misses++;
      }
      unsolved = result;
      return unsolved;
   }


   /** Main Program */
   public static void main(String[] args) {
      requestGuess();
   }

}