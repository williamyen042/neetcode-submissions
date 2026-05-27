class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> elem = new HashMap<>();
        for(int number : nums) {
            if(elem.containsKey(number)) {
                int temp = elem.get(number);
                elem.put(number, temp + 1);
            } else {
                elem.put(number, 1);
            }
        }
        //bucket sort?
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int vals : elem.keySet()){
            if(bucket[elem.get(vals)] == null) {
                bucket[elem.get(vals)] = new ArrayList<Integer>();
            }
            bucket[elem.get(vals)].add(vals);
        }
        int index = 0;
        for(int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if(bucket[i] != null) {
                for(int number : bucket[i]) {
                    if(index < k) {
                        result[index] = number;
                        index++;
                    } else {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
