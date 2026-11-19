class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = Arrays.stream(stones)
                .boxed()
                .collect(
                    Collectors.toCollection(() -> new PriorityQueue<>(Collections.reverseOrder())));
        while (pq.size() > 1) {
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();
            int s = tmp1 - tmp2;
            if (s > 0) pq.offer(s);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
