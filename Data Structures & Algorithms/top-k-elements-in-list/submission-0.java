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
        for(int i = 0; i < k; i++) {
            int max = 0;
            int temp = 0;
            for(int number : elem.keySet()) {
                if(elem.get(number) >= max) {
                    max = elem.get(number);
                    temp = number;
                }
            }
            result[i] = temp;
            elem.remove(temp);
        }

        return result;
    }
}
