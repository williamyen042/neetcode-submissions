class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combo(result, nums, target, 0, new ArrayList<>(), 0);
        return result;
    }

    private void combo(List<List<Integer>> result, int[] nums, int target, int sum, List<Integer> current, int index) {
        if(sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        //can take current one again, or try others. cant use for loop because of potential duplicates
        while(index < nums.length) {
            if(sum + nums[index] <= target) {
                current.add(nums[index]);
                combo(result, nums, target, sum + nums[index], current, index);
                current.remove(current.size() - 1);
            }
            index++;
        }
        
        return;
        
    }
}
