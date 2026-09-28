class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String s : strs) {
            int[] alpha = new int[26];
            for(int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i) - 'a']++;
            }
            if(anagrams.containsKey(Arrays.toString(alpha))) {
                anagrams.get(Arrays.toString(alpha)).add(s);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s);
                anagrams.put(Arrays.toString(alpha), temp);
            }

        }
        for(List<String> a: anagrams.values()) {
            result.add(a);
        }
        return result;
    }
}
