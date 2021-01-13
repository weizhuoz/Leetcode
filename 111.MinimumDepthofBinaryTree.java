111. Minimum Depth of Binary Tree
https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
// DFS Solution - Space O(1) Time O(n)
/* public int minDepth(TreeNode root) {
        if(root == null){return 0;}
        if(root.left == null){return minDepth(root.right) + 1;}
        if(root.right == null){return minDepth(root.left) + 1;}
        return Math.min(minDepth(root.right),minDepth(root.left)) + 1;
    }
*/
class Solution {
    // BFS Solution - Space O(n) Time O(logn)
    public int minDepth(TreeNode root) {
        if(root == null){return 0;}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}