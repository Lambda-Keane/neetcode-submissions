class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            int c;
            if (s.length() > 1) {
                c = Integer.parseInt(s);
                stack.push(c);
                continue;
            } else {
                    c = s.charAt(0);
                    if (c >= '0' && c <= '9') {
                    stack.push(c-'0');
                    continue;
                }
            }

            switch (c) {
                case '+' -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num1 + num2);
                }
                case '-' -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                case '*' -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num1 * num2);
                }
                case '/' -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }
}
