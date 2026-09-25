class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> dupe = new HashSet<>();
        for(int i : nums) {
            if(dupe.contains(i)) {
                return i;
            } else {
                dupe.add(i);
            }
        }
        return -1;
    }
}
