class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(answer, nums, current, 0);
        return answer;
    }
    private void helper(List<List<Integer>> answer, int[] nums, List<Integer> current, int index) {
        //base case
        if(index == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        //recurse, add or skip
    
        //skip
        helper(answer, nums, current, index + 1);
        //add
        current.add(nums[index]);
        helper(answer, nums, current, index + 1);
        current.remove(current.size() - 1);
        return;
    }
}

//nums : [1,2,3]
// have hashmap 

// we can
// pick
// or skip
// so

// in helper method, have base case where if there is a dupe (same subset), or current list
// is greater than nums.length

// recurring case would be two calls: to skip or pick