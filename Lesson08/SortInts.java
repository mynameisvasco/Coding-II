import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;


public class SortInts
{
  public static SortedListInt intList;
  
  public static void main(String[] args) throws IOException 
  {
    assert args.length > 0 : "Help: java SortInts file.txt file1.txt ...";
    File[] files = new File[args.length];
    intList = new SortedListInt();

    int i = 0;
    for(File f : files)
    {
      f = new File(args[i]);
      scanFile(f);
      i++;
      if(!f.canRead())
      {
        continue;
      }
      if(f.isDirectory())
      {
        continue;
      }
      if(!f.exists())
      {
        continue;
      }
    }

    assert files.length > 0 : "Error: No files found";
    
    printList(intList);
  }

  public static void scanFile(File f)
  {
    try
    {
      Scanner fc = new Scanner(f);
      String n = "";

      while(fc.hasNext())
      {
        n = fc.next();
        try
        {
          int n1 = Integer.parseInt(n);
          intList.insert(n1);
        }
        catch(NumberFormatException e)
        {
          continue;
        }
      }
      fc.close();
    }
    catch(FileNotFoundException e)
    {
      err.println(e);
    }
  }

  public static void printList(SortedListInt l)
  {
    if(l.size() > 0)
    {
      System.out.println(l.first());
      l.removeFirst();
      printList(l);
    }
    else
    {
      return;
    }
  }
}


