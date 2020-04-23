class MyCircularQueue {
    private int count;
    private int cap;
    private int[] data;
    private int head;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.count = 0;
        this.head = 0;
        this.data = new int[k];
        this.cap = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        this.data[(this.head + this.count) % this.cap] = value;
        this.count++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        this.head = (this.head + 1) % this.cap;
        this.count--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        int tail = (this.head + this.count - 1) % this.cap;
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */