package entiti.Repository;

import entiti.model.Task;
import entiti.model.User;
import entiti.model.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class TaskRep {
    List<Task> tasks = new ArrayList<>();

    Task task1 = new Task("task1", "do more tasks", "10/28", "10/30", Status.IN_PROGRESS);
    Task task2 = new Task("task1", "do more tasks", "10/28", "10/30", Status.TODO);
    Task task3 = new Task("task1", "do more tasks", "10/28", "10/30", Status.TODO);

    public List<Task> getTasks() {
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        return tasks;
    }
}
