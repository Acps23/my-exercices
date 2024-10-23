package io.codeforall.fanstatics;

import java.util.PriorityQueue;

public class TodoList {

    private PriorityQueue<Task> priorityQueue = new PriorityQueue<>();

    public enum Importance {
        HIGH,
        MEDIUM,
        LOW;
    }

    public void add(Importance importance, int priority, String description) {
        Task task = new Task(importance, priority, description);
        priorityQueue.add(task);
    }

    public Task remove() {
        return priorityQueue.remove();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }
}
