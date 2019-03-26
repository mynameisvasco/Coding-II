import static java.lang.System.*;

public class ReverseArgs {

  public static void main(String[] args) 
  {
    printArray(args, args.length);
  }

  /** Imprime as N primeiras strings do array, uma por linha. */
  public static void printArray(String[] array, int n) 
  {
    if(n != 0)
    {
      n--;
      System.out.println(array[n]);
      printArray(array, n);
    }
  }

}

