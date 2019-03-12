package number;

/**
 * Tipo de dados representando uma fracção.
 * Nesta versão pretende-se garantir um invariante (interno) mais forte:
 * as frações armazenadas devem ter sempre denominador positivo.
 * Isto permite simplificar alguns métodos.
 *
 * AVISO: Vários métodos podem dar erros devidos a overflow.
 * (Não deve haver problemas com numeradores e denominadores até 46430.)
 *
 * @author João Manuel Rodrigues
 * 2007--2018
 */

public class Fraction implements Comparable<Fraction>
{
  private int num;
  private int den;
  public static final Fraction ZERO = new Fraction(0,1);
  public static final Fraction ONE = new Fraction(1,1);

  /** Cria uma nova fracção a partir de um par (numerador, denominador).
   *  @param num numerador da nova fracção.
   *  @param den denominador da nova fracção.
   *  <b>Exige (pré-condição):</b> den != 0.
   */
  public Fraction(int num, int den) 
  {
    assert den != 0; // check precondition

    if(den < 0)
    {
      num *= -1;
      den = Math.abs(den);
    }
    else if(den < 0 && num < 0)
    {
      num = Math.abs(num);
      den = Math.abs(den);
    }

    int gdc = gcd(num, den);
    if(gdc == 0)
    {
      this.num = num;
      this.den = den;
    }
    else
    {
      this.num = num/gdc;
      this.den = den/gdc;
    }

    assert invariant() : "Erro do invariant"; // check object invariant
  }

  /* Testa o invariante do objeto.
   * Ou seja, a propriedade que define a validade de uma fração.
   * É para testar em asserções nos métodos.
   */
  public boolean invariant() {
    return den > 0;   // O denominador não pode ser nulo!
  }

  /** Converte uma string numa fracção.
   *  @param str String no formato {@code "inteiro/inteiro"}
   *             representando uma fracção válida.
   *  @return fracção correspondente a {@code str}.
   */
  public static Fraction parseFraction(String str) 
  {
    String[] p = str.split("/", 2);  // divide a string em até 2 partes
    int n = Integer.parseInt(p[0]);  // extrai numerador
    int d = (p.length==2)? Integer.parseInt(p[1]) : 1;
        // se tem 2 partes, extrai denominador, senão fica d=1
    if (d == 0) return null;

    //Caso o denominador seja negativo, passar o sinal negativo para o numerador e remover do denominador
    if (d < 0)
    { 
      n *= -1;
      d = Math.abs(d);  
    }
    else if (d < 0 && n < 0)
    {
      d = Math.abs(d);
      n = Math.abs(n);
    }

    return new Fraction(n, d);
  }

  /** Converte a fracção numa string.
   *  @return string com a representação desta fracção.
   */
  public String toString() 
  {
    // Com um invariante mais forte, podemos simplificar este método!
    String s = num + "/" + den;
    return s;
  }

  /** Devolve o numerador da fracção.
   *  @return numerador desta fração.
   */
  public int num() { return num; }

  /** Devolve o denominador da fracção.
   *  @return denominador desta fração.
   */
  public int den() { return den; }

  /** Multiplica esta fracção por outra (this * b).
   *  @param b multiplicando.
   *  @return fracção produto de this * b.
   */
  public Fraction multiply(Fraction b) {
    int n = num*b.num;
    int d = den*b.den;
    Fraction p = new Fraction(n, d); // product
    return p;
  }

  /** Adiciona esta fracção com outra (this + b).
   *  @param b fracção a adicionar a esta.
   *  @return fracção soma de this + b.
   */
  public Fraction add(Fraction b) {
    int n = num*b.den + den*b.num;
    int d = den*b.den;
    Fraction s = new Fraction(n, d); // sum
    return s;
  }

  public Fraction divide(Fraction b) 
  {
    int n = this.num * b.den;
    int d = this.den * b.num;

    assert n/b.den == this.num : "Divisão errada";
    assert d/b.num == this.den : "Divisão errada";

    Fraction s = new Fraction(n, d);
    return s;
  }

  public Fraction subtract(Fraction b) 
  {
    int n = num*b.den - den*b.num;
    int d = den*b.den;

    assert n + den*b.num == num*b.den : "Subtração errada";
    assert den == d/b.den : "Subtração errada";

    Fraction s = new Fraction(n, d);
    return s;
  }

  public boolean equals(Fraction b) 
  {
    return (this.den / this.num == b.den / b.num) ? true : false;
  }

  public int compareTo(Fraction b) 
  {
    if((this.num/this.den) < (b.num/b.den))
    {
      return -1;
    } 
    else if((this.num/this.den) > (b.num/b.den))
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }
  private static int gcd(int a, int b)
  {
    while (b > 0)
    {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
  }
}
