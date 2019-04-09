import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
// import java.util.*;   // => "error: reference to LinkedList is ambiguous"
// java.util.LinkedList colide com p2utils.LinkedList!
import p2utils.*;

public class FilterLines
{
  public static void main(String[] args) throws IOException
  {
    if (args.length != 1) {
      err.printf("Usage: java -ea FilterLines text-file\n");
      exit(1);
    }
    File fil = new File(args[0]);

    LinkedList<String> shortLines = new LinkedList<String>();
    LinkedList<String> mediumLines = new LinkedList<String>();
    LinkedList<String> longLines = new LinkedList<String>();

    Scanner sf = new Scanner(fil);
    // exceções poderiam ser intercetadas e mostrar mensagem de erro.
    while (sf.hasNextLine()) 
    {
      String line = sf.nextLine();
      
      if(line.length() < 20)
      {
        shortLines.addLast(line);
      }
      else if(line.length() >= 20 && line.length() <= 40)
      {
        mediumLines.addLast(line);
      }
      else
      {
        longLines.addLast(line);
      }
    }

    sf.close();

    // Escrever conteúdo das listas...
    /**out.println("Curtas---|---------|---------|---------|---------");
    shortLines.print();

    out.println("Médias---|---------|---------|---------|---------");
    mediumLines.print();

    out.println("Longas---|---------|---------|---------|---------");
    longLines.print();
    */
    longLines.remove("vasco sousa é lindooooooooooo 1234567 890");
    longLines.print();
  }

}
