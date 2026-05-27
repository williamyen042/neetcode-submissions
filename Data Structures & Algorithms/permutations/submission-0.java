class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        if(nums.length == 1) {
            currentList.add(nums[0]);
            result.add(currentList);
            return result;
        }
        
        Set<Integer> uniques = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            //call method n times ig
            currentList.add(nums[i]);
            uniques.add(nums[i]);
            permHelper(nums, currentList, result, uniques);
            uniques.remove(nums[i]);
            currentList.remove(currentList.size() - 1);
        }
        return result;
    }
    private void permHelper(int[] nums, List<Integer> currentList, List<List<Integer>> result, Set<Integer> uniques) {
        //base case
        if(currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i : nums) {
            if(!uniques.contains(i)) {
                currentList.add(i);
                uniques.add(i);
                permHelper(nums, currentList, result, uniques);
                uniques.remove(i);
                currentList.remove(currentList.size() - 1);
            }
        }
        return;
        
    }

}