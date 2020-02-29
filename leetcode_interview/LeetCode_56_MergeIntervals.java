package leetcode_interview;

import java.util.*;

public class LeetCode_56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        //先排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return -1;
                } else if (a[0] > b[0]) {
                    return 1;
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });
        List<int[]> results = new ArrayList<>();
        //初始化结束位置
        int curbound = intervals[0][1];
        //初始化开始位置
        int curstart = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > curbound) {
                //开始大于结束
                //正常情况 添加结果
                results.add(new int[]{curstart, curbound});
                //更新开始和结束位置
                curstart = intervals[i][0];
                curbound = intervals[i][1];
            } else {
                //[1,3] [2,5]
                curbound = Math.max(curbound, intervals[i][1]);
            }
        }
        //添加最后一个元素
        results.add(new int[]{curstart, curbound});
        return results.toArray(new int[results.size()][2]);
    }
}
