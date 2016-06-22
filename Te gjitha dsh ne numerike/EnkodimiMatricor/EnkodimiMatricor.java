/** Enkripton mesazhin me metoden e enkodimit matricor */
public class EnkodimiMatricor
{
	public byte[] m = new byte[26];
	public EnkodimiMatricor()
	{
		byte j = 0;
		for(byte i = 97; i <= 122; i++)
			m[j++] = i;
	}
	
	/** Enkripton mesazhin me metoden e enkodimit matricor
	 *	@param message - mesazhi qe duhet te enkriptohet
	 *	@param A - matrica e enkodimit
	 *	@param B - vektori i enkodimit
	 *	@return - mesazhi i enkriptuar */
    	public byte[] Enkriptimi(byte[] mesazhi,byte[][] A,byte[] B)
			{
				byte[] pergjigjja = new byte[mesazhi.length];
	    		for (byte i = 0; i < mesazhi.length; i+=2)
	   			{  
		   			pergjigjja[i] = (byte)(m[(A[0][0]*(mesazhi[i]-19)+A[0][1]*(mesazhi[i+1]-19) + B[0]) % 26]);
	   	 			pergjigjja[i+1]=(byte)(m[(A[1][0]*(mesazhi[i]-19)+A[1][1]*(mesazhi[i+1]-19) + B[1]) % 26]);
					}
				return pergjigjja;
			}
	
	/** Dekripton mesazhin me metoden e enkodimit matricor
	 *	@param message - mesazhi qe duhet te dekriptohet
	 *	@param A - matrica me te cilen do te behet dekriptimi
	 *	@param B - vektori per dekriptim (i njejte me ate per enkriptim)
	 *	@return - mesazhi i dekriptuar */
		public byte[] Dekriptimi(byte[] mesazhi,byte[][] A,byte[] B)
			{
				byte[] pergjigjja = new byte[mesazhi.length];
	    			for (int i = 0; i < mesazhi.length; i+=2)
						{
							pergjigjja[i] = (byte)(m[(A[0][0]*(mesazhi[i] - B[0]+7) + A[0][1]*(mesazhi[i+1]-B[1]+7)) % 26]);
							pergjigjja[i+1] = (byte)(m[(A[1][0]*(mesazhi[i] - B[0]+7) + A[1][1]*(mesazhi[i+1]-B[1]+7)) % 26]);
						}
	  		 	return pergjigjja;
			}
}
