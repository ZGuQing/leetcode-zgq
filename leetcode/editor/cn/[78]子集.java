//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 786 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for(int mask = 0;mask < (1 << n);++mask){
            list.clear();
            for(int i = 0;i < n;i++){
                if((mask & (1 << i)) != 0){
                    list.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(list));
        }

        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
