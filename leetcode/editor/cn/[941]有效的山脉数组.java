//给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组： 
//
// 
// A.length >= 3 
// 在 0 < i < A.length - 1 条件下，存在 i 使得：
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 输入：[2,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：[3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
//
// 
//
// 
// Related Topics 数组 
// 👍 104 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validMountainArray(int[] A) {

        if (A.length < 3) return false;
        int i = 0;
        //寻找i位置
        for (int j = 0; j < A.length - 1; j++) {
            if (A[j] > A[j + 1]) {
                i = j;
                break;
            }
        }
        if (i == 0) return false;
        for (int k = i; k < A.length - 1; k++) {
            if (A[k] <= A[k + 1]) return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
