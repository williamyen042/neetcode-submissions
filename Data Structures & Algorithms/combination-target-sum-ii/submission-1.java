class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combo2(candidates, target, result, current, 0, 0);
        return result;
        
    }
    private void combo2(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int sum, int index) {
        if(sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(index == candidates.length || sum > target) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(candidates[i] + sum > target) {
                break;
            }
            current.add(candidates[i]);
            combo2(candidates, target, result, current, sum + candidates[i], i + 1);
            current.remove(current.size() - 1);
        }
        return;
    }
}
