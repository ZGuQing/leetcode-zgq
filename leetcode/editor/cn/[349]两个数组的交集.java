//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 266 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //1.排序+双指针
//        int len1 = nums1.length, len2 = nums2.length;
//        int[] nums = new int[len1 + len2];
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int i = 0, j = 0, k = 0;
//        while (i < len1 && j < len2) {
//            int num1 = nums1[i], num2 = nums2[j];
//            if (nums1[i] < nums2[j]) i++;
//            else if (nums1[i] > nums2[j]) j++;
//            else{
//                if(k == 0 || num1 != nums[k - 1]) nums[k++] = num1;
//                i++;j++;
//            }
//        }
//        return Arrays.copyOfRange(nums,0, k);//去掉末尾0
        //2.双集合法
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for(int num : nums1) set1.add(num);

        for(int num : nums2) set2.add(num);

        return getIntersection(set1,set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2){
        if(set1.size() > set2.size()) return getIntersection(set2,set1);
        Set<Integer> intersectionSet = new HashSet<>();
        for(int num : set1){
            if(set2.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;//set转数组
        for(int num : intersectionSet) intersection[index++] = num;
        return intersection;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
