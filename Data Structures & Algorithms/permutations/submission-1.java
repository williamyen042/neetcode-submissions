class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> hash = new HashSet<>();
        helper(nums, result, new ArrayList<>(), hash);
        return result;
    }

    //only add to result if current list == nums.length
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> current, Set<Integer> hash)  { 
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        //recursive cases, for loop, check if unique, if so, add and recurse (then backtrack)
        for(int i = 0; i < nums.length; i++) {
            if(!hash.contains(nums[i])) {
                hash.add(nums[i]);
                current.add(nums[i]);
                helper(nums, result, current, hash);
                hash.remove(nums[i]);
                current.remove(current.size() - 1);
            }
        }
        return;
    }
}
