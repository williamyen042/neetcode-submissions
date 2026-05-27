class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        updateList(nums, 0, target, currentList, result, 0);
        return result;
    }
    private void updateList(int[] nums, int current, int target, List<Integer> currentList, List<List<Integer>> result, int index) {
        if(current == target) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        //recurring case
        while(index < nums.length){
            if(current + nums[index] <= target) {
                currentList.add(nums[index]);
                updateList(nums, current + nums[index], target, currentList, result, index);
                currentList.remove(currentList.size() - 1);
            }
            index++;
        }

        return;
    }
}
//we want to return all possible combinations of nums that add to a number.
//base case - if current number == target, we can add to list
//recuring case, add all elements of nums and check if its less than target, then valid, if not, will return accordingly
