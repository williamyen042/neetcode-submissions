class Solution {
    public boolean hasDuplicate(int[] nums) {
        //hashset
        Set<Integer> unique = new HashSet<Integer>();
        for(int num : nums) {
            if(unique.contains(num)) {
                //early return
                return true;
            } else {
                //add it to the set
                unique.add(num);
            }
        }
        //means that no dupes
        return false;
    }
}