

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        if(nums.length == 1) {
            return result;
        }
        double product = 1.0;
        ArrayList<Integer> indexOfZero = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                indexOfZero.add(i);
            } else {
                product *= nums[i];
            }
        }

        //check if there are multiple zeros, if yes, everything is zero
        if(indexOfZero.size() > 1) {
            return result;
        } else if (indexOfZero.size() == 1) {
            result[indexOfZero.get(0)] = (int)product;
            return result;
        } 

        for(int i = 0; i < nums.length; i++) {
            result[i] = (int)(product * Math.pow(nums[i], -1));
        }
        return result;
    }
}  
