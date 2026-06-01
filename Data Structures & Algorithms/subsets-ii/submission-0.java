class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(current));
        subsetHelper(nums, current, result, 0);
        return result;
    }
    private void subsetHelper(int[] nums, List<Integer> current, List<List<Integer>> result, int index) {
        //base case

        

        //recurrance, make sure to skip dupes

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i - 1] == nums[i]) {
                continue;
            }
            current.add(nums[i]);
            subsetHelper(nums, current, result, i + 1);
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            
        }
        return;
    }
}
