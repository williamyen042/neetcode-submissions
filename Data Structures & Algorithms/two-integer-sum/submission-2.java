class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2) {
            return new int[]{0, 1};
        }
        int[] result = new int[2];
        Map<Integer, Integer> uniques = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if(uniques.containsKey(find)) { 
                result[0] = uniques.get(find);
                result[1] = i;
                return result;
            } else {
                uniques.put(nums[i], i);
            }
        }
        return result;
    }
}
