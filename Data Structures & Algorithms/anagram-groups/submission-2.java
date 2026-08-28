class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> freq = new HashMap<>();

        for(String s: strs) {
            int[] alpha = new int[26];
            for(int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(alpha);
            if(freq.containsKey(key)) {
                freq.get(key).add(s);
            } else {
                List<String> newS = new ArrayList<>();
                newS.add(s);
                freq.put(key, newS);
            }
        }
        for(List<String> a : freq.values()) {
            result.add(a);
        }  
        return result;
    }
}
