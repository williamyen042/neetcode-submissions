/*cannot sort 0nlogn
add add elements to a hashset, then after, do a loop on nums, if element has a num
that -1 is in the hashset, means its not a start of sequence, skip

*/

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int num : nums) {
            numbers.add(num);
        }
        int max = 0;
        for(int i = 0 ; i < nums.length && max <= nums.length - i; i++) {
            int curr = nums[i];
            int temp = 1;
            if(numbers.contains(curr) && !numbers.contains(curr - 1)) { //start of sequence
                
                curr++;
                while(numbers.contains(curr)) {
                    curr++;
                    temp++;
                }
            }
            max = Math.max(max, temp);
        }

        return max;
    }
}
