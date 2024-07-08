public class BinaryTree<T> {
    private TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data) {
        TreeNode<T> newTreeNode = new TreeNode<>(data);
        if (root == null) {
            root = newTreeNode;
            return;
        }
        Queue<TreeNode<T>> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentTreeNode = queue.dequeue();
            if (currentTreeNode.getLeft() == null) {
                currentTreeNode.setLeft(newTreeNode);
                break;
            } else {
                queue.enqueue(currentTreeNode.getLeft());
            }
            if (currentTreeNode.getRight() == null) {
                currentTreeNode.setRight(newTreeNode);
                break;
            } else {
                queue.enqueue(currentTreeNode.getRight());
            }
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Queue<TreeNode<T>> queue = new Queue<>();
        queue.enqueue(root);
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode<T> currentTreeNode = queue.dequeue();
            result.append(currentTreeNode.getData());
            result.append(", ");
            if (currentTreeNode.getLeft() != null) {
                queue.enqueue(currentTreeNode.getLeft());
            }
            if (currentTreeNode.getRight() != null) {
                queue.enqueue(currentTreeNode.getRight());
            }
        }
        result.setLength(result.length() - 2);
        System.out.println(result);
    }
}
