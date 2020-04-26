class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        PriorityQueue<NumWithCount> heap = new PriorityQueue<NumWithCount>(k, new Comparator<NumWithCount>() {
            @Override
            public int compare(NumWithCount n1, NumWithCount n2) {
                // 大根堆
                return n2.count - n1.count;
            }
        });

        // 已设置了size为k，不必在此处再poll()
        for (Integer key : map.keySet()) {
            NumWithCount n = new NumWithCount(key, map.get(key));
            heap.add(n);
        }

        for (int i = 0; i < k; i++) {
            NumWithCount n = heap.poll();
            res[i] = n.num;
        }

        return res;
    }

    private class NumWithCount {
        int num;
        int count;

        public NumWithCount(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}