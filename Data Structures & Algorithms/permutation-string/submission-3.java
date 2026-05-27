class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        } 
         int[] alpha1 = new int[26];
         int[] alpha2 = new int[26];
         int match = 0;
         for(int i = 0; i < s1.length(); i++) {
            alpha1[s1.charAt(i) - 'a']++;
            alpha2[s2.charAt(i) - 'a']++;
         }

         for(int i = 0; i < alpha1.length; i++) {
            if(alpha1[i] == alpha2[i]) {
                match++;
            }
         }
         if(match == 26) {
            return true;
         }
         int left = 0;
         int right = s1.length() - 1;
         while(right < s2.length()) {
            //so no index out of bounds
            if(right == s2.length() - 1) {
                break;
            }
            //slide window, update, and check
            right++;
            int rightIdx = s2.charAt(right) - 'a';
            //if matched before, it wont match anymore cuz we add another instance of it
            if(alpha1[rightIdx] == alpha2[rightIdx]) {
                match--;
            }
            alpha2[rightIdx]++;
            //check if same freq
            if(alpha1[rightIdx] == alpha2[rightIdx]) {
                match++;
            }


            int leftIdx = s2.charAt(left) - 'a';
            if(alpha1[leftIdx] == alpha2[leftIdx]) {
                match--;
            } 
            alpha2[leftIdx]--;
            if(alpha1[leftIdx] == alpha2[leftIdx]) {
                match++;
            } 
            left++;
//check if matched prev. if so, minus, if not, nothing
            if(match == 26) {
                return true;
            }
            

         }
         return false;
    }
    
}
