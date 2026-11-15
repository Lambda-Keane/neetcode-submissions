class KthLargest {
    int k;
    int kthE;
    PriorityQueue<Integer> pq;
    PriorityQueue<Integer> tmp;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toCollection(() -> new PriorityQueue<Integer>(Comparator.reverseOrder())));
        this.tmp = new PriorityQueue<>();
        upperKthEInit();
    }
    
    public int add(int val) {
        if (k == 1) {
            pq.add(val);
            kthE = pq.peek();
        } else if (tmpIsFull()) {
            if (val > kthE){
                tmp.add(val);
                pq.add(tmp.poll());
            } else {
                pq.add(val);
            }
            kthE = pq.peek();
        } else {
            tmp.offer(val);
            kthE = tmp.peek();
        }
        return kthE;
    }

    private boolean tmpIsFull() {
        return tmp.size() == k - 1;
    }

    private void upperKthEInit() {
        int t = k;
        while (t > 1) {
            tmp.add(pq.poll());
            t--;
        }
        if (!pq.isEmpty()) kthE = pq.peek();
        else if (!tmp.isEmpty()) kthE = tmp.peek();
        else return;
    }
}
