import java.util.Stack;

class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        mainStack.push(value);

        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            int current = minStack.peek();
            minStack.push(Math.min(value, current));
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}