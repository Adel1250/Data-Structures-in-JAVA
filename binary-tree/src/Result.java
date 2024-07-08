public record Result<T>(TreeNode<T> parent, TreeNode<T> targetNode) {

    @Override
    public String toString() {
        return "Result{" +
                "parent=" + parent +
                ", targetNode=" + targetNode +
                '}';
    }
}
