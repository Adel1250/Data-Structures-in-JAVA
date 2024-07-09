public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data) {
        TreeNode<T> newTreeNode = new TreeNode<>(data);
        if (root == null) {
            root = newTreeNode;
            return;
        }
        TreeNode<T> currentNode = root;
        while (currentNode != null) {
            if (data.compareTo(currentNode.getData()) < 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newTreeNode);
                    break;
                } else {
                    currentNode = currentNode.getLeft();
                }
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newTreeNode);
                    break;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    public TreeNode<T> find(T data) {
        TreeNode<T> currentNode = root;
        while (currentNode != null) {
            if (data.equals(currentNode.getData())) {
                return currentNode;
            } else if (data.compareTo(currentNode.getData()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    public boolean exists(T data) {
        return find(data) != null;
    }

    public ParentAndNode<T> findParentAndTargetNode(T data) {
        TreeNode<T> currentNode = root;
        TreeNode<T> parent = null;
        Boolean isLeft = null;

        while (currentNode != null) {
            if (data.equals(currentNode.getData())) {
                return new ParentAndNode<>(parent, currentNode, isLeft);
            } else if (data.compareTo(currentNode.getData()) < 0) {
                parent = currentNode;
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else {
                parent = currentNode;
                isLeft = false;
                currentNode = currentNode.getRight();
            }
        }
        return null;
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

    private ParentAndNode<T> findMinNodeInRightSubTree(TreeNode<T> parent, TreeNode<T> treeNode) {
        TreeNode<T> currentNode = treeNode;
        while (currentNode.getLeft() != null) {
            parent = currentNode;
            currentNode = currentNode.getLeft();
        }
        return new ParentAndNode<>(parent, currentNode, true);
    }

    public boolean delete(T data) {
        ParentAndNode<T> parentAndNode = findParentAndTargetNode(data);
        TreeNode<T> targetNode = parentAndNode.targetNode();
        if (targetNode != null) {
            if (targetNode.getLeft() != null && targetNode.getRight() != null) {
                deleteNodeWithTwoChildren(targetNode);
            } else if (targetNode.getLeft() != null ^ targetNode.getRight() != null) {
                deleteNodeWithOneChild(targetNode);
            } else {
                deleteLeafNode(parentAndNode);
            }
            return true;
        }
        return false;
    }

    private void deleteNodeWithTwoChildren(TreeNode<T> targetNode) {
        ParentAndNode<T> minNodeInRightSubTree = findMinNodeInRightSubTree(targetNode, targetNode.getRight());
        TreeNode<T> minNode = minNodeInRightSubTree.targetNode();
        TreeNode<T> minParentNode = minNodeInRightSubTree.parent();
        targetNode.setData(minNode.getData());
        if (minParentNode.equals(targetNode)) {
            targetNode.setRight(minNode.getRight());
        } else {
            minParentNode.setLeft(minNode.getRight());
        }
    }

    private void deleteNodeWithOneChild(TreeNode<T> targetNode) {
        TreeNode<T> nodeToReplace;
        if (targetNode.getLeft() != null) {
            nodeToReplace = targetNode.getLeft();
        } else {
            nodeToReplace = targetNode.getRight();
        }
        targetNode.setLeft(nodeToReplace.getLeft());
        targetNode.setRight(nodeToReplace.getRight());
        targetNode.setData(nodeToReplace.getData());
    }

    private void deleteLeafNode(ParentAndNode<T> parentAndNode) {
        TreeNode<T> parent = parentAndNode.parent();
        if (parentAndNode.isLeft()) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }
}
