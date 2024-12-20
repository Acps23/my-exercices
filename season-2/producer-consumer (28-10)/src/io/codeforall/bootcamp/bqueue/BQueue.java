package io.codeforall.bootcamp.bqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    T generic;
    Queue<T> queue;

    int limit;

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {
        this.limit = limit;
        queue = new LinkedList<>();
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) throws InterruptedException {
        while (getSize() == getLimit()) {
            System.out.println("Kitchen is full.... Waiting");
            wait();
        }
        System.out.println("Coocking order " + queue.size());
        notifyAll();
        queue.offer(data);
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public synchronized T poll() throws InterruptedException {
        while (getSize() == 0) {
            System.out.println("Nothing to eat...");
            wait();

        }
        System.out.println("Eating pizza " + queue.size());
        notifyAll();
        return queue.poll();

    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public int getSize() {

        return queue.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {

        return limit;

    }

}
