class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;

        // brute force
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0) {
                continue;
            }
            int minHeight = Integer.MAX_VALUE;
            ;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                max = Math.max(max, (j - i + 1) * minHeight);
            }
        }

        return max;
    }
}