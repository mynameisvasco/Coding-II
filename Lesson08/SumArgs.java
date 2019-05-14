import static java.lang.System.*;

public class SumArgs
{
  public static void main(String[] args) 
  {
    // Criar array com um elemento por cada argumento do programa:
    double[] arr = new double[args.length];

    try 
    {
      int i = 0;
      for(String n : args)
      {
        arr[i] = Double.parseDouble(n);
        i++;
      }
    }
    catch(NumberFormatException e)
    {
      err.println(e);
    }

    // Calcular a soma com função recursiva:
    double total = sumRec(arr, 0, arr.length, 0);
    out.printf("sum of arguments = %f\n", total);

    // Verificação de correção do resultado:
    assert total == sum(arr, 0, arr.length);
  }

  // sum of subarray [start,end[ of arr:
  public static double sum(double[] arr, int start, int end) 
  {
    assert arr != null;
    assert start >= 0 && start <= end && end <= arr.length;

    double res = 0;
    for (int i = start; i < end; i++)
      res += arr[i];
    return res;
  }

  // same thing, recursive:
  public static double sumRec(double[] arr, int start, int end, double sum) 
  {
    if(start != end)
    {
      sum += arr[start];
      ++start;
      return sumRec(arr, start, end, sum);
    }
    else
    {
      return sum;
    }
  }

}

