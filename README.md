<h1 align="center">
  Java Exercises
</h1>

## Lab 2 Questions

### 1. 
Write the methods with the following headers:
- Return the reversal of an integer, i.e., reverse(456) returns 654 : public static int reverse(int number).
- Return true if number is a palindrome : public static boolean isPalindrome(int number)
- Use the reverse method to implement isPalindrome. 
- Write a test program that prompts the user to enter an integer and reports whether the integer is a palindrome.

### 2.
Write a program that displays the first 100 palindromic prime numbers. Display 10 numbers per line separated by exactly one space.

## Baby Names Ranking Program

### taskOne.java
Suppose we have the following list of the top five male and female names of 2017:
List<String> topNames2017 = Arrays.asList(
"Amelia",
"Olivia",
"emily",
"Isla",
"Ava",
"oliver",
"Jack",
"Charlie",
"harry",
"Jacob"
);
Using Lambda expressions, print the listed names in alphabetical order with the first letter of each name capitalized. 

### taskTwo.java
The popularity ranking of baby names from 2001-2010 are stored in .txt files. Each file contains one thousand lines. 
Each line contains a ranking, a boy’s name, number of babies with the boy’s name, a girl’s name, and the number of babies with the girl’s name.
Write a program that prompts the user to enter the year, gender, and followed by a name, and
displays the ranking of the name for the year. Here is a sample run:
![sample run](https://github.com/transteph/java-exercises/BabyNamesRanking/samplerun.PNG)