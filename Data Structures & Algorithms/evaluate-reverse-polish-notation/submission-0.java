class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens) {
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                int result = Integer.parseInt(s);
                st.push(result);
            } else {
                //do math, push back onto stack
                int n1 = st.pop();
                int n2 = st.pop();
                //math ->
                if(s.equals("+")) {
                    st.push(n2 + n1);
                } else if(s.equals("-")) {
                    st.push(n2 - n1);
                } else if(s.equals("*")) {
                    st.push(n2 * n1);
                } else {
                    // / 
                    st.push(n2 / n1);
                }

                //push back onto stack
            }
        }
        return st.pop();
    }
}

//numbers, add to the stack, then when we hit an operand, we pop the most recent two numbers, then do the math, then