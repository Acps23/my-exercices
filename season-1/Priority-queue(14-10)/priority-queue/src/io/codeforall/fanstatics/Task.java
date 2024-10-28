package io.codeforall.fanstatics;

import java.util.Comparator;

public class Task implements Comparable<Task>{

    private TodoList.Importance importance;
    private int priority;
    private String description;

    public Task(){

    }
    public Task (TodoList.Importance importance, int priority, String description){
        this.importance = importance;
        this.priority = priority;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "importance=" + importance +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Task task) {
        if (importance.compareTo(task.importance) == 0){
            return priority - task.priority;
        }
        return importance.compareTo(task.importance);
    }

    public String getDescription() {
        return description;
    }
}
