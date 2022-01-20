package se.his.it401g.todo;


import java.awt.Component;

/**
 * This interface class represents a task type. All communication between individual task objects and the main application should be made using method specified here, or in the related interface TaskListener.
 * 
 * This file licensed under the <a href="https://creativecommons.org/licenses/by/4.0/">Creative Commons (CC) BY 4.0 license</a>.  
 * 
 * @author Dr. Erik Billing, University of Skovde
 *
 */
public interface Task {

	/**
	 * @return a short description/title of the task 
	 */
	public String getText();
	
	/**
	 * @return the name of the task type, e.g., "Work" for work related tasks. 
	 */
	public String getTaskType();
	
	/**
	 * Sets the task listener on which this task reports various events. 
	 * @param t the listener to use.
	 */
	public void setTaskListener(TaskListener t);
	
	/**
	 * @return the task listener currently used. 
	 */
	public TaskListener getTaskListener();
	
	/**
	 * @return true if the task has status "complete", otherwise false.
	 */
	public boolean isComplete();
		
	/**
	 * @return the graphical user interface component representing this task. 
	 */
	public Component getGuiComponent();
}
