/*
*  Design an algorithm to encode a list of strings to a single string. 
The encoded string is then decoded back to the original list of strings.
we take in a list of strings, append it to one big string in encode, then return
take in the large string and split it back up
we need to keep track of the indexes, how do we do that?
my idea is to get an array of list size - 1, because we only need words - 1 indexes
we have an index, increment by word length, then once word is done, add into array
*/

class Solution {
    private int[] indexes;
    public String encode(List<String> strs) {
        if(strs.size() == 0) {
            return null;
        }
        int index = 0;
        indexes = new int[strs.size() - 1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size() - 1; i++) {
            index += strs.get(i).length();
            sb.append(strs.get(i));
            indexes[i] = index;
        }
        sb.append(strs.get(strs.size() - 1)); //get last element
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        //edge case
        if(str == null) {
            return result;
        } else if (str.equals("")) {
            result.add("");
            return result;
        }
        
        int index = 0;
        for(int i = 0; i < indexes.length; i++) {
            result.add(str.substring(index, indexes[i]));
            index = indexes[i];
        }
        result.add(str.substring(index));
        return result;
    }
}
