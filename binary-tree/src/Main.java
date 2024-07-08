public class Main {
    public static void main(String[] args) {
        BinaryTree<Character> binaryTree = new BinaryTree<>();
        binaryTree.insert('A');
        binaryTree.insert('B');
        binaryTree.insert('C');
        binaryTree.insert('D');
        binaryTree.insert('E');
        binaryTree.insert('F');
        binaryTree.insert('G');
        binaryTree.insert('H');
        binaryTree.insert('I');

        System.out.println("Binary tree's height = " + binaryTree.height());
        System.out.println("Breadth-First:");
        binaryTree.print();
        System.out.println("Pre-Order:");
        binaryTree.preOrder();
        System.out.println("\nIn-Order:");
        binaryTree.inOrder();
        System.out.println("\nPost-Order:");
        binaryTree.postOrder();

        char deletedData = 'C';
        if (binaryTree.delete(deletedData))
            System.out.println("\n" + deletedData + " is deleted successfully!");
        binaryTree.print();
    }
}