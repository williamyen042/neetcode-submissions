/*
do a 2 pointer solution
*/

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        String lower = s.toLowerCase();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        for(int i = 0; i < s.length(); i++) {
            if(alphabet.indexOf(lower.charAt(i)) != -1|| numbers.indexOf(lower.charAt(i)) != -1) {
                sb.append(lower.charAt(i));
            }
        }
        
        int left = 0;
        int right = sb.length() - 1;
        while(left <= right) {
            if(sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
