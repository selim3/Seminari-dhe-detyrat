
import java.util.Scanner;
import java.util.Scanner.*;


public class Vektori {
	Scanner s = new Scanner(System.in);
	
	public double[] vektori()
	{
		System.out.println("Sheno rendin e vektorit");
		int k = s.nextInt();
		double[] vektori = new double[k];
		return vektori;
		
	}
	
	public double[] inicializimi(double[] v)
	{
		System.out.println("Sheno elementet e vektorit:");
		double[] vektori = v;
		for(int i = 0; i < vektori.length;i++)
		{
			vektori[i] = s.nextDouble();
		}
		return vektori;
	}
	
	public double[] ndryshimi(double[] a,double[] b)
	{
		double[] c = new double[a.length];
		if(a.length == b.length)
		{

			for(int i = 0; i < a.length;i++)
			{
				c[i] = a[i]-b[i];
			}
		}
		else
			System.out.println("Nuk mund te realizohet ndryshimi.");
		return c;
	}
	
	

	public double[] shuma(double[] a,double[] b)
	{
		double[] c = new double[a.length];
		if(a.length == b.length)
		{

			for(int i = 0; i < a.length;i++)
			{
				c[i] = a[i]+b[i];
			}
		}
		else
			System.out.println("Nuk mund te realizohet mbledhja.");
		return c;
	}
	
	public double dy(double [] x)
	{
		double sum=0;
		for(int i=0;i<x.length;i++){
		sum=sum+x[i]*x[i];
		}
		return Math.sqrt(sum);
	}
	
	public double infinit(double[] x)
	{
		double max=0;
		for(int i=0;i<x.length;i++)
		{
			if(Math.abs(x[i])>max)
			{
				max=Math.abs(x[i]);
			}
		}
		return max;
	}	
	
	public static void paraqitja(double[] x)
	{
		double[] t = x;
		System.out.println("Paraqitja e vektorit:");
		for(int i = 0; i < x.length; i++)
		{
			System.out.print(" " + t[i]);
			System.out.println(" ");
		}
		System.out.println();
	}
	
	public static void main(String [] args)
	{
		Vektori v = new Vektori();
		double[] n = v.vektori();
		double[] m = v.vektori();
		v.inicializimi(n);
		v.inicializimi(m);
		double[] o = v.ndryshimi(n, m);
		double[] p = v.shuma(n, m);
		System.out.println("Ndryshimi");
		v.paraqitja(o);
		System.out.println("Shuma");
		v.paraqitja(p);
		System.out.println("Norma dy");
		System.out.println(v.dy(n));
		System.out.println("Norma infinit");
		System.out.println(v.infinit(n));
		System.out.println("Distanca euklidiane:");
		System.out.println(v.dy(o));
		System.out.println("Distanca infinit:");
		System.out.println(v.infinit(o));

	}
}
