import java.io.*;

/**
 * Este c�digo se trata de saber como se manejan las recursiones en la programaci�n para 
 * resolver problemas
 * @author Cesar Barrero
 */

public class Recursiones 
{
	/**
	 * La funci�n consiste en hallar el m�ximo com�n divisor entre dos n�meros 
	 * @param a
	 * @param b
	 * @return Se retorna un entrero es el m�s grande en que se pueden dividor los dos
	 */
	public static int mcd_euclides(int a, int b)
	{
		if (b == 0) 
			return a;
		else
			return mcd_euclides(b, a % b);
	}
	
	
	/**
	 * La funci�n consiste en multiplicar una serie de n�meros que descienden contando al 1
	 * @param x
	 * @return Se retorna el valor de la multiplicaci�n de los n�meros que lo descienden 
	 */
	public static int factorial(int x) //Recursi�n para hallar factorial
	{
		if (x == 1) 
			return 1;
		else
			return x * factorial(x - 1);
	}
	
	
	/**
	 * La funci�n consiste en la suma de los dos anteriores comenzando con 0 y 1
	 * @param x
	 * @return Se retorna el valor de las sumas, ya sean x veces, como se prefiera 
	 */
	public static int fibonacci(int x) //Recursi�n para la sucesi�n fibonacci
	{
		if (x == 0) 
			return 0;
		else
			if(x == 1)
				return 1;
			else
				return fibonacci(x - 1) + fibonacci(x - 2);
	}
	
	
	/**
	 * La funci�n genera un tri�ngulo de n�meros entreros, infinito y simetrico, se empieza 
	 * en 1 y sus bordes est�n en 1
	 * @param n
	 * @param k
	 * @return Se retorna un tri�ngulo, del cual lo de adentro es la suma de los que tiene
	 * encima 
	 */
	public static int pascal(int n, int k) //Recursi�n para el tri�ngulo de pascal
	{
		if (k == 0 || k == n)
			return 1;
		else 
			return pascal(n - 1, k - 1) + pascal(n - 1, k);
	}
	
	
	/**
	 * La funci�n imprime el tri�ngulo de pascal
	 * @return Se retornan n�meros enteros formando el tri�ngulo de pascal
	 */
	public static String print_pascal()
	{
		String pascal_matrix = "";
		
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j <= i; j++) 
				pascal_matrix += pascal(i, j) + "\t";
			pascal_matrix += "\n";
		}
		return pascal_matrix;
	}
	
	
	/**
	 * La funci�n consiste en sumar un n�mero tantas veces como lo diga el otro n�mero 
	 * @param n
	 * @param x
	 * @return Se retorna el valor total de la suma 
	 */
	public static int multiplicacion(int n, int x) //Recursi�n para multiplicar
	{
		if (x == 1) 
			return n;
		else 
			return n + multiplicacion(n, x - 1); 
	}
	
	
	/**
	 * La funci�n consiste en ingresar una cadena y luego invertirla 
	 * @param cadena
	 * @return Se retorna la cadena que se ingreso al rev�s
	 */
	public static String inversa_cadena(String cadena)
	{
		if (cadena.length() == 1) 
		{
			return cadena;
		}
		else
		{
			return inversa_cadena(cadena.substring(1)) + cadena.charAt(0);
		}
	}
	
	
	public static void main(String[] args) 
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try 
		{
			bw.write(Recursiones.factorial(15) + "\n");
			bw.flush();
			
			bw.write(Recursiones.fibonacci(25) + "\n");
			bw.flush();
			
			bw.write(Recursiones.multiplicacion(654, 97) + "\n");
			bw.flush();
			
			bw.write(Recursiones.mcd_euclides(369, 1218) + "\n");
			bw.flush();
			
			bw.write(Recursiones.inversa_cadena("asdfghjkl") + "\n");
			bw.flush();
			
			bw.write(Recursiones.print_pascal() + "\n");
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}