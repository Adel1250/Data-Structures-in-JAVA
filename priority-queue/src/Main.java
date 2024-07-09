public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(5, 24);
        priorityQueue.enqueue(5, 32);
        priorityQueue.enqueue(3, 16);
        priorityQueue.enqueue(3, 45);
        priorityQueue.enqueue(1, 20);
        priorityQueue.enqueue(1, 53);
        priorityQueue.enqueue(2, 14);
        priorityQueue.enqueue(2, 27);

        priorityQueue.printPriorityQueue();
        System.out.println(priorityQueue.dequeue());
        priorityQueue.printPriorityQueue();
    }
}