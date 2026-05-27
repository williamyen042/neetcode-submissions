class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0; 
        int p2 = 1;
        while(p1 < p2 && p1 < numbers.length) {
            if(p2 >= numbers.length) {
                p1++;
                p2 = p1 + 1;
            }
            if(numbers[p1] + numbers[p2] == target) {
                return new int[]{p1 + 1, p2 + 1};
            } else if (numbers[p1] + numbers[p2] > target) {
                p1++;
                p2 = p1 + 1;
            } else {
                p2++;
            }
        }
        return null;
    }
}
