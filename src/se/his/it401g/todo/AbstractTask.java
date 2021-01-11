package se.his.it401g.todo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * This abstract class implements a task type following the Task.java interface. It also implements a GUI representation of the task by extending the JPanel class.
 * 
 * This task should be seen as an example of how a task type can be implemented. You are allowed (but not required) to extend, copy and reuse the whole or parts of this class, but do not modify this file directly. 
 * 
 * This file licensed under the <a href="https://creativecommons.org/licenses/by/4.0/">Creative Commons (CC) BY 4.0 license</a>.  
 * 
 * @author Dr. Erik Billing, University of Skovde
 *
 */
public abstract class AbstractTask extends JPanel implements Task {
	
	/**
	 * The editable text field. 
	 */
	private JTextField text;
	
	/**
	 * The non editable text label.
	 */
	private JLabel textLabel;
	
	/**
	 * Check box holding the completion status. 
	 */
	JCheckBox completed = new JCheckBox();
	
	/**
	 * The task listener used for reporting changes to the main application. 
	 */
	private TaskListener listener;
	
	/**
	 * This is the constructor for the task, initiating the GUI component for the task. Several listeners are used to react to various events in the GUI.  
	 */
	public AbstractTask() {
		super(new BorderLayout());
		AbstractTask self = this;
		this.text = new JTextField("New task",20);
		this.textLabel = new JLabel();
		this.textLabel.setVisible(false);
		JPanel center = new JPanel();
		center.add(text);
		center.add(textLabel);
		add(center);
		
		this.text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					text.setVisible(false);
					textLabel.setText(text.getText());
					textLabel.setVisible(true);
					if (listener != null) listener.taskChanged(self);
				}
			}
		});
		this.textLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				textLabel.setVisible(false);
				text.setVisible(true);				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		JButton remove = new JButton("Remove");
		add(remove,BorderLayout.EAST);
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listener != null) listener.taskRemoved(self);				
			}
		});
		
		add(completed,BorderLayout.WEST);
		completed.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1 && listener != null) {
					listener.taskCompleted(self);
				} else if (listener != null) {
					listener.taskUncompleted(self);
				}
			}
		});
		
		setMaximumSize(new Dimension(1000,50));
		setBorder(new TitledBorder(getTaskType()));
	}
	
	@Override
	public String getText() {
		return text.getText();
	}
	
	@Override
	public Component getGuiComponent() {
		return this;
	}

	@Override
	public boolean requestFocusInWindow() {
		return text.requestFocusInWindow();
	}
	
	@Override
	public void setTaskListener(TaskListener t) {
		this.listener = t;		
	}

	@Override
	public TaskListener getTaskListener() {
		return listener;
	}

	@Override
	public boolean isComplete() {
		return completed.isSelected();
	}
}
