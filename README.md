 ToDo
Template code for assignment *ToDo* on course *IT401G - Object Oriented Programming, University of Skövde, Sweden.*

Download this repository from GitHub using the green button labeled **Code**. In the downloaded archive you will fine this readme file, a documentation foler, and a *src*-folder containing the java-file you will need for the assignment. If you prefer, you can of course also clone this repository using Git. 

## Package se.his.it401g.todo
This package contains several classes that you will need to complete the assignment. Please see the [package documentation](https://billingo.github.io/ToDo/) for details on each class. This documentation is generated from source code and can also be found as comments in the Java source files.

Note that this package is supposed to be used as parts in other programs, it can not be executed separately. If you want to test running some code in this library, add the following to an empty class called *Test*, creating a minimal application that will display a single Task:

```java
import javax.swing.JFrame;
import se.his.it401g.todo.*;

public class Test {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Task task = new WorkTask();
		frame.add(task.getGuiComponent());
		frame.setBounds(100,100,400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
```
## Loading classes dynamically

Since task types are specified as program arguments and not known until the application executes, the corresponding classes can not be written explicitly in the source code. The only thing we know beforehand is that specified task types must implement the `Task.java` interface. Classes are loaded using the `Class.forName` method. 

You may use the following code to load a class type and instanciate an object from the loaded class. This code declares a class named `TaskTypeLoader` with a static method `TaskTypeLoader.newTask` that will return an instance of the specified task type. 

For example, an instance of `WorkTask` can be created like this: `Task t = TaskTypeLoader.newTask("se.his.it401g.todo.WorkTask");`.

```java
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
```

You may copy-paste this code into your application or write your own solution. This code is merely provided as an example. 

Good luck!