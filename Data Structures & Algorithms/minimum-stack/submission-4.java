class MinStack {
    Stack<Integer> stack, minStack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (val < min) {
            minStack.push(val);
            min = val;
        } else {
            minStack.push(min);
        }
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        if (!minStack.isEmpty()) min = minStack.peek();
        else min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
