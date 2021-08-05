package it.studiuje.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        printTasks(tasks);
        Scanner console = new Scanner(System.in);

        while (console.hasNext()) {
            String read = console.nextLine();

            if (read.startsWith("add")) {
                String content = read.replace("add", "").trim();
                tasks.add(new Task(content, false));
                System.out.println("Added new task: " + content);
            }
            if (read.startsWith("remove")) {
                int index = Integer.parseInt(read.replace("remove", "").trim());
                String content = tasks.get(index).getContent();
                tasks.remove(index);
                System.out.println("Removed task: " + content);
            }
            if (read.startsWith("complete")) {
                int index = Integer.parseInt(read.replace("complete", "").trim());
                String content = tasks.get(index).getContent();
                boolean status = tasks.get(index).isCompleted();
                if (status) {
                    System.out.println("Task " + content + " is already complete.");
                } else {
                    Task task = tasks.get(index);
                    task.setCompleted();
                    tasks.set(index, task);
                    System.out.println("Change status on: "
                            + content + " from "
                            + status + " to "
                            + tasks.get(index).isCompleted());
                }
//                tasks.get(index).setCompleted();
            }
            if (read.startsWith("incomplete")) {
                int index = Integer.parseInt(read.replace("incomplete", "").trim());
                String content = tasks.get(index).getContent();
                boolean status = tasks.get(index).isCompleted();
                if (!status) {
                    System.out.println("Task " + content + " is already uncompleted.");
                } else {
                    Task task = tasks.get(index);
                    task.setUncompleted();
                    tasks.set(index, task);
                    System.out.println("Change status on task: "
                            + content + " from "
                            + status + " to "
                            + tasks.get(index).isCompleted());
                }
//                tasks.get(index).setUncompleted();
            }
            if (read.startsWith("change")) {
                int index = Integer.parseInt(read.replace("change", "").trim());
                String content = tasks.get(index).getContent();
                Task task = tasks.get(index);
                System.out.println("Change task: " + content );
                String changedContent = console.nextLine();
                task.setContent(changedContent);
                tasks.set(index, task);
                System.out.println("Change task " + content + " to " + changedContent);
            }
            printTasks(tasks);
        }
    }

    public static void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("TODO list is empty. Add elements!");
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(
                    "Index: " + i
                            + ", content " + tasks.get(i).getContent()
                            + ", status: " + tasks.get(i).isCompleted());
        }
    }
}
