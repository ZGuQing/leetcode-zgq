//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 69 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return null;
        List<Integer> path = new ArrayList<>();//记录当前路径
        int currentSum = 0;//当前路径和
        return findPath(root,sum,path,currentSum);
    }

    public List<List<Integer>> findPath(TreeNode root,int sum,List<Integer> path,int currentSum){
        List<List<Integer>> ans = new ArrayList<>();//返回结果
        currentSum += root.val;
        path.add(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        //找到满足条件的路径
        if(currentSum == sum && isLeaf){
            ans.add(path);
        }
        if(root.left != null)
            findPath(root.left,sum,path,currentSum);
        if(root.right != null)
            findPath(root.right,sum,path,currentSum);
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
