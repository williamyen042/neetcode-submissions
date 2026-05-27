class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //hashmap of String, list of strings
        Map<String, List<String>> hash = new HashMap<>();
        //have array of alphabet?
        List<List<String>> result = new ArrayList<>();
        for(String s : strs) {
            int[] alphabet = new int[26];
            for(int i = 0; i < s.length(); i++) {
                alphabet[s.charAt(i) - 'a']++;
            }
            String alphabetToS = Arrays.toString(alphabet);
            if(hash.containsKey(alphabetToS)) {
                hash.get(alphabetToS).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                hash.put(alphabetToS, newList);
            }
        }
        for(List<String> s : hash.values()) {
            result.add(s);
        }
        return result;
    }
}
