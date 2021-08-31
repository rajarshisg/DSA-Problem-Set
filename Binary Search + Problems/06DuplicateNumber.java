/* Question Link - https://leetcode.com/problems/find-the-duplicate-number/ */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        //we use the property that before the single ele
        //the elements to it's left have first duplicate value at even and second at odd index
        //whereas elements to it's right have first odd and second value at even index
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            int left = (mid - 1 >= 0) ? (nums[mid - 1]) : Integer.MIN_VALUE;
            int right = (mid + 1 < nums.length) ? (nums[mid + 1]) : Integer.MIN_VALUE;
            
            if(nums[mid] != left && nums[mid] != right) return nums[mid];
            
            if(mid % 2 == 0) {
                if(left == nums[mid]) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if(left == nums[mid]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}