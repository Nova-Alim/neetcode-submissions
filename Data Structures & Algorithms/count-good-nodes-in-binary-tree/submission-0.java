class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> maxQueue = new LinkedList<>();

        queue.add(root);
        maxQueue.add(root.val);

        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int max = maxQueue.poll();

            if (node.val >= max) {
                count++;
            }

            int newMax = Math.max(max, node.val);

            if (node.left != null) {
                queue.add(node.left);
                maxQueue.add(newMax);
            }

            if (node.right != null) {
                queue.add(node.right);
                maxQueue.add(newMax);
            }
        }

        return count;
    }
}