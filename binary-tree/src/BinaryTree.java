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
            result.append(" ");
            if (currentTreeNode.getLeft() != null) {
                queue.enqueue(currentTreeNode.getLeft());
            }
            if (currentTreeNode.getRight() != null) {
                queue.enqueue(currentTreeNode.getRight());
            }
        }
        System.out.println(result);
    }

    private int height(TreeNode<T> treeNode) {
        if (treeNode == null)
            return 0;
        return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
    }

    public int height() {
        return height(root);
    }

    private void preOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.getData() + " ");
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }

    public void preOrder() {
        preOrder(root);
    }

    private void inOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.getLeft());
        System.out.print(treeNode.getData() + " ");
        inOrder(treeNode.getRight());
    }

    public void inOrder() {
        inOrder(root);
    }

    private void postOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.print(treeNode.getData() + " ");
    }

    public void postOrder() {
        postOrder(root);
    }

    public Result<T> breadthFirstSearch(T data) {
        if (root == null)
            return null;

        if (root.getData().equals(data)) {
            return new Result<>(null, root);
        }

        Queue<TreeNode<T>> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentTreeNode = queue.dequeue();
            if (currentTreeNode != null) {
                if (currentTreeNode.getLeft() != null && currentTreeNode.getLeft().getData().equals(data)) {
                    return new Result<>(currentTreeNode, currentTreeNode.getLeft());
                } else {
                    queue.enqueue(currentTreeNode.getLeft());
                }
                if (currentTreeNode.getRight() != null && currentTreeNode.getRight().getData().equals(data)) {
                    return new Result<>(currentTreeNode, currentTreeNode.getRight());
                } else {
                    queue.enqueue(currentTreeNode.getRight());
                }
            }
        }

        return null;
    }

    private Result<T> findLast() {
        TreeNode<T> currentNode = root;
        TreeNode<T> currentNodeParent = null;
        Queue<TreeNode<T>> queue = new Queue<>();
        queue.enqueue(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.dequeue();
            if (currentNode.getLeft() != null) {
                currentNodeParent = currentNode;
                queue.enqueue(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                currentNodeParent = currentNode;
                queue.enqueue(currentNode.getRight());
            }
        }
        return new Result<>(currentNodeParent, currentNode);
    }

    public boolean delete(T data) {
        Result<T> result = breadthFirstSearch(data);
        if (result == null) {
            return false;
        }
        TreeNode<T> parent = result.parent();
        TreeNode<T> targetNode = result.targetNode();
        if (parent == null) {
            root = null;
        } else {
            Result<T> lastNodeResult = findLast();
            TreeNode<T> lastNode = lastNodeResult.targetNode();
            TreeNode<T> lastNodeParent = lastNodeResult.parent();
            TreeNode<T> targetNodeLeft = targetNode.getLeft();
            TreeNode<T> targetNodeRight = targetNode.getRight();

            lastNode.setLeft(targetNodeLeft);
            lastNode.setRight(targetNodeRight);

            if (targetNode.equals(parent.getLeft())) {
                parent.setLeft(lastNode);
            } else {
                parent.setRight(lastNode);
            }

            if (lastNode.equals(lastNodeParent.getLeft())) {
                lastNodeParent.setLeft(null);
            } else {
                lastNodeParent.setRight(null);
            }
        }
        return true;
    }
}
