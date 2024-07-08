public class Result<T> {
    private final TreeNode<T> parent;
    private final TreeNode<T> targetNode;

    public Result(TreeNode<T> parent, TreeNode<T> targetNode) {
        this.parent = parent;
        this.targetNode = targetNode;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public TreeNode<T> getTargetNode() {
        return targetNode;
    }

    @Override
    public String toString() {
        return "BreadthFirstSearchResult{" +
                "parent=" + parent +
                ", targetNode=" + targetNode +
                '}';
    }
}
