/**
    1. Write the methods with the following headers
        // Return the reversal of an integer, i.e., reverse(456) returns 654
            public static int reverse(int number)
        // Return true if number is a palindrome 
            public static boolean isPalindrome(int number)
    Use the reverse method to implement isPalindrome. 
    Write a test program that prompts the user to enter an integer and reports whether the integer is a palindrome.
 */

import java.util.Scanner;
public class lab2One {

    // returns reversal of an int
    public static int reverse(int number){
        int i = number;
        int reversed = 0;
        while (i !=0){
            reversed = reversed * 10 + i % 10;
            i /= 10;
        }
        return reversed;
    }

    // returns true if palindrome
   public static boolean isPalindrome(int number){
       int reversed = reverse(number);
       if (number == reversed)
          return true;
       else
          return false;
   }

   /**
    2. Write a program that displays the first 100 palindromic prime numbers. Display 10 numbers per line separated by exactly one space.
 */

    // displays first 100 pallindromic prime numbers
   public static void palPrime(){
    int count = 0; // holds number of prime pallindromes found
    int number = 1;
    String[] output;

   while (count < 100){
      number++;
      boolean prime = true;
      if ( isPalindrome(number) ){
         int timesMultiplied = 0;
         // number is palindromic. Check if it is a prime number
         for (int i = 2; i < number && prime; i++){

            for (int multipliedBy = 2; multipliedBy < number; multipliedBy++) {
               if ( i * multipliedBy == number ) {
                  timesMultiplied++;
               }
            }

         }
         if (timesMultiplied > 0){
            prime = false;
         }
         else {
            count++;
            if (count % 10 == 0){
               System.out.print("\n");
            }
            System.out.print(number + " ");
         }
      }

    }

}

 public static void main(String[] args){
     System.out.println("Running reverse(). Enter a number: ");
     Scanner input = new Scanner(System.in);
     int number = input.nextInt();
    System.out.println(reverse(number));

    System.out.println("Is it a palindrome? ");
    if (isPalindrome(number))
       System.out.println("Yupp!");
    else
       System.out.println("Nope!");

    System.out.println("The first 100 pallindromic prime numbers are: ");
    palPrime();

 }
}
