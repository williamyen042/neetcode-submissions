class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, result, "", new Stack<>());
        return result;
    }

    private void helper(int remaining, List<String> result, String curr, Stack<Character> p) {
        if(p.isEmpty() && remaining == 0) {
            result.add(curr);
            return;
        }

        //recusive -  can either add parenthesis to stack, or close a parentheses
        if(p.isEmpty()) {
            //we closed, so we can open
            curr += '(';
            p.push('(');
            helper(remaining - 1, result, curr, p);
            p.pop();

        } else {
            if(remaining == 0) {
                curr += ')';
                p.pop();
                helper(remaining, result, curr, p);
                p.push('(');
            } else {
                //can either open or close
                char c = p.peek();
            
                curr += ')';
                p.pop();
                helper(remaining, result, curr, p);
                p.push('(');
                curr = curr.substring(0, curr.length() - 1);
            
                curr += '(';
                p.push('(');
                helper(remaining - 1, result, curr, p);
                p.pop();
                
            }
            
            
        }
        //close a parenthesis
        
        

    }
}
//we can have remaining parenthesis to make, if we choose to use the ')', we need to make sure that 1: our remaining is greater than 0; 2: our current stack has an open parentheses
