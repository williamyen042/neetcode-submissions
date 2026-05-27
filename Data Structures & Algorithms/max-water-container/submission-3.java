class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while(left < right && left < heights.length && right < heights.length) {
            int temp = Math.min(heights[left], heights[right]);
            temp = temp * (right - left); //area
            max = Math.max(max, temp);
            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
//sliding window
// left and right pointer. you need to get the minimum height of the two pointers,
// then multiply that by the distance of the pointers
// have left start at i = 0; right start i = heights.length - 1. get current, 
// compare w/ max, then save, compare the heigh of the left and right, then increment
