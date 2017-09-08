//There is also a Main.java file that goes along with this java file

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Flag extends JPanel {
	//shades of blue and red that are more realistic to the US flag
	private final Color stripe = new Color(0xBF0A30);
	private final Color union = new Color(0x002868);
	
	public Flag() {
		init();
	}
	
	public void init() {
		setBackground(Color.WHITE);
		repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		//gets current x and y coordinates of the JPanel as it is dragged
	      int x = e.getX();
	      int y = e.getY();
	      
	     //current length/original length
	      int length = x/741;
	    //current width/original width
	      int width = y/390;
	      setSize(length, width);
	      repaint();
	      
	    }
	
	//creates the stars
	public void Star(Graphics g, double w, double h) {
		g.setColor(Color.WHITE);
		
		//radius of star
		int r = (int) (0.0616*w*(0.063/1.9)*6);
		
		//radius of inner pentagon and outer pentagon, which make up the star
		int radius[] = {r, r/2, r, r/2};
		
		//number of points in the star
		int nPoints = 10;
		int[] X = new int[nPoints];
		int[] Y = new int[nPoints];
		
		//offset the star
		for (double x = w*(0.063/1.9); x <= w*(0.063*6); x += w*(2*0.063/1.9)) {
			for (double y = h*(0.054); y <= h*(0.054*10); y += h*(2*0.054)) {
				for (double current=0.0; current < nPoints; current++) {
					int i = (int) current;
					//determines the angles needed to draw the lines of the stars
					double xCoord = Math.cos(current*((2*Math.PI)/10)+60)*radius[i % 4];
					double yCoord = Math.sin(current*((2*Math.PI)/10)+60)*radius[i % 4];

					X[i] = (int) (xCoord + x);
					Y[i] = (int) (yCoord + y);
				}
				g.fillPolygon(X, Y, 10);
			}
		} 
		
		//offset the star
		for (double x = 2*w*(0.063/1.9); x <= w*(0.063*6); x += w*(2*0.063/1.9)) {
			for (double y = 2*h*(0.054); y <= h*(0.054*8); y += h*(2*0.054)) {
				for (double current=0.0; current<nPoints; current++) {
					int i = (int) current;
					//determines the angles needed to draw the lines of the stars
					double xCoord = Math.cos(current*((2*Math.PI)/10)+60)*radius[i % 4];
					double yCoord = Math.sin(current*((2*Math.PI)/10)+60)*radius[i % 4];

					X[i] = (int) (xCoord + x);
					Y[i] = (int) (yCoord + y);
				}
				g.fillPolygon(X, Y, 10);
			} 
		} 
		
	} 
	
	public void flag(Graphics g, double w, double h) {
		g.drawRect(0, 0, (int) w, (int) h);
		
		//stripes
		g.setColor(stripe);
		for (int i = 0; i < h; i += (2 * h/13)) {
			g.fillRect(0, i, (int) w, (int) h/13);
		}
		
		//union
		g.setColor(union);
		g.fillRect(0, 0, (int) (w*2/5), (int) (h*7/13));
		
		//stars
		Star(g, w, h);
	}
	
	public void paint(Graphics g) {
		//height of dragged JFrame
		double height = super.getSize().getHeight();
		//width of dragged JFrame
		double width = super.getSize().getWidth();
		flag(g, width, height);
	}
}