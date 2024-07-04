public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.print();
        System.out.println("Stack length is " + stack.size());
        while (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println(stack.isEmpty());
    }
}