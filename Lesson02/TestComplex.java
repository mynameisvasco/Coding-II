import static java.lang.System.*;

public class TestComplex 
{
  // Exemplo simples de utilização da class Complex
  public static void main(String[] args) 
  {
    if(args.length < 2)
    {
      System.out.println("> ERR: Argumentos insuficientes");
      System.exit(0);
    }
    
    Complex a = new Complex(Double.parseDouble(args[0]), Double.parseDouble(args[1]));

    // Vamos usar métodos do objeto a
    out.println("(" + a.real() + " + " + a.imag() + "i)");
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  argumento =  %2.2f\n", a.arg());
  }
}

class Complex 
{
  private double re;
  private double im;

  public Complex(double real, double imag) 
  {
    re = real;
    im = imag;
  }

  public double real() 
  { 
    return re;
  } 

  public double imag() 
  {
    return im;
  } 

  public double abs() 
  {
    return Math.sqrt(re * re + im * im);
  } 

  public double arg() 
  {
    return Math.atan2(im, re);
  }
}
