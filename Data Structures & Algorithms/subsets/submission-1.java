class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(nums, 0, result, current);
        return result;
    }
    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
        if(index >= nums.length || current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        //can add current state to result as well as either skipping next, or taking next
        helper(nums, index + 1, result, current);
        current.add(nums[index]);
        helper(nums, index + 1, result, current);
        current.remove(current.get(current.size() - 1));
        
        
    }
}
