public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Adel");
        queue.enqueue("Ahmed");
        queue.enqueue("Mohamed");
        queue.print();
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        queue.print();
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        System.out.println(queue.isEmpty());
    }
}