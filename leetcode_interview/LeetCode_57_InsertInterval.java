package leetcode_interview;

import java.util.Arrays;

public class LeetCode_57_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null ||
                intervals.length == 0 ||
                intervals[0] == null ||
                intervals[0].length == 0)
            return new int[][]{newInterval};
        int index = 0;
        int[][] res = new int[intervals.length + 1][2];//加入新的interval
        int size = 0;

        //增加newintervals 结束段在开始端之前
        //[2,3]  [4,7]
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            res[size++] = Arrays.copyOf(intervals[index++], 2);
        }
        //Merge clashing intervals with new intervals.
        // Continue till there are no more overlaps
        //将碰撞间隔与新间隔合并。继续，直到不再有重叠
        //[2,5]  [3,4]
        while (index < intervals.length && newInterval[1] >= intervals[index][0]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }

        //添加合并的interval
        res[size++] = Arrays.copyOf(newInterval, 2);
        //添加没有合并的间隔
        while (index < intervals.length) {
            res[size++] = Arrays.copyOf(intervals[index++], 2);
        }

        return Arrays.copyOf(res, size);


    }


}
