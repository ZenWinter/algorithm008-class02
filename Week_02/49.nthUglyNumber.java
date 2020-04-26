class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        set.add(1L);
        heap.offer(1L);

        int[] factor = new int[] { 2, 3, 5 };

        int index = 1;
        while (true) {
            long e = heap.poll();

            // nth
            if (index == n) {
                return (int) e;
            } else {
                index++;
                for (int f : factor) {
                    if (!set.contains(e * (long) f)) {
                        set.add(e * (long) f);
                        heap.offer(e * (long) f);
                    }
                }

            }
        }

    }
}