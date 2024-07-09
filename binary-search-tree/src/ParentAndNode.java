public record ParentAndNode<T extends Comparable<T>>(TreeNode<T> parent, TreeNode<T> targetNode, Boolean isLeft) {
}
