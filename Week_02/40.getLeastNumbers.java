class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];

        // sort
        // Arrays.sort(arr);
        // for (int i = 0; i < k; i++) {
        // res[i] = arr[i];
        // }

        // heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }
}