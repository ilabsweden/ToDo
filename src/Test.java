import javax.swing.JFrame;
import se.his.it401g.todo.*;

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