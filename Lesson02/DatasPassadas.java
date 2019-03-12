import static java.lang.System.*;

public class DatasPassadas {

  public static void main(String[] args) 
  {
    Data atual = new Data();
    Data target = new Data(25, 12, 2018);

    while(true)
    {
      if(atual.dia() == target.dia() && atual.mes() == target.mes() && atual.ano() == target.ano())
      {
        break;
      }
      else
      {
        System.out.println(target.extenso());
        target.seguinte();
      }
    }
  }
}

