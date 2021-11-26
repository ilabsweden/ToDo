package se.his.it401g.todo;

import java.lang.reflect.InvocationTargetException;

public class TaskTypeLoader {

	/**
	 * Returns a new instance of specified task type. 
	 * @param taskTypeName
	 * @return new task object
	 */
	public static Task newTask(String taskTypeName) {
		Class<Task> taskType = loadTaskType(taskTypeName);
		if (taskType == null) return null;
		try {
			return taskType.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException	| NoSuchMethodException | SecurityException e) {
			System.out.println("Unable to create an instance of " + taskType.getSimpleName());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Loads specified task type class. The corresponding class must be available in the application's class path. 
	 * @param className is the name of the class to be loaded, including package. 
	 * @return the loaded class. 
	 */
	@SuppressWarnings("unchecked")
	public static Class<Task> loadTaskType(String className) {
		try {
			Class<?> taskType = Class.forName(className);
			if (Task.class.isAssignableFrom(taskType)) {
				return (Class<Task>) taskType;
			} else {
				System.out.println("Class " + taskType.getSimpleName() + " does not implement the Task.java interface.");
			}
		} catch (ReflectiveOperationException e) {
			System.out.println("Task type " + className + " could not be loaded.");
		}
		return null;
	}
}
