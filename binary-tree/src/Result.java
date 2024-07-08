public record Result<T>(TreeNode<T> parent, TreeNode<T> targetNode) {

    @Override
    public String toString() {
        return "BreadthFirstSearchResult{" +
                "parent=" + parent +
                ", targetNode=" + targetNode +
                '}';
    }
}
