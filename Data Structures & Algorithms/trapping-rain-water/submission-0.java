class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int curLeftMax = height[left];
        int curRightMax = height[right];
        while(left < right) {
            //increment left pointer

            if(height[left] <= height[right]) {
                if(height[left + 1] >= curLeftMax) {
                    curLeftMax = height[left + 1];
                    
                } else {
                    water += (curLeftMax - height[left + 1]);
                }
                left++;
            } else {
                if(height[right - 1] >= curRightMax) {
                    curRightMax = height[right - 1];
                } else {
                    water += (curRightMax - height[right - 1]);
                }
                right--;
            }
        }
        return water;
    }
}
