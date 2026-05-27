/**
*
we are given a string s of size n
we are trying to find longest substring of non duplicates in size s
what should we do?
loop thru the string, starting with the first index

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        HashSet<Character> uniques = new HashSet<>();
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            while(uniques.contains(s.charAt(right))) {
                uniques.remove(s.charAt(left));
                left++;
            }
            //unique char, keep going
            uniques.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
