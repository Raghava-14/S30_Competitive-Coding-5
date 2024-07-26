//Time = O(n), number of nodes
//Space = O(W), Max width of tree

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        // Queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;

            // Process all nodes at the current level
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                // Update the maximum value for this level
                max = Math.max(max, node.val);

                // Add children to the queue
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                     queue.add(node.right);
                }
            }
            // Add the maximum value of the current level to the result list
            result.add(max);
        }
        return result;

    }
}