class Solution {
    public int maxArea(int[] height) {
        int max_res = 0;

        // double pointer
        int i = 0, j = height.length - 1;
        while (i < j) {
            int res = (j - i) * Math.min(height[i], height[j]);
            if (res > max_res) {
                max_res = res;
            }
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max_res;
    }
}