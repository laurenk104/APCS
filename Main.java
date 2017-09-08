import java.awt.Container;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame flag = new JFrame("Flag");
		flag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		flag.setBackground(Color.white);
		flag.setSize(741, 390);
		
		Flag f = new Flag();
		Container c = flag.getContentPane();
		c.add(f);
		flag.setVisible(true);
		flag.setResizable(true);
	}

}