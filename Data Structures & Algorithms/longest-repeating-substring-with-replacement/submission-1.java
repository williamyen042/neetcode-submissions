class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] alpha = new int[26];
        int maxFreq = 0;
        int result = 0;
        while(right < s.length()) {
            //increment sliding window
            alpha[s.charAt(right) - 'A']++;
            maxFreq = Math.max(alpha[s.charAt(right) - 'A'], maxFreq);
            while((right - left + 1) - maxFreq > k) {
                alpha[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
//window length - maxFreq in window <= k for valid 
