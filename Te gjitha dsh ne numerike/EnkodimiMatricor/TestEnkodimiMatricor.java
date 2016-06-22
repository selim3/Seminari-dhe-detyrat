/** Teston klasen EnkodimiMatricor per enkriptim dhe dekriptim*/
import javax.swing.*;
public class TestEnkodimiMatricor
{
	public static void main(String args[])
	{
		EnkodimiMatricor c = new EnkodimiMatricor();
	   	String msg =JOptionPane.showInputDialog("Sheno fjalen qe engriptohet me gjatesi cifte"); 
			byte[][] A = new byte[2][2];	
			byte[][] I = new byte[2][2];	
			byte[] B = new byte[2];
			A[0][0] = 11;
			A[0][1] = 8;
			A[1][0] = 3;
			A[1][1] = 7;
			B[0] = 2;
			B[1] = 8;
			I[0][0] = 7;
			I[0][1] = 18;
			I[1][0] = 23;
			I[1][1] = 11;
	   	byte[] msgVargu = msg.getBytes();
	   	byte[] enk = c.Enkriptimi(msgVargu,A,B);
	   	String enk1 = new String(enk);
			byte[] dek=c.Dekriptimi(enk,I,B);
			String dek1=new String(dek);
			JOptionPane.showMessageDialog(null,"Teksti i enkriptuar : "+ enk1 + "\n Teksti i Dekriptuar : "+ dek1);	}
}