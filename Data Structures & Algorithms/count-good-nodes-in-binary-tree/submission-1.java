/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        Queue<Integer> maxQueue = new LinkedList<>();

        if(root==null){
            return 0;
        }

        queue.offer(root);
        maxQueue.offer(root.val);

        int count=0;

        while (!queue.isEmpty()) {
            TreeNode node= queue.poll();

            int max= maxQueue.poll();


            if(node.val >= max){
                count++;
            }

            int newMax= Math.max(max,node.val);

            if(node.left !=null){
                queue.offer(node.left);
                maxQueue.offer(newMax);
            }

            if(node.right !=null){
                queue.offer(node.right);
                maxQueue.offer(newMax);
            }


        }

        return count;
    }
}
