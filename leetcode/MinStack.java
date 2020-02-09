package leetcode;


import java.util.Stack;

class Node {
    int val;
    int min;

    Node(int value, int min_val) {
        val = value;
        min = min_val;
    }
}


//public class MinStack {
//    Stack st = new Stack();
//
//    public void push(int x) {
//        if (st.isEmpty()) {
//            Node n = new Node(x, x);
//            st.push(n);
//        } else {
//            Node n = st.peek();
//            if (n.min < x) {
//                Node n1 = new Node(x, n.min);
//                st.push(n1);
//            } else {
//                Node n1 = new Node(x, x);
//                st.push(n1);
//            }
//        }
//    }
//
//    public void pop() {
//        st.pop();
//    }
//
//    public int top() {
//
//        Node n = st.peek();
//        return n.val;
//    }
//
//    public int getMin() {
//
//        Node n = st.peek();
//        return n.min;
//    }
//
//
//}
