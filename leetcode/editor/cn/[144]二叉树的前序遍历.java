//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 419 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        preorder(root,list);
//        return list;
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root != null)  s.push(root);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            list.add(cur.val);
            if(cur.right != null) s.push(cur.right);
            if(cur.left != null) s.push(cur.left);
        }
        return list;

    }
//    public void preorder(TreeNode root, List<Integer> list){
//        if(root == null) return;
//        list.add(root.val);
//        preorder(root.left,list);
//        preorder(root.right,list);
//    }

}

//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
