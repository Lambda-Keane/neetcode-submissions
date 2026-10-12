class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i < temperatures.length; i++) {
            stack.push(i-1);
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (temperatures[i] > temperatures[j]) {
                    result[j] = i - j; 
                    stack.pop();
                } else break;
            }
        }
        return result;
    }
}
