//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
// 输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
// 输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 159 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] A) {
//        for(int i = 0;i < A.length;i++){
//            A[i] = A[i] * A[i];
//        }
//        Arrays.sort(A);
//        return A;

        //双指针法
        int n = A.length;
        int neg = -1;
        for(int i = 0;i < n;i++){
            if(A[i] < 0){
                neg = i;
            }else {
                break;
            }
        }
        int[] ans = new int[n];
        int i = neg;
        int j = neg + 1;
        int index = 0;
        while(i >= 0 || j < n){
            if(i < 0){//全是正数
                ans[index] = A[j] * A[j];
                ++j;
            }else if(j == n){//全是负数
                ans[index] = A[i] * A[i];
                --i;
            }else if(A[i] * A[i] < A[j] * A[j]){
                ans[index] = A[i] * A[i];
                --i;
            }else{
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
