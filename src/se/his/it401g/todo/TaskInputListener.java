package se.his.it401g.todo;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TaskInputListener implements KeyListener, MouseListener, ActionListener, ItemListener {

	private Task task;
	private JLabel textLabel;
	private JTextField text;

	public TaskInputListener(Task task, JTextField text, JLabel textLabel) {
		this.task = task;
		this.text = text;
		this.textLabel = textLabel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		textLabel.setVisible(false);
		text.setVisible(true);				
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			text.setVisible(false);
			textLabel.setText(text.getText());
			textLabel.setVisible(true);
			TaskListener listener = task.getTaskListener();
			if (listener != null) listener.taskChanged(task);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		TaskListener listener = task.getTaskListener();
		if (listener != null) listener.taskRemoved(task);				
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		TaskListener listener = task.getTaskListener();
		if (e.getStateChange() == 1 && listener != null) {
			listener.taskCompleted(task);
		} else if (listener != null) {
			listener.taskUncompleted(task);
		}
	}

}
