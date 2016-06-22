import java.awt.* ;
import javax.swing.* ;
import java.util.Arrays;
import java.util.Date ;

public class PershtatjaELakores {

	public static int SLEEP = 1 ;

	public static void main(String[] args) {

		double[] values = { +1, -3, +1, -2, +1, -1, +4, +3, -3, +1 } ;		// vlerat y
		
		double[] v = Arrays.copyOf(values,values.length);
		Arrays.sort(v);
		
		double deltaX = 0.01 ;												// saktesia	

		JFrame frame = new JFrame("Pershtat lakoret me pika") ;
		Graph graph = new Graph(-1.0,v.length,v[0]-1,v[v.length-1]+1,1000,500) ;
		frame.getContentPane().add(graph) ;
		frame.pack() ;
		frame.setVisible(true) ;
		sleep(500) ;

		// Nderto pikat
		graph.PEN_WIDTH = 10 ;		
		graph.PEN_COLOR = Color.black ;		
		for (int x=0 ; x<values.length ; x++) { graph.point(x,values[x]) ; }		
      // Nderto polinomin interpolues te Lagranzhit
		graph.PEN_WIDTH = 3 ;
		graph.PEN_COLOR = Color.red ;
		Polynomial lagrange = Lagrange.interpolate(values) ;
		for (double x=0 ; x<values.length-1 ; x+=deltaX) {
			graph.point(x,lagrange.evaluate(x)) ;
			sleep(SLEEP) ;
		}

		// Nderto Cubic Spline
		graph.PEN_WIDTH = 3 ;
		graph.PEN_COLOR = Color.blue ;
		Spline spline = new Spline(values) ;
		for (double x=0 ; x<values.length-1 ; x+=deltaX) {
			graph.point(x,spline.evaluate(x)) ;
			sleep(SLEEP) ;
		}

	}

	public static void sleep(long milliseconds) {
		Thread thread = new Thread() ;
		try { thread.sleep(milliseconds) ; }
		catch (Exception e) {}
	}

}