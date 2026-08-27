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
    public int diameterOfBinaryTree(TreeNode root) {

    int diameter=0;

    Map<TreeNode,Integer> map= new HashMap<>();

    Stack<TreeNode> stack = new Stack<>();

    if(root !=null){
        stack.push(root);
    }

    while(!stack.isEmpty()){
        TreeNode node= stack.peek();



        if(node.left !=null && !map.containsKey(node.left)){
            stack.push(node.left);
        }else if(node.right!=null && !map.containsKey(node.right)){
            stack.push(node.right);
        }else{

            stack.pop();
            int left_depth=map.getOrDefault(node.left,0);
            int right_depth=map.getOrDefault(node.right,0);

            map.put(node, 1+ Math.max(left_depth,right_depth));


            diameter=Math.max(diameter, left_depth + right_depth);

        }
    }





       return diameter;
        
    }
}
