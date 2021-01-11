# ToDo
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

Good luck!