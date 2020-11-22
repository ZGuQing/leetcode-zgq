//给定一个正整数 N，找到并返回 N 的二进制表示中两个相邻 1 之间的最长距离。 
//
// 如果没有两个相邻的 1，返回 0 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：22
//输出：2
//解释：
//22 的二进制是 0b10110 。
//在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
//第一对相邻的 1 中，两个 1 之间的距离为 2 。
//第二对相邻的 1 中，两个 1 之间的距离为 1 。
//答案取两个距离之中最大的，也就是 2 。
// 
//
// 示例 2： 
//
// 输入：5
//输出：2
//解释：
//5 的二进制是 0b101 。
// 
//
// 示例 3： 
//
// 输入：6
//输出：1
//解释：
//6 的二进制是 0b110 。
// 
//
// 示例 4： 
//
// 输入：8
//输出：0
//解释：
//8 的二进制是 0b1000 。
//在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 
// Related Topics 数学 
// 👍 52 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        //1。在数组A中记录N二进制中表示的位置
        for(int i = 0;i < 32;i++){
            if(((N >> i) & 1) != 0){
                A[t++] = i;
            }
        }

        //2。找到相邻1的最大值，就是找到数组相邻元素的最大值
        int ans = 0;
        for(int i = 1;i < 32;i++){
            ans = Math.max(ans,A[i] - A[i - 1]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
