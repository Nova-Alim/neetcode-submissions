class Solution {

    class NodeInfo {
        TreeNode node;
        long min;
        long max;

        NodeInfo(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<NodeInfo> queue = new LinkedList<>();

        queue.offer(new NodeInfo(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!queue.isEmpty()) {

            NodeInfo info = queue.poll();

            TreeNode current = info.node;
            long min = info.min;
            long max = info.max;

            if (current.val <= min || current.val >= max) {
                return false;
            }

            if (current.left != null) {
                queue.offer(new NodeInfo(current.left, min, current.val));
            }

            if (current.right != null) {
                queue.offer(new NodeInfo(current.right, current.val, max));
            }
        }

        return true;
    }
}