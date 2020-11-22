//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 堆 排序 分治算法 
// 👍 183 👎 0


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Random rand = new Random();
    public int[][] kClosest(int[][] points, int K) {
        //排序，重写Comparator
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] point1, int[] point2) {
//                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
//            }
//        });
//        return Arrays.copyOfRange(points, 0, K);
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void random_select(int[][] points, int left, int right, int k) {
//        int pivotId = left + rand.nextInt(right - left + 1);
//        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
//        swap(points, right, pivotId);
//        int i = left - 1;
//        for (int j = left; j < right; ++j) {
//            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
//            if (dist <= pivot) {
//                ++i;
//                swap(points, i, j);
//            }
//        }
//        ++i;
//        swap(points, i, right);
//        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
//        if (K < i - left + 1) {
//            random_select(points, left, i - 1, K);
//        } else if (K > i - left + 1) {
//            random_select(points, i + 1, right, K - (i - left + 1));
//        }
        if(left == right) return;
        int x = left;//基准
        int i = left - 1, j = right + 1;
        int dist1 = 0, dist2 = 0;

        while(i < j){
            do{
                dist1 = distance(points,++i);
            }while (dist1 < distance(points,x));
            do{
                dist2 = distance(points, --j);
            }while (dist2 > distance(points,x));
            if(i < j) swap(points, i, j);
        }
        int sl = j - i + 1;
        if(k <= sl) random_select(points, left, j, k);
        else random_select(points, j + 1, right, k);
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }

    public int distance(int [][]points, int i){
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
