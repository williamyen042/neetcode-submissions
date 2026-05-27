class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> unique = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            //get the first number, then do a two sum? target would be 0 , so 0 - 1st
            int target = 0 - nums[i];
            Map<Integer, Integer> hash = new HashMap<>();
            for(int j = i + 1; j < nums.length; j++) {
                int find = target - nums[j];
                if(hash.containsKey(find)) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[j]);
                    sol.add(find);
                    unique.add(sol);
                } else {
                    //not found yet
                    hash.put(nums[j], j);
                }
            }
        }
        for(List<Integer> answer : unique) {
            result.add(answer);
        }
        return result;
    }
}
