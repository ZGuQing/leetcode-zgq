//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3189 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        if(len % 2 == 1){
            int mid = len / 2;
            return getKth(nums1, nums2, mid + 1);
        }else{
            int mid1 = len / 2 - 1, mid2 = len / 2;
            return (getKth(nums1, nums2, mid1 + 1) + getKth(nums1, nums2, mid2 + 1)) / 2.0;
        }
    }

    public int getKth(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElem = 0;

        while(true){
            //边界
            if(index1 == len1){
                return nums2[index2 + k - 1];
            }
            if(index2 == len2){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;//防止越界，直接取最后一个元素
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
