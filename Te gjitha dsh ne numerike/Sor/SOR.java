



public class SOR {
	public static String sor(int n ,double[][] A, double[] b, double[] x0, double TOL,int N, double w){
		
	     int p =1;
	     double sum =0;
	     double ssum =0;
	     double[] x=new double[n];
	   while( p <= N)
	     {
	      for(int i =0; i<n; i++)
	      {
	       for(int j = 0; j < i-1; j++)
	       {
	        sum =sum+ A[i][j]*x[j];
	       }
	       for(int j = i+1; j<n; j++)
	       {
	        ssum =ssum+ A[i][j]*x0[j];
	       }
	       x[i] = (1 -w)*x0[i] +(w *(-sum - sum + b[i]))/A[i][i];
	       sum = 0;
	       ssum =0;
	      }
	      for (int i=0;i<n;i++){
	      if (Math.abs(x[i]-x0[i])<TOL);
	      System.out.print("Rezultati :");
	      for(int s =0; s<n; s++)
	        {
	         System.out.print(x[s] + " "); 
	        }
	      System.exit(0);
	      }
	      p++;
	      for (int i =1; i <n; i++ ){
	    	x0[i]=x[i];  
	      }
	
		
	}
	return  "Numr i iteracioneve ka tejkaluar " + p;

	   
	   
	}
	public static void main (String[]args){
		 int n =3;
	     double[][] A = {{1,2,3}, {4,5,6},{1,-2,3}};
	     double[] b = {10,32,22};
	     double[] x0 = {1,1,1};
	     double TOL = (1e-2);
	     int NO = 3;
	     double w = 1.25;
	     System.out.println("Rezultati: " + sor(n,A,b,x0,TOL,NO,w));
	}
}