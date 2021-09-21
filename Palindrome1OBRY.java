import java.util.Scanner;
import java.lang.Math;

/**
 * This program will ask the user to enter a phrase, 
 * then the program will check to see if what the user has entered is a palindrome.
 * 
 * @author Y'Shua O'Brien
 * @version 09/15/2021
 */

public class Palindrome1OBRY
{
  public static void main(String args[])
  {
    //=== DECLARATIONS ===
    String str, reverseStr="", strCopy="";
    int count=0; //used for counting the spaces inside the users input
    
    //=== PROGRAM DESCRIPTION ===
    printProgramDescription();
    
    //=== INPUT ===
    str=getUserInput();
    
    //=== PROCESSING ===
    reverseStr=reverseStrNoSpaces(str, count);
    strCopy=strNoSpaces(str, reverseStr); //I had to make two different copys of the string in order to get an accurate comparison while keeping the original text to print in the end
    
    //=== OUTPUT ===
    checkOutputForPalindrome(str, reverseStr, strCopy); //Prints if the users phrase is a palindrome or not
  }
  
  /**
   * This will print simple program instructions as the program description.
   */
  public static void printProgramDescription()
  {
    System.out.println("This program will ask the user to enter a phrase,");
    System.out.println("then the program will check to see if what the user has entered is a palindrome");
    System.out.println("");
  }
  
  /**
   * This will ask the user to input a phrase, the phrase has no limitations for what can be entered or not.
   * The program will then check if the input is 'null' or 'empty'.
   * 
   * @return str returns the users string as is
   */
  public static String getUserInput()
  {
    Scanner strIn=new Scanner(System.in);
    
    int count=0;
    String str;
    
    do
    {
      System.out.println("Print Phrase (no limitations)");
      str=strIn.nextLine();
      
      if (str == null)
      {
        System.exit(0);
      }
      
      for (int i=0; i<str.length(); i++)//I used this to find empty strings insead of isEmpty(). I didn't know it existed at the time.
      {
        if (str.charAt(i) == ' ')
        {
          //nothing is needed here, I just need the condition
        }
        else
        {
          count=count+1;
        }
      }
    } while (count==0);
    count=0;
    
    return str;
  }
  
  /**
   * This will build a new string without spaces, and reversed so it can be compared.
   * The number of spaces inside the string will also be counted.
   * 
   * @param str is the users input as is
   * @param count is the count of spaces inside the users string, naturally starts at 0
   * 
   * @return reverseStr is the new string that will be used to check if the users string is a palindrome or not
   */
  public static String reverseStrNoSpaces(String str, int count)
  {
    String reverseStr="";
    
    for (int i=0; i<str.length(); i++)
    {
      if ((int)str.charAt(i) == (32)) //checks for spaces
      {
        count=count+1; //keeps count of spaces
        reverseStr=reverseStr; //does absolutely nothing
      }
      else
      {
        reverseStr=str.charAt(i) + reverseStr; //adds char from the original string a different text that will not accept spaces
      }
    }
    //System.out.println(count + " spaces found."); //prints the spaces found
    
    return reverseStr;
  }
  
  /**
   * This will build a new string without spaces so it can be compared with the first copy of the users string.
   * The number of spaces inside the string will not be counted, since it has already been done in the first method.
   * 
   * @param str is the users input as is
   * @param reverseStr is the first copy of the users original string and is use in the comparison process
   * 
   * @return strCopy is the new string that will be used to check if the users string is a palindrome or not and is compared with the first copy
   */
  public static String strNoSpaces(String str, String reverseStr)
  {
    String strCopy="";
    
    for (int i=0; i<reverseStr.length(); i++)
    {
      if ((int)reverseStr.charAt(i) == (32)) //checks for spaces
      {
        strCopy=strCopy; //does absolutely nothing
      }
      else
      {
        strCopy=reverseStr.charAt(i) + strCopy; //adds char from the original string a different text that will not accept spaces
      }
    }
    
    return strCopy;
  }
  
  /**
   * This will output if the users input equals a palindrome or not.
   * 
   * @param reverseStr is the first copy of the users original string and is use in the comparison process
   * @param str is the users input as is
   * @param strCopy is the new string that will be used to check if the users string is a palindrome or not and is compared with the first copy
   */
  public static void checkOutputForPalindrome(String str, String reverseStr, String strCopy)
  {
    if (reverseStr.equalsIgnoreCase(strCopy)) //I had to make two different copys of the string in order to get an accurate comparison while keeping the original text to print
    {
      System.out.println(str + " is a palindrome.");
    }
    else
    {
      System.out.println(str + " is not a palindrome.");
    }
  }
  
}