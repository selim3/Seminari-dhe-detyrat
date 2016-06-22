
import java.util.Scanner;
import java.util.Scanner.*;

public class Matrica {
	
	Scanner s = new Scanner(System.in);
	public double[][] matrica()
	{
		System.out.println("Sheno rendin e matrices:");
		int n = s.nextInt();
		double[][] matrica =  new double[n][n]; 
		return matrica;
	}
	
	public double[][] inicializimiMatrices(double[][] m)
	{
		System.out.println("Sheno elementet e matrices:");
		double[][] matrica = m;
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m.length; j++)
            {	
            	matrica[i][j] = s.nextDouble();
            }	        
        }
        return matrica;
	}
	
	public double infinitMatrica(double[][] m)
	{
		double max = 0;
		for(int i = 0; i <m.length;i++)
		{
			double sum = 0;
			for(int j = 0; j<m.length; j++)
			{
				sum = sum + Math.abs(m[i][j]);
			}
			
			if(sum > max)
			{
				max = sum;
			}
		}
		return max;
	}
	
	public double[][] shfaqjaMatrice(double[][] m)
	{
		System.out.println("Paraqitja e matrices:");
		double[][] matrica = m;
        for(int i=0; i<m.length; i++)
        {
        	System.out.print("");
            for(int j=0; j<m.length; j++)
            {	
            	System.out.print(" " + matrica[i][j]);
            }	 
            System.out.println();
        }
        return matrica;
	}
	
	public double Frobenius(double[][] m)
	{
		double[][] matrica = m;
		double sum = 0;
		for(int i = 0; i < matrica.length;i++)
		{
			for(int j = 0; j< matrica.length; j++)
			{
				sum = sum + matrica[i][j]*matrica[i][j];
			}
		}
		return Math.sqrt(sum);
		
	}
	
	public static void main(String [] args)
	{
		Matrica m = new Matrica();
		double[][] n = m.matrica();
		m.inicializimiMatrices(n);
		m.shfaqjaMatrice(n);
		System.out.println("Norma infinit:");
		System.out.println(m.infinitMatrica(n));
		System.out.println("Norma Frobenius:");
		System.out.println(m.Frobenius(n));
	}

}
