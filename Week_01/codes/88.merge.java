class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, index = 0;
        int[] res = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[index] = nums1[i];
                i++;
                index++;
            } else {
                res[index] = nums2[j];
                j++;
                index++;
            }
        }

        while (index < res.length) {
            if (i < m) {
                res[index] = nums1[i];
                i++;
            }
            if (j < n) {
                res[index] = nums2[j];
                j++;
            }
            index++;
        }

        System.arraycopy(res, 0, nums1, 0, res.length);
    }
}