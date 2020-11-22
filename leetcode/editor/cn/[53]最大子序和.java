//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2427 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int [] f = new int[len];
        f[0] = nums[0];
        int max = f[0];
        for(int i = 1; i < len; i++){
            if(f[i - 1] > 0){
                f[i] = f[i - 1] + nums[i];
            }else{
                f[i] = nums[i];
            }
            max = Math.max(max,f[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
