import static java.lang.System.*;

public class DatasPassadas {

  public static void main(String[] args) 
  {
    Data atual = new Data();
    Data target = new Data(25, 12, 2018);

    while(target.ano() != atual.ano())
    {
      if(target.mes() == atual.mes())
      {
        if(target.dia() == atual.dia())
        {
          break;
        }
        else
        {
          System.out.println(target.extenso());
          target.seguinte();
        }
      }
      else
      {
        System.out.println(target.extenso());
        target.seguinte();
      }
    }
  }
}

