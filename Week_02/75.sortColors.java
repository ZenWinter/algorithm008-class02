class Solution {
    public void sortColors(int[] nums) {
        // brute force
        int[] counts = new int[] { 0, 0, 0 };
        for (int num : nums) {
            counts[num] += 1;
        }

        int[] factors = new int[] { 0, 1, 2 };
        int index = 0;
        for (int factor : factors) {
            int count = counts[factor];
            for (int j = index; j < index + count; j++) {
                nums[j] = factor;
            }
            index += count;
        }
    }
}