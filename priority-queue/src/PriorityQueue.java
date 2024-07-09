public class PriorityQueue<T> {
    private final Heap<Node<T>> heap;

    public PriorityQueue() {
        heap = new Heap<>();
    }

    public void enqueue(int priority, T data) {
        Node<T> newNode = new Node<>(priority, data);
        heap.insert(newNode);
    }

    public Node<T> dequeue() {
        return heap.pop();
    }

    public void printPriorityQueue() {
        heap.printHeap();
    }
}
