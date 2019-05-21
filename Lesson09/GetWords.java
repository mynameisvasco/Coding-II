import static java.lang.System.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import static p2utils.Sorting.*;

public class GetWords
{
  public static void main(String[] args) 
  {
    String[] words;

    if (args.length < 1) {
      err.println("Usage: java GetWords <file>");
      exit(1);
    }
    File[] files = new File[args.length];
    for(int i = 0; i < args.length; i++)
    {
      files[i] = new File(args[i]);
    }
    words = extractWords(files);
    mergeSort(words, 0, words.length - 1);
    for(int i = 0; i < words.length; i++)
      out.printf("[%05d] %s\n", i+1, words[i]);
  }

  // Read words from a file, return words in an array
  static String[] extractWords(File[] files) {
    try 
    {
      int n = 0;

      for(int i = 0; i < files.length; i++)
      {
        // count the words
        Scanner scf = new Scanner(files[i]).useDelimiter("[\\p{Punct}\\p{Space}]+");
        // (words are delimited by 1 or more punctuation or whitespace char)
        while (scf.hasNext()) {
          scf.next();
          n++;
        }
        scf.close();
      }

      int k = 0;
      // create the array
      String[] result = new String[n];

      for(int i = 0; i < files.length; i++)
      {
        // read the words
        Scanner scf = new Scanner(files[i]).useDelimiter("[\\p{Punct}\\p{Space}]+");
        while (scf.hasNext()) 
        {
          String curString = scf.next();

          try
          {
            for(int j = 0; j < result.length; j++)
            {
              if(result[j].equals(curString)) curString = scf.next();;
            }
          }
          catch(NullPointerException e)
          {
            
          }
          result[k] = curString;
          k++;
        }
        scf.close();
      }

      return result;
    } 
    catch (IOException e) 
    {
      err.printf("Error: %s\n", e);
      exit(1);
      return null;  // never happens...
    }
  }
}
