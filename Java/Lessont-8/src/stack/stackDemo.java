package stack;

import java.util.Stack;

public class stackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //Them phan tu vao stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("stack.size() = " + stack.size());

        // xem phan tu o dinh stack
        int peek = stack.peek();
        System.out.println("peek = " + peek);
        // lay phan tu o dinh stack
        int pop = stack.pop();
        System.out.println("pop = " + pop);
        System.out.println("stack.size() = " + stack.size());
        // lặp từng phần tử trong stack
        while (!stack.empty()){
            int top = stack.pop();
            System.out.println("top = " + top);
        }
    }
}
