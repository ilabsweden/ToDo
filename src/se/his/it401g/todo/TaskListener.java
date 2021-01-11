package se.his.it401g.todo;

/**
 * This is a listener interface where task objects can report changes to the main application.  
 *  
 * This file licensed under the <a href="https://creativecommons.org/licenses/by/4.0/">Creative Commons (CC) BY 4.0 license</a>.
 * 
 * @author Dr. Erik Billing, University of Skovde
 *
 */
public interface TaskListener {
	/**
	 * Called when a task is modified.
	 * 
	 * @param t is the modified task
	 */
	public void taskChanged(Task t);
	
	/**
	 * Called when a task is completed.
	 * 
	 * @param t is the completed task
	 */
	public void taskCompleted(Task t);
	
	/**
	 * Called when completion status is removed.
	 * 
	 * @param t is the modified task
	 */
	public void taskUncompleted(Task t);
	
	/**
	 * Called when a task is created.
	 * 
	 * @param t is the new task
	 */
	public void taskCreated(Task t);
	
	/**
	 * Called when a task is removed.
	 * 
	 * @param t is the removed task
	 */
	public void taskRemoved(Task t);
	
}
