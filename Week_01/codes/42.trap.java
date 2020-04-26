class Solution {
    public int trap(int[] height) {
        int res = 0;

        // brute force
        for (int i = 0; i < height.length; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                // Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                // Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            res += Math.min(max_left, max_right) - height[i];
        }

        return res;
    }
}