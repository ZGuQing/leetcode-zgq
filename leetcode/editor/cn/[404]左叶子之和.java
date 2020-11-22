//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 230 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        return sumOfLeft(root,sum);
    }
    public int sumOfLeft(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        if(root.left != null){
            sum += root.left.val;
            sumOfLeft(root.left,sum);
        }
        if(root.right != null){
            sumOfLeft(root.right,sum);
        }
        return sum;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
