import java.util.Arrays;

public class Lagrange {

	public static Polynomial interpolate(double[] values){

		double[] Px = new double[values.length];		//Polinomi i Lagranzhit
		double[] binomial = new double[2];				// perkohesisht mban binomet per shumezim 

		for(int x = 0; x<values.length; x++){

			//llogarit Pi(x)
			double[] Pix = new double[values.length];			// Pi termat e PL qe mblidhen per te gjetur PL 
			double[] accumulator = new double[values.length]; 	// initialize to one?

			Pix[0] = values[x];		// inicializo Pi(x) ne Yi
			// shumezo binomet
			for(int k = 0; k<values.length; k++){
				// kalo neser k==x
				if(k==x) continue;

				//krijo binomet (p.sh. x+3)
				binomial[1] = (double)1/(x-k);		// x termat
				binomial[0] = (double)(-k)/(x-k);		// termat konstant
				
				//shumezo akumulatorin nga binomet 
            				Pix = biMult(Pix,binomial);

			}

			//Shto Pi(x) termave
			for(int j=0; j<values.length; j++){
				Px[j] = Px[j] + Pix[j];
			}
		}

		Polynomial result = new Polynomial(Px);
		return result;
	}

	public static double[] biMult(double[] polynomial, double[] binomial){

		double[] accumulator = new double[polynomial.length];
			
		for(int i=0; i<polynomial.length; i++){
			double a = polynomial[i]*binomial[0];

			double b;
			if(i-1<0) b = 0;
			else b = polynomial[i-1]*binomial[1];

			accumulator[i] = a+b;
		}
		
		return accumulator;
	}

}