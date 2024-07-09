public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);

        binarySearchTree.balance();
        binarySearchTree.print();

        System.out.println(binarySearchTree.exists(44));
        System.out.println(binarySearchTree.findParentAndTargetNode(2));

        binarySearchTree.inOrder();
        System.out.println();
        binarySearchTree.postOrder();
        System.out.println();
        binarySearchTree.preOrder();

        if (binarySearchTree.delete(5))
            System.out.println("\nNode is deleted successfully!");
        binarySearchTree.print();
    }
}