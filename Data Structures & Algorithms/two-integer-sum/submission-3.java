class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> area = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(area.containsKey(target - nums[i])) {
                int min = Math.min(area.get(target - nums[i]), i);
                int max = Math.max(area.get(target - nums[i]), i);
                return new int[] {min, max};
            } else {
                if(!area.containsKey(nums[i])) {
                    area.put(nums[i], i);
                }
            }
        }
        return null;
    }
}
