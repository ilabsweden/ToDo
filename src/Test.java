import javax.swing.JFrame;
import se.his.it401g.todo.*;

/**
 * Minimal test application that displays a single task.
 *  
 * This file licensed under the <a href="https://creativecommons.org/licenses/by/4.0/">Creative Commons (CC) BY 4.0 license</a>.
 * 
 * @author Dr. Erik Billing, University of Skovde
 *
 */
public class Test {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Task task = new HomeTask();
		frame.add(task.getGuiComponent());
		frame.setBounds(100,100,400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}