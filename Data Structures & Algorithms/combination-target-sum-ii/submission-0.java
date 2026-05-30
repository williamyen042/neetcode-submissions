class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        onlyCombo(candidates, target, current, result, 0);
        return result;
    }

    private void onlyCombo(int[] candidates, int remaining, List<Integer> current, List<List<Integer>> result, int index) {
        if(remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(index == candidates.length || remaining < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if(candidates[i] > remaining) {
                break;
            }
        current.add(candidates[i]);
        onlyCombo(candidates, remaining - candidates[i], current, result, i + 1);
        current.remove(current.size() - 1);
        }
        //recurring case - take

        
        return;
    }
}
