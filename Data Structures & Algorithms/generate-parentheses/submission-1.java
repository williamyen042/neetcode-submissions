class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        helper(n, n, 0, result, sb);
        return result;
    }

    private void helper(int n, int open, int close, List<String> result, StringBuilder sb) {
        if(close == n && open == 0) {
            result.add(sb.toString());
            return;
        }
        //recurrance case
        if(close < n - open) {
            sb.append(")");
            helper(n, open, close + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        } //open > close
        if(open > 0) {
            sb.append("(");
            helper(n, open - 1, close, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }      
    }
}
