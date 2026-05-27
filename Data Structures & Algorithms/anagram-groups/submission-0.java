class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //beat out edge cases
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs.length == 0) {
            return result;
        }
        HashMap<String, List<String>> anagram = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            int[] alpha = new int[26];
            for(int j = 0; j < strs[i].length(); j++) {
                alpha[strs[i].charAt(j) - 'a']++;
            } 
            String key = Arrays.toString(alpha);
            if(anagram.containsKey(key)) {
                anagram.get(key).add(strs[i]);
            } else {
                List<String> newAn = new ArrayList<>();
                newAn.add(strs[i]);
                anagram.put(key, newAn);
            }
        }
        for(List<String> values : anagram.values()) {
            result.add(values);
        }
        return result;
    }

}
