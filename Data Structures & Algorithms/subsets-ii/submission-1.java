class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //here, we cant have duplicate subsets, but we can have duplicate values
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, result, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int[] nums, List<List<Integer>> result, int index, List<Integer> current) {
        if(index <=nums.length) {
            result.add(new ArrayList<>(current));
        }

        for(int i = index; i < nums.length; i++) {
            //add current or skip
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            
            current.add(nums[i]);
            helper(nums, result, i + 1, current);
            current.remove(current.size() - 1);
        }
    }


}

// for this question, one approach i can think of is adding all of the combinations, then sorting then checking if the list is already in the hashset, if not, we can add to the result. if it is, we ignore it. that is ,my brute force approach

//we could potentially sort the nums array first, then skip using the same one on each recursive level
