public record Node<T>(int priority, T data) implements Comparable<Node<T>> {
    @Override
    public int compareTo(Node<T> o) {
        return Integer.compare(this.priority, o.priority);
    }
}
